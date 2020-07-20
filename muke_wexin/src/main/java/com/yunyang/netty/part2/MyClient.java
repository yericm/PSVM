package com.yunyang.netty.part2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author yeric
 * @date 2020/7/15 23:38
 */
public class MyClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new MyClientInitizer());
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8899).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            eventExecutors.shutdownGracefully();
        }
    }
}
