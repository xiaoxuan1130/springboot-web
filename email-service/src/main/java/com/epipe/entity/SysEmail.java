package com.epipe.entity;

import java.io.Serializable;

/**
 * 邮件类
 */
public class SysEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    private String contents;		// 邮件正文
    private String subject;//邮件主题
    private String attach;//附件url
    private String copyTo;
    private String receiver;

    public String getCopyTo() {
        return copyTo;
    }

    public void setCopyTo(String copyTo) {
        this.copyTo = copyTo;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
