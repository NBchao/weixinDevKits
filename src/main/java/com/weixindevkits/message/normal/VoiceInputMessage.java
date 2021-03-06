package com.weixindevkits.message.normal;

import com.weixindevkits.message.MsgType;
import com.weixindevkits.message.normal.NormalMessage;

/**
 * 语音消息
 *
 * @author NBchao
 * @version 1.0
 */
public class VoiceInputMessage extends NormalMessage {

    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    //语音格式，如amr，speex等
    private String Format;
    //语音识别结果，使用UTF8编码
    private String Recognition;

    @Override
    public String getMsgType() {
        return MsgType.Voice.toString();
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String MediaId) {
        this.MediaId = MediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String Recognition) {
        this.Recognition = Recognition;
    }

}
