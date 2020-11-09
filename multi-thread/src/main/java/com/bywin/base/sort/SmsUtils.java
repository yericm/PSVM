package com.bywin.base.sort;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yeric
 * @date 2020/8/25 20:21
 */
@Slf4j
@Component
public class SmsUtils {
    private final static String REGION_ID = "cn-hangzhou";
    private final static String SIGN_NAME = "唐宋";

    @Value("${aliyun.note.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.note.accessKeySecret}")
    private String accessSecret;
    @Value("${aliyun.note.sendVerificationCode}")
    public String sendVerificationCode;

    /**
     * 发送短信
     *
     * @param phoneNumber  手机号
     * @param templateParam 短信模板变量对应的实际值，JSON格式。
     *                      如果JSON中需要带换行符，请参照标准的JSON协议处理。
     * @return
     */
    public JSONObject sendMsg(String phoneNumber, String templateParam) {
        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", sendVerificationCode);
        request.putQueryParameter("TemplateParam", templateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("短信发送结果: {}",response.getData());
            JSONObject result = JSONObject.parseObject(response.getData());
            return result;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
