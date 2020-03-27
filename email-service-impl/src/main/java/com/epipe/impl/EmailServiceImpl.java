package com.epipe.impl;

import com.epipe.entity.SysEmail;
import com.epipe.service.EmailService;
import com.epipe.entity.MailSender;
import com.epipe.entity.TemplateFactory;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.dubbo.config.annotation.Service;
import com.epipe.utils.PropertiesUtils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

/**
 * 邮件服务实现类
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendMailByTemplate(SysEmail sysEmail, Object object) {
        //获取邮件参数
        String server=PropertiesUtils.getCommonYml("email.server").toString();
        String sender=PropertiesUtils.getCommonYml("email.sender").toString();
        String username=PropertiesUtils.getCommonYml("email.username").toString();
        String password=PropertiesUtils.getCommonYml("email.password").toString();
        String nickname=PropertiesUtils.getCommonYml("email.nickname").toString();
        MailSender mail = new MailSender(server);
        mail.setNeedAuth(true);
        mail.setNamePass(username, password, nickname);
        //正文
        String content = null;
        //附件
        String attach=null;
        try {
            content = TemplateFactory.generateHtmlFromFtl("template_2.ftl", object);
            attach=TemplateFactory.generateHtmlFromFtl("template.ftl",object);
            mail.setSubject(sysEmail.getSubject());
            //设置附件
            mail.setAttach(attach,"测试附件");
            String contents= StringEscapeUtils.unescapeHtml4(content);
            mail.setBody(contents);
            mail.setReceiver(sysEmail.getReceiver());
            mail.setCopyTo(sysEmail.getCopyTo());
            mail.setSender(sender);
            mail.sendout();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
