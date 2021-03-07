package com.thunder.money;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test2048 {

    private static final int width = 4;
    private static final int high = 4;

    public static void main(String[] args) throws IOException {
        System.out.println("-----------Start!---------");
        int[][] start = start();
        show(start);
        Scanner sc = new Scanner(System.in);
        int moveNum = 0;
        String ass = null;
        int[][] move = null;
        while (true) {
            if (moveNum > 0 && ass.equals("q")) {
                break;
            }
            // w up,a left,s down, d right ,and q quit
            ass = sc.next();
            moveNum++;
            if (moveNum == 1) {
                move = move(start, ass);
            } else {
                move = move(move, ass);
                int i = judgeWinOrLoss(move);
                if (i==1){
                    System.out.println("WIN");
                    break;
                }else if (i==2){
                    System.out.println("LOSS");
                    break;
                }
            }
            show(move);
        }
        System.out.println("------------END-----------");
        System.out.println();
    }

    public static int judgeWinOrLoss(int[][] box) {
        // 0 next; 1 win; 2 loss;
        int num = 0;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 2048) {
                    return 1;
                }
                if (box[i][j] != 0){
                    num++;
                }
            }
        }
        if (num == high*width){
            return 2;
        }
        return 0;
    }

    public static void show(int[][] box) {
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (j==0){
                    System.out.print(" ");
                    System.out.print("+-----");
                }else if (j==width -1){
                    System.out.print("+-----");
                    System.out.println("+");
                }else {
                    System.out.print("+-----");
                }
            }
            for (int j = 0; j < high; j++) {
                if (j == 0) {
                    System.out.print(' ');
                }
                System.out.print("|");
                if (box[i][j] <= 9) {
                    System.out.print("  ");
                    System.out.print(box[i][j]);
                    System.out.print("  ");
                } else if (box[i][j] >= 10 && box[i][j] < 100) {
                    System.out.print(" ");
                    System.out.print(box[i][j] / 10);
                    System.out.print(" ");
                    System.out.print(box[i][j] % 10);
                    System.out.print(" ");
                } else if (box[i][j] >= 100) {
                    System.out.print(box[i][j] / 100);
                    System.out.print(" ");
                    System.out.print(box[i][j] / 10 % 10);
                    System.out.print(" ");
                    System.out.print(box[i][j] % 10);

                }
                if (j == high - 1) {
                    System.out.println("|");
                }
            }
            if (i == width - 1) {
                for (int j = 0; j < width; j++) {
                    if (j==0){
                        System.out.print(" ");
                        System.out.print("+-----");
                    }else if (j==width -1){
                        System.out.print("+-----");
                        System.out.println("+");
                    }else {
                        System.out.print("+-----");
                    }
                }
            }
        }


    }

    public static int[][] start() {
        int[][] box = new int[high][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < high; j++) {
                box[i][j] = 0;
            }
        }
        Random random = new Random();
        int i = random.nextInt(width * high);
        box[i / width][i % high] = 2;

        int j = random.nextInt(width * high);
        while (i == j) {
            j = random.nextInt(width * high);
        }
        box[j / width][j % high] = 2;
        return box;
    }

    public static int[][] move(int[][] box, String move) {
        Random random = new Random();
        int insertWidthLocal = random.nextInt(width);
        int insertHighLocal = random.nextInt(high);

        switch (move) {
            case "w":
                //上
                for (int j = 0; j < width; j++) {
                    int[] oneLine = new int[high];
                    for (int i = 0; i < high; i++) {
                        oneLine[i] = box[i][j];
                    }
                    int[] ints = deleteZero(oneLine);
                    int[] merge = merge(ints);
                    for (int i = 0; i < high; i++) {
                        box[i][j] = merge[i];
                    }
                }
                //增加随机值
                while (box[high - 1][insertWidthLocal] != 0) {
                    insertWidthLocal = random.nextInt(width);
                }
                box[high - 1][insertWidthLocal] = 2;
                break;
            case "s":
                //下
                for (int j = 0; j < width; j++) {
                    int[] oneLine = new int[high];
                    for (int i = 0; i < high; i++) {
                        oneLine[i] = box[i][j];
                    }
                    int[] ints1 = qAp(oneLine);
                    int[] ints = deleteZero(ints1);
                    int[] merge = merge(ints);
                    int[] merge1 = qAp(merge);
                    for (int i = 0; i < high; i++) {
                        box[i][j] = merge1[i];
                    }
                }
                //增加随机值
                while (box[0][insertWidthLocal] != 0) {
                    insertWidthLocal = random.nextInt(width);
                }
                box[0][insertWidthLocal] = 2;
                break;
            case "a":
                //左
                for (int i = 0; i < high; i++) {
                    int[] oneLine = new int[width];
                    for (int j = 0; j < width; j++) {
                        oneLine[j] = box[i][j];
                    }
                    int[] ints = deleteZero(oneLine);
                    int[] merge = merge(ints);
                    for (int j = 0; j < width; j++) {
                        box[i][j] = merge[j];
                    }
                }
                //增加随机值
                while (box[insertHighLocal][width - 1] != 0) {
                    insertHighLocal = random.nextInt(high);
                }
                box[insertHighLocal][width - 1] = 2;
                break;
            case "d":
                //右
                for (int i = 0; i < high; i++) {
                    int[] oneLine = new int[width];
                    for (int j = 0; j < width; j++) {
                        oneLine[j] = box[i][j];
                    }
                    int[] ints1 = qAp(oneLine);
                    int[] ints = deleteZero(ints1);
                    int[] merge = merge(ints);
                    int[] merge1 = qAp(merge);
                    for (int j = 0; j < width; j++) {
                        box[i][j] = merge1[j];
                    }
                }
                //增加随机值
                while (box[insertHighLocal][0] != 0) {
                    insertHighLocal = random.nextInt(high);
                }
                box[insertHighLocal][0] = 2;
                break;
        }


        return box;
    }

    //删0 补0
    public static int[] deleteZero(int[] oneLine) {
        int[] newLine = new int[width];
        int k = 0;
        for (int i = 0; i < oneLine.length; i++) {
            if (oneLine[i] != 0) {
                newLine[k] = oneLine[i];
                k++;
            }
        }
        //末尾补0
        for (; k < width; k++) {
            newLine[k] = 0;
        }
        return newLine;
    }

    //合并
    public static int[] merge(int[] oneLine) {
        int[] newLine = new int[width];
        int k = 0;
        for (int i = 0; i < oneLine.length; i++) {
            //相邻相同便合并
            if (i < oneLine.length - 1 && oneLine[i] == oneLine[i + 1]) {
                newLine[k] = oneLine[i] * 2;
                oneLine[i + 1] = 0;
                k++;
            } else if (oneLine[i] != 0) {
                newLine[k] = oneLine[i];
                k++;
            }
        }
        //末尾补0
        for (; k < width; k++) {
            newLine[k] = 0;
        }
        return newLine;
    }

    //前后翻转
    public static int[] qAp(int[] oneLine) {
        int[] newLine = new int[width];
        for (int i = 0; i < oneLine.length; i++) {
            newLine[oneLine.length - 1 - i] = oneLine[i];
        }
        return newLine;
    }

}
