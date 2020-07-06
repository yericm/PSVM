package com.bywin.netty.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;


/**
 * 创建自定义助手类
 *
 * @author yeric
 * @date 2020/7/6 23:16
 */
public class CustomerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress());
        // 定义发送的数据消息
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello netty", Charset.defaultCharset());
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
        ctx.writeAndFlush(response);
    }
}
