package com.weixindevkits.message.event;

import com.weixindevkits.message.EventType;
import com.weixindevkits.message.ScanCodeInfo;

/**
 * 自定义菜单事件
 *
 * 扫码推事件的事件推送
 *
 * @author NBchao
 * @version 1.0
 */
public class ScanCodePushEventMessage extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;
    //扫描信息
    private ScanCodeInfo ScanCodeInfo;

    @Override
    public String getEvent() {
        return EventType.Scancode_Push.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo ScanCodeInfo) {
        this.ScanCodeInfo = ScanCodeInfo;
    }

}
