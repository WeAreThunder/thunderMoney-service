package com.thunder.money;



import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XIANGYANG on 2015-7-3.
 */
public class HttpToWebservice {
    private Log logger = LogFactory.getLog(this.getClass());

    private String serverUrl;
    private HttpClient httpclient = null;
    private HttpPost httppost = null;
//    private static String rootPath= Constant.ROOT_PATH;
//    private static final String filePathBody = rootPath + "test\\virtualMessage\\request\\";
//    private static final String filePathResPonse = rootPath + "test\\virtualMessage\\response\\";
    public static void main(String[] args) {
        String bsnCode = "UPC040.accountBalanceQuery";
//        String fileName= filePathBody+bsnCode+".txt";
        try {
//
            //读取报文体
//            String xmlmsg2 = ioMesthod(fileName);
            String Code = "000225";
            String AcctNo = "01-01-000225-01";
            String strBeginDate = "2020-01-17";
            String strEndDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String xmlmsg2 = " <soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:quer='http://interfaceplatform.webservice.iss.com/server/querytrans/'>"
                    + " <soapenv:Header/><soapenv:Body>"
                    + " <quer:DEALQUERYTRANS>"
//                + " <TX><TRANS_CODE>UPC040</TRANS_CODE><UNIQUE_CODE>000001223</UNIQUE_CODE>"
                    + " <TX><TRANS_CODE>UPC040</TRANS_CODE><UNIQUE_CODE>000001242</UNIQUE_CODE>"
                    + " <SOURCE_CODE>17</SOURCE_CODE><TX_INFO>"
                    + " <ACCT><CLIENT_CODE>"
                    + Code
                    + "</CLIENT_CODE>"
                    + " <ACCT_NO>"
                    + AcctNo
                    + "</ACCT_NO>"
                    + " <ACCT_PROPERTY>2</ACCT_PROPERTY>"
                    + " <BEGIN_DATE>"
                    + strBeginDate
                    + "</BEGIN_DATE>"
                    + " <END_DATE>"
                    + strEndDate
                    + "</END_DATE><MIN_AMOUNT>"
                    + " </MIN_AMOUNT><MAX_AMOUNT></MAX_AMOUNT> "
                    + "<INCEXP_CODE></INCEXP_CODE></ACCT></TX_INFO></TX>"
                    + " </quer:DEALQUERYTRANS></soapenv:Body></soapenv:Envelope>";
//        	String aaa = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:kjt365tobank.wsdl\"><soapenv:Header/><soapenv:Body><urn:kjt365tobank11><kjt365tobank11Input><merid>1</merid><operName>2</operName><downBsns>3</downBsns></kjt365tobank11Input></urn:kjt365tobank11></soapenv:Body></soapenv:Envelope>";

            HttpToWebservice client = new HttpToWebservice();
//            String serverUrl = "http://172.20.130.52:7003/cplink/EMPWebService/EMPWebService/accountBalanceQuery";
            String serverUrl = "http://172.16.90.27:7003/cplink/EMPWebService/accountBalanceQuery";
            String rtnDatagram = client.doPost(serverUrl, /*ss1+message+ss2*/xmlmsg2, "utf8");
            System.out.println(rtnDatagram);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String ioMesthod( String filePath) throws IOException, IOException{
        String xmlmsg = null;
        InputStream input = null;
        try {
            input = new FileInputStream(new File(filePath));
            byte[] buf = new byte[1024];
            StringBuffer sb = new StringBuffer();
            int len = 0 ;
            while((len = input.read(buf))!=-1){
                sb.append(new String(buf,0,len,"utf8"));
            }
            xmlmsg = sb.toString().replaceAll("", "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(null!=input){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        return xmlmsg ;

    }

    private void init(String serverUrl) {

        this.serverUrl = serverUrl;
        try {
            httpclient = new DefaultHttpClient();
            //请求超时
            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000 * 2);
            //读取超时
            httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000 * 5);
            httppost = new HttpPost(serverUrl);
            httppost.getURI();
        } catch (Exception e) {
            logger.error("初始化http网关错误!URL: " + serverUrl, e);
            httpclient.getConnectionManager().shutdown();
            throw new RuntimeException(e);
        }
    }

    public String doPost(String serverUrl, String datagram, String charsetName) {
        String responseBody = null;
        String errmsg = "";
        try {
            init(serverUrl);
            StringEntity xmlSE = new StringEntity(datagram, charsetName);
            httppost.setEntity(xmlSE);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
//            responseBody = httpclient.execute(httppost, responseHandler);

            httppost.setHeader("Content-Type", "text/xml;charset=UTF-8");

            /*httppost.setHeader("accept-encoding", "gzip");
            httppost.setHeader("accept-encoding", "deflate");
            httppost.setHeader("user-agent", "Apache-HttpClient/4.1.1 (java 1.5)");*/
//            httppost.setHeader("SOAPAction", "kjt365tobank11");

            HttpResponse httpResponse = httpclient.execute(httppost);
//            String charset = EntityUtils.getContentCharSet(httpResponse.getEntity());
            // 设置字符集，以防乱码
            responseBody = EntityUtils.toString(httpResponse.getEntity(), charsetName);
        } catch (UnsupportedEncodingException e) {
            errmsg = "Http接口通讯报文格式转换错误!";
            logger.error(errmsg, e);
            throw new RuntimeException(errmsg, e);
        } catch (IOException e) {
            errmsg = "与Http接口通讯连接错误!";
            logger.error(errmsg, e);
            throw new RuntimeException(errmsg, e);
        } catch (Exception e) {
            errmsg = "Http接口的通讯错误!";
            logger.error(errmsg, e);
            throw new RuntimeException(errmsg, e);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        if (StringUtils.isEmpty(responseBody)) {
            throw new RuntimeException("通讯可能出现错误，返回报文为空！");
        } else {
            logger.info("HttpClient接收报文内容：\n" + responseBody);
        }
        return responseBody;
    }


    private void doGet() {
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,2000);//连接超时时间设置
        HttpGet httpget = new HttpGet("http://localhost:62003/nettyHttp");
        try {
            HttpResponse response = null;
            response = httpClient.execute(httpget);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                StringBuffer sb=new StringBuffer();
                InputStream instream = entity.getContent();
                int l;
                byte[] tmp = new byte[2048];
                while ((l = instream.read(tmp)) != -1) {
                    sb.append(new String(tmp, 0, l));
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            httpClient.getConnectionManager().shutdown();
        }
    }

    public static String rightPad4ChineseToByteLength(String srcStr,
                                                      int totalByteLength, String padStr) {
        if (srcStr == null) {
            return null;
        }
        int srcByteLength = srcStr.getBytes().length;

        if (padStr == null || "".equals(padStr)) {
            padStr = " ";
        } else if (padStr.getBytes().length > 1 || totalByteLength <= 0) {
            throw new RuntimeException("参数错误");
        }
        StringBuilder rtnStrBuilder = new StringBuilder();
        if (totalByteLength >= srcByteLength) {
            rtnStrBuilder.append(srcStr);
            for (int i = 0; i < totalByteLength - srcByteLength; i++) {
                rtnStrBuilder.append(padStr);
            }
        } else {
            byte[] rtnBytes = new byte[totalByteLength];
            try {
                System.arraycopy(srcStr.getBytes("GBK"), 0, rtnBytes, 0,
                        totalByteLength);
                rtnStrBuilder.append(new String(rtnBytes, "GBK"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return rtnStrBuilder.toString();
    }

    public static byte[] readBytesFromInputStream(InputStream is)
            throws IOException {
        if (is != null) {
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] byteBuffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = bis.read(byteBuffer)) != -1) {
                baos.write(byteBuffer, 0, len);
            }
            baos.flush();
            bis.close();
            is.close();
            return baos.toByteArray();
        } else
            return null;
    }

    public static String appendStrToLength(String srcStr, String appendStr,
                                           int length) {
        int appendLength = length - srcStr.getBytes().length;
        StringBuilder strBuilder = new StringBuilder(srcStr);
        for (int i = 1; i <= appendLength; i++) {
            strBuilder.append(appendStr);
        }
        return strBuilder.toString();
    }
}
