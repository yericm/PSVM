package com.yunyang.muke.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @author yeric
 * @date 2020/7/6 23:53
 */
@Component
public class WssServer {
    private static class SingletionWssServer {
        static final WssServer instance = new WssServer();
    }

    public static WssServer getInstance() {
        return SingletionWssServer.instance;
    }

    private EventLoopGroup boosGroup;
    private NioEventLoopGroup workerGroup;
    private ServerBootstrap serverBootstrap;
    private ChannelFuture channelFuture;

    public WssServer () {
        boosGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosGroup, workerGroup) // 设置主从线程组
                .channel(NioServerSocketChannel.class) // 设置nio的双向通道
                .childHandler(new WssServerInitizer()); // 子处理器，用于处理workerGroup
    }

    public void start () {
        this.channelFuture = serverBootstrap.bind(8089);
        System.out.println("netty启动完毕");
    }
}
