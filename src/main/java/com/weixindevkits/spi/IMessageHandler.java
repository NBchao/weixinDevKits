package com.weixindevkits.spi;

import javax.servlet.ServletInputStream;

import com.weixindevkits.WeixinException;

/**
 * 输入消息处理器
 *
 * @author NBchao
 * @version 1.0
 */
public interface IMessageHandler {

    /**
     * 微信输入消息处理器
     *
     * @param inputStream 输入流
     * @return 返回xml格式的回复消息
     * @throws WeixinException
     */
    String invoke(ServletInputStream inputStream) throws WeixinException;

    /**
     * 微信输入消息处理器
     *
     * @param inputXml 输入xml
     * @return 返回xml格式的回复消息
     * @throws WeixinException
     */
    String invoke(String inputXml) throws WeixinException;
}
