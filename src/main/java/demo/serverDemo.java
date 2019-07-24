package demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class serverDemo extends Thread {
    private ServerSocket serverSocket;
    public serverDemo(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务端: " + serverSocket.getLocalSocketAddress() + " 已建立");
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true){
            try{
                System.out.println("等待客户端连接...");
                Socket server = serverSocket.accept();
                System.out.println("客户端: " + server.getRemoteSocketAddress() + " 已连接");

                //从输入流中读取信息
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("客户端消息: " + in.readUTF());

                //往输出流中写入信息
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("welcome from " + server.getLocalSocketAddress());

                server.close();
            }
            catch (SocketTimeoutException s){
                System.out.println("Socket timed out!");
                break;
            }
            catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args){
        int port = Integer.parseInt(args[0]);
        try{
            Thread t = new serverDemo(port);
            t.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
