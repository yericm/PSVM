package com.bywin.netty.chapter3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 初始化器，channel初始化后，会执行里面的初始化方法
 * @author yeric
 * @date 2020/7/6 23:07
 */
public class WssServerInitizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 通过channel获取对应的pipeline
        ChannelPipeline pipeline = channel.pipeline();
        // websocket基于http协议，所以需要http编码解码器
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        // 对写大数据的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // 通用
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));
        // 以上用于支持http协议

        // websocket服务器处理的协议，做的事很多
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 自定义handler，读取消息
        pipeline.addLast("chatHandler", new ChatHandler());
    }
}
