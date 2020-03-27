package com.epipe.entity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 邮件内容模板生产工厂类
 * 
 * @author liyuexuan
 * @Description:
 * @project mailUtil
 */
public class TemplateFactory {
	// 日志记录对象
	private static Logger log = LoggerFactory.getLogger(TemplateFactory.class);
	// 模板文件路径
	private static String templatePath = "/template";
	// 模板文件内容编码
	private static final String ENCODING = "utf-8";
	// 模板生成配置
	private static Configuration conf = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
	// 邮件模板缓存池
	private static Map<String, Template> tempMap = new HashMap<String, Template>();
	static {
		// 设置模板文件路径
		conf.setClassForTemplateLoading(TemplateFactory.class, templatePath);
		conf.setEncoding(Locale.CHINA, "UTF-8");
	}

	/**
	 * 通过模板文件名称获取指定模板
	 *
	 * @author liyuexuan
	 * @param name
	 *            模板文件名称
	 * @return Template 模板对象
	 * @throws IOException
	 * @Description:
	 * @return Template
	 */
	private static Template getTemplateByName(String name) throws IOException {
		if (tempMap.containsKey(name)) {
			log.debug("the template is already exist in the map,template name :"
					+ name);
			// 缓存中有该模板直接返回
			return tempMap.get(name);
		}
		// 缓存中没有该模板时，生成新模板并放入缓存中
		Template temp = conf.getTemplate(name,"UTF-8");
		tempMap.put(name, temp);
		log.debug("the template is not found  in the map,template name :"
				+ name);
		return temp;
	}


	/**
	 * 将对象填充到模版中
	 * @param name
	 * @param object
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String generateHtmlFromFtl(String name,
											 Object object) throws IOException, TemplateException {
		Writer out = new StringWriter(2048);
		Template temp = getTemplateByName(name);
		temp.setEncoding(ENCODING);
		temp.process(object, out);
		return out.toString();
	}

	public static void main(String[] args) throws IOException {
		Template t=getTemplateByName("template.ftl");
		System.out.println(t);
	}


}
