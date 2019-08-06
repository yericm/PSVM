package com.bywin.mail.controller;

import com.bywin.mail.config.ReceiveConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

/**
 * Spring Boot使用JavaMailSender发送邮件
 * created by yeric on 2019/7/30
 */
@RestController
@RequestMapping("/mail")
@Slf4j
@EnableConfigurationProperties(ReceiveConfig.class)
@Api(description = "发送邮件")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    /**
     * 该配置只是为了测试@ConfigurationProperties功能
     */
    @Autowired
    private ReceiveConfig receiveConfig;

    @ApiOperation(value = "只有内容的邮件功能")
    @GetMapping("/send")
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getUsername());
        message.setTo(receiveConfig.getAddress());
        message.setSubject("主题1");
        message.setText("内容1");
        try {
            mailSender.send(message);
            log.info("测试邮件已发送");
        } catch (MailException e) {
            e.printStackTrace();
            log.error("测试邮件发送失败了");
        }
    }

    @GetMapping("/send2")
    public void sendMain2() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");//指定邮件的发送服务器地址
        props.put("mail.smtp.auth", "true");//服务器是否要验证用户的身份信息

        Session session = Session.getInstance(props);//得到Session
        session.setDebug(true);//代表启用debug模式，可以在控制台输出smtp协议应答的过程


        //创建一个MimeMessage格式的邮件
        MimeMessage message = new MimeMessage(session);

        //设置发送者
        Address fromAddress = new InternetAddress("yerikm@163.com");//邮件地址
        message.setFrom(fromAddress);//设置发送的邮件地址
        //设置接收者
        Address toAddress = new InternetAddress("290494469@qq.com");//要接收邮件的邮箱
        message.setRecipient(MimeMessage.RecipientType.TO, toAddress);//设置接收者的地址

        //设置邮件的主题
        message.setSubject("主题2");
        //设置邮件的内容
        message.setText("内容2");
        //保存邮件
        message.saveChanges();


        //得到发送邮件的服务器(这里用的是smtp服务器)
        Transport transport = session.getTransport("smtp");

        //发送者的账号连接到smtp服务器上  @163.com可以不写
        transport.connect("smtp.163.com", "yerikm", "mini1027");
        //发送信息
        transport.sendMessage(message, message.getAllRecipients());
        //关闭服务器通道
        transport.close();
    }

    /**
     * 发送带有附件的邮件
     */
    @ApiOperation(value = "带附件的邮件功能")
    @GetMapping("/send3")
    public void sendMail3() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(mailProperties.getUsername());
        helper.setTo(receiveConfig.getAddress());
        helper.setSubject("主题：发送有附件的邮件");
        helper.setText("你好，我是小黄，我正在测试发送一封有附件的邮件。");
        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\yerik\\Desktop\\linux常用指令.txt"));
        helper.addAttachment("附件1.txt", fileSystemResource);
        try {
            mailSender.send(mimeMessage);
            log.info("小黄的测试带附件的邮件已发送。");
        } catch (MailException e) {
            e.printStackTrace();
            log.error("发送失败：带附件的邮件。");
        }
    }

    /**
     * 嵌入静态资源
     * @throws Exception
     */
    @ApiOperation(value = "嵌入静态资源的邮件功能")
    @GetMapping("/send4")
    public void sendMail4() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(mailProperties.getUsername());
        helper.setTo(receiveConfig.getAddress());
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:xihu\" ></body></html>", true);

        // 注意addInline()中资源名称 hello 必须与 text正文中cid:hello对应起来
        FileSystemResource file1 = new FileSystemResource(new File("C:\\Users\\yerik\\Desktop\\timg.jpg"));
        helper.addInline("xihu", file1);
        try {
            mailSender.send(mimeMessage);
            log.info("小黄的测试嵌入静态资源的邮件已发送。");
        } catch (Exception e) {
            log.error("小黄发送嵌入静态资源的邮件时发生异常了！", e);
        }
    }
}
