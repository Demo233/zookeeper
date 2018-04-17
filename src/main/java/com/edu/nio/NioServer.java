package com.edu.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO实现server
 */
public class NioServer {

    public static void main(String[] args) throws Exception{

        // 开启ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 从ssc中获取ServerSocket
        ServerSocket ss = ssc.socket();
        // 设置地址重用
        ss.setReuseAddress(true);
        // 绑定地址,监听端口
        ss.bind(new InetSocketAddress("localhost",3518));
        //设置缓冲区
        ByteBuffer b = ByteBuffer.allocate(4096);
        while(true){
            // 读数据
            SocketChannel channel = ssc.accept();
            // 设置阻塞模式接不到就停止
            channel.configureBlocking(true);
            // 将channel中的数据读到缓冲区,打印出来
            channel.read(b);
            String str = new String(b.array(), 0, b.position());
            System.out.println(str);
        }


    }


}