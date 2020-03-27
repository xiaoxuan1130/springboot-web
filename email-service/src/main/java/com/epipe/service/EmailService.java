package com.epipe.service;

import com.epipe.entity.SysEmail;

public interface EmailService {

    /**
     * 邮件发送，可将附件生成pdf
     * @param sysEmail 邮件内容
     * @param object 需要填充的实体类
     */
    void sendMailByTemplate(SysEmail sysEmail,Object object);
}
