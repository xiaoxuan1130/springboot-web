package com.epipe.controller;

import com.epipe.entity.Quotation;
import com.epipe.entity.QuotationInfo;
import com.epipe.entity.SysEmail;
import com.epipe.service.EmailService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("email")
public class EmailController {

    @Reference
    private EmailService emailService;

    @RequestMapping("send")
    @ResponseBody
    public String sendEmail(@RequestBody SysEmail email){
        Quotation quotation=new Quotation();
        quotation.setCustomerName("xiaoxuan");
        quotation.setQuotationNo("Test00001");
        quotation.setTotalAmount(BigDecimal.valueOf(8000));
        QuotationInfo info=new QuotationInfo();
        info.setDiscount(BigDecimal.valueOf(80));
        info.setQuotaPrice(BigDecimal.valueOf(9999));
        info.setTaxRate(BigDecimal.valueOf(8.8));
        info.setTotalAmount(BigDecimal.valueOf(8000));
        List<QuotationInfo> list=new ArrayList<>();
        list.add(info);
        quotation.setList(list);
        emailService.sendMailByTemplate(email,quotation);
        return "发送成功";
    }
}
