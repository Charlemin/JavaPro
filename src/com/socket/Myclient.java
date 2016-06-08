package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Myclient {

    public static void main(String[] args) {

        connetToServer();
    }

    public static void connetToServer(){

        try{
            Socket s=new Socket("127.0.0.1",9999);
            System.out.println("我是客户端");
            //给服务器发送消息
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
            pw.println("你好,服务器");
            //接收服务器发来的消息
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String message=br.readLine();
            System.out.println("客户端收到的信息是：" + message);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
