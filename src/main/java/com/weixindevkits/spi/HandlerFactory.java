package com.weixindevkits.spi;

import com.weixindevkits.Configuration;

/**
 * 输入消息处理器工具类
 *
 * @author NBchao
 * @version 1.0
 */
public class HandlerFactory {

    private static IMessageHandler messageHandler = null;
    private static String defaultHandler = "org.weixindevkits.spi.DefaultMessageHandler";

    public static IMessageHandler getMessageHandler() {
        if (messageHandler == null) {
            try {
                //获取
                defaultHandler = Configuration.getProperty("weixindevkits.handler", defaultHandler);
                if (Configuration.isDebug()) {
                    System.out.println("微信输入消息处理Hanler:" + defaultHandler);
                }
                // 加载处理器
                Class<?> clazz = Class.forName(defaultHandler);
                try {
                    messageHandler = (IMessageHandler) clazz.newInstance();
                } catch (Exception ex) {
                    System.out.println("初始化 IMessageHandler 异常：");
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("找不到: " + defaultHandler + " 类!");
                ex.printStackTrace();
            }
        }
        return messageHandler;
    }

    private static INormalMessageHandler normalMessageHandler = null;
    private static String defaultNormalHandler = "org.weixindevkits.spi.DefaultNormalMessageHandler";

    public static INormalMessageHandler getNormalMessageHandler() {
        if (normalMessageHandler == null) {
            try {
                //获取
                defaultNormalHandler = Configuration.getProperty("weixindevkits.message.handler.normal", defaultNormalHandler);
                if (Configuration.isDebug()) {
                    System.out.println("微信接受消息处理Hanler:" + defaultNormalHandler);
                }
                // 加载处理器
                Class<?> clazz = Class.forName(defaultNormalHandler);
                try {
                    normalMessageHandler = (INormalMessageHandler) clazz.newInstance();
                } catch (Exception ex) {
                    System.out.println("初始化 INormalMessageHandler 异常：");
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("找不到: " + defaultNormalHandler + " 类!");
                ex.printStackTrace();
            }
        }
        return normalMessageHandler;
    }

    private static IEventMessageHandler eventMessageHandler = null;
    private static String defaultEventHandler = "org.weixindevkits.spi.DefaultEventMessageHandler";

    public static IEventMessageHandler getEventMessageHandler() {
        if (eventMessageHandler == null) {
            try {
                //获取
                defaultEventHandler = Configuration.getProperty("weixindevkits.message.handler.event", defaultEventHandler);
                if (Configuration.isDebug()) {
                    System.out.println("微信接受消息处理Hanler:" + defaultEventHandler);
                }
                // 加载处理器
                Class<?> clazz = Class.forName(defaultEventHandler);
                try {
                    eventMessageHandler = (IEventMessageHandler) clazz.newInstance();
                } catch (Exception ex) {
                    System.out.println("初始化 IEventMessageHandler 异常：");
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("找不到: " + defaultEventHandler + " 类!");
                ex.printStackTrace();
            }
        }
        return eventMessageHandler;
    }
}
