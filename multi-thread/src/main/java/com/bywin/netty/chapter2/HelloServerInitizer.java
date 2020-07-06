package com.bywin.netty.chapter2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器，channel初始化后，会执行里面的初始化方法
 * @author yeric
 * @date 2020/7/6 23:07
 */
public class HelloServerInitizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 通过channel获取对应的pipeline
        ChannelPipeline pipeline = channel.pipeline();
        // 通过管道添加handler,服务的编码解码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        pipeline.addLast("customerHandler", new CustomerHandler());
    }
}
