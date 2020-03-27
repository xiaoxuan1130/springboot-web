package com.epipe.entity;

import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class PDFTemplateUtil {
    /**
     * 通过模板导出pdf文件
     *
     * @param html             html模板
     * @throws Exception
     */
    public static ByteArrayOutputStream createPDF(String html) throws Exception {
        ITextRenderer renderer = new ITextRenderer();
        OutputStream out = new ByteArrayOutputStream();
        try {
            // 设置 css中 的字体样式（暂时仅支持宋体和黑体） 必须，不然中文不显示
            renderer.getFontResolver().addFont("/template/font/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 把html代码传入渲染器中
            renderer.setDocumentFromString(html);
            // 设置模板中的图片路径 （这里的images在resources目录下） 模板中img标签src路径需要相对路径加图片名 如<img src="images/xh.jpg"/>
           // String url = PDFTemplateUtil.class.getClassLoader().getResource("images").toURI().toString();
           // renderer.getSharedContext().setBaseURL(url);
            renderer.layout();
            renderer.createPDF(out, false);
            renderer.finishPDF();
            out.flush();
            return (ByteArrayOutputStream) out;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
