package com.thunder.money;


import org.assertj.core.util.DateUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestIndexOf {
    public static void main(String[] args) throws Throwable {
//        System.out.println("getAccountDataFromBC:");
//        System.out.println(getAccountDataFromBC("01-000225","216470100100048517"));
//        System.out.println("getAccountDataFromBC:");
//        System.out.println(getAccountDataFromBC("000225","01-01-000225-01"));
        HX07_HttpLinkToCB hx07_httpLinkToCB = new HX07_HttpLinkToCB();
        String s = hx07_httpLinkToCB.httpLink(" \n" +
                "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:quer='http://interfaceplatform.webservice.iss.com/server/querytrans/'>\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <quer:DEALQUERYTRANS>\n" +
                "            <TX>\n" +
                "                <TRANS_CODE>UPC040</TRANS_CODE>\n" +
                "                <UNIQUE_CODE>000001223</UNIQUE_CODE>\n" +
                "                <SOURCE_CODE>17</SOURCE_CODE>\n" +
                "                <TX_INFO>\n" +
                "                    <ACCT>\n" +
                "                        <CLIENT_CODE>000225</CLIENT_CODE>\n" +
                "                        <ACCT_NO>01-01-000225-01</ACCT_NO>\n" +
                "                        <ACCT_PROPERTY>1</ACCT_PROPERTY>\n" +
                "                        <BEGIN_DATE>2020-07-02</BEGIN_DATE>\n" +
                "                        <END_DATE>2020-10-29</END_DATE>\n" +
                "                        <MIN_AMOUNT> </MIN_AMOUNT>\n" +
                "                        <MAX_AMOUNT></MAX_AMOUNT>\n" +
                "                        <INCEXP_CODE></INCEXP_CODE>\n" +
                "                    </ACCT>\n" +
                "                </TX_INFO>\n" +
                "            </TX>\n" +
                "        </quer:DEALQUERYTRANS>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>", "http://172.16.90.27:7003/cplink/EMPWebService/accountBalanceQuery");
        System.out.println(s);




    }

    public static String getAccountDataFromBC(String Code, String AcctNo)throws Throwable {
        String strBeginDate = "2020-01-17";
        String strEndDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String xml = " <soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:quer='http://interfaceplatform.webservice.iss.com/server/querytrans/'>"
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
                + " <ACCT_PROPERTY>1</ACCT_PROPERTY>"
                + " <BEGIN_DATE>"
                + strBeginDate
                + "</BEGIN_DATE>"
                + " <END_DATE>"
                + strEndDate
                + "</END_DATE><MIN_AMOUNT>"
                + " </MIN_AMOUNT><MAX_AMOUNT></MAX_AMOUNT> "
                + "<INCEXP_CODE></INCEXP_CODE></ACCT></TX_INFO></TX>"
                + " </quer:DEALQUERYTRANS></soapenv:Body></soapenv:Envelope>";
        URL url = new URL("http://172.16.90.27:7003/cplink/EMPWebService/accountBalanceQuery");//新地址本机测试 todo 记得修改为生产
//        URL url = new URL("http://172.16.90.27:9080/NASApp/iTreasury-tradeconnect/services/SCIP_RE_QUERYTRANSService");//新地址本机测试 todo 记得修改为生产
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Connection", "Keep-Alive");
//        conn.setRequestProperty("Charset", "UTF-8");
        byte[] data = xml.getBytes();
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));
        conn.setRequestProperty("contentType", "text/xml;Charset=UTF-8");
//        		String author = "Basic "
//				+ encode(("hongxinshebei:SFC_hx0416").getBytes());// 正式服
//        String author = "Basic " +
//                encode(("mouser:mouser2013&4").getBytes());//测试服
//        conn.setRequestProperty("Authorization", author);
        conn.connect();
        OutputStream out = conn.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            try {
                while ((str = bufferedReader.readLine()) != null) {
                    buffer.append(str);
                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                inputStream = null;
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return buffer.toString();
        } else {
            return "";
        }
    }



    public static String encode(byte[] data) {

        char[] base64EncodeChars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
                '4', '5', '6', '7', '8', '9', '+', '/' };
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                        | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                    | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2)
                    | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
}
