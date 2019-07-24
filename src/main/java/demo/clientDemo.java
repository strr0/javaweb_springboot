package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class clientDemo {
    public static void main(String[] args){
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try{
            Socket client = new Socket(serverName, port);
            System.out.println("连接到服务端: " + client.getRemoteSocketAddress());

            //往输出流中写入信息
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("hello from " + client.getLocalSocketAddress());

            //从输入流中读取信息

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("服务端消息: " + in.readUTF());

            client.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
