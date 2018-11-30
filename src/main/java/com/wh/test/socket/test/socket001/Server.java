package com.wh.test.socket.test.socket001;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
Java共支持3种网络编程模型
1.BIO 同步阻塞     在网络应用程序获取网络数据时，如果网络传输数据很慢，那么程序就一直等着，直到传输完毕为止。
2.NIO 同步非阻塞   无需等待，直接获取数据，在数据没有传输完毕时，不获取数据，数据暂时放在缓冲区，等传输完毕以后，缓冲区发出通知，客户端获取数据，实现不等待。
3.AIO 异步非阻塞
 */

/**
 * 同步阻塞BIO
 */
public class Server {
    final static int PORT = 8765;

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        server = new ServerSocket(PORT);
        Socket socket = null;
        System.out.println("server start,阻塞着，等待的通信");
        /*
        1.传统的方式：一个客户端对应一个线程，导致系统压力大
         */
        //进行阻塞
        //socket = server.accept();
        //传统的方式   新建一个线程执行客户端的任务
        // new Thread(new ServerHandler(socket)).start();//服务端运行，等待客户端连接

        //2.伪异步实现 线程池方式
        HandlerExecutorPool executorPool = new HandlerExecutorPool(50, 1000);
        while(true){
            socket = server.accept();
            executorPool.execute(new ServerHandler(socket));
        }
    }
}
