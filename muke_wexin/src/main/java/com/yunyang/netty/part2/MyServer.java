package com.yunyang.netty.part2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author yeric
 * @date 2020/7/15 20:00
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        // 主线程组
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        // 从线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // netty服务器的创建， ServerBootstrap是一个启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup) // 设置主从线程组
                    .channel(NioServerSocketChannel.class) // 设置nio的双向通道
                    .childHandler(new MyServerInitizer()); // 子处理器，用于处理workerGroup
            // 同步方式启动server,并设置端口
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            // 同步方式关闭channel
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
