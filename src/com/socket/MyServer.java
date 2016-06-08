package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/5/30.
 */
public class MyServer {

    public static void main(String[] args) {

        connetToClient();
    }

    public static void connetToClient(){

        try{
            ServerSocket ss=new ServerSocket(9999);
            System.out.println("我是服务器");
            Socket s=ss.accept();
            //接收客户端发来的消息
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String message=br.readLine();
            System.out.println("服务器收到的信息是：" + message);
            //给客户端发送消息
            PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
            pw.println("你好,客户端");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
