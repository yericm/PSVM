package com.bywin.netty.chapter3;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * 处理消息的handler
 *
 * @author yeric
 * @date 2020/7/7 23:03
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    // 用于记录和管理所有客户端的channel
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 获取客户端消息
        String text = msg.text();
        System.out.println("接收到的消息是：" + text);
//        for (Channel channel : channels) {
            channels.writeAndFlush(new TextWebSocketFrame("时间" + DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"
                    + ": ") + text));
//        }
    }

    /**
     * 当客户端连接服务端以后打开连接
     * 获取客户端的channel,并且放到CHannelGroup中管理
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);
        channels.add(ctx.channel());
    }

    /**
     * 当触发handlerRemoved会自动关闭相应的channel
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开，长ID为：" + ctx.channel().id().asLongText());
        System.out.println("客户端断开，短ID为：" + ctx.channel().id().asShortText());
    }
}
