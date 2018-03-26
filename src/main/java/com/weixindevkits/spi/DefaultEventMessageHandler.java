package com.weixindevkits.spi;

import com.weixindevkits.message.OutputMessage;
import com.weixindevkits.message.event.ClickEventMessage;
import com.weixindevkits.message.event.EventMessage;
import com.weixindevkits.message.event.LocationEventMessage;
import com.weixindevkits.message.event.LocationSelectEventMessage;
import com.weixindevkits.message.event.PicPhotoOrAlbumEventMessage;
import com.weixindevkits.message.event.PicSysPhotoEventMessage;
import com.weixindevkits.message.event.PicWeixinEventMessage;
import com.weixindevkits.message.event.QrsceneScanEventMessage;
import com.weixindevkits.message.event.QrsceneSubscribeEventMessage;
import com.weixindevkits.message.event.ScanCodePushEventMessage;
import com.weixindevkits.message.event.ScanCodeWaitMsgEventMessage;
import com.weixindevkits.message.event.SubscribeEventMessage;
import com.weixindevkits.message.event.UnSubscribeEventMessage;
import com.weixindevkits.message.event.ViewEventMessage;
import com.weixindevkits.message.output.TextOutputMessage;

/**
 * DefaultEventMessageHandler业务
 *
 * @author NBchao
 * @version 1.0
 */
public class DefaultEventMessageHandler implements IEventMessageHandler {

    private OutputMessage allType(EventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        return allType(msg);
    }

}
