package com.edu.nio;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 使用nio的Channel来通信
 *
 */
public class NioClient {
    public static void main(String[] args) throws Exception{

        // 开启Channel
        SocketChannel sc = SocketChannel.open();
        // 开启端口
        sc.connect(new InetSocketAddress("localhost",3518));

        // 设置阻塞模式
        sc.configureBlocking(true);
        // 将文件链接到channel中
        FileChannel fc = new FileInputStream("/testnio.txt").getChannel();

        System.out.println(fc.transferTo(0,2048,sc));

        fc.close();
        sc.close();
    }
}