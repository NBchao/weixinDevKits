/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixindevkits.org/sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weixindevkits.spi;

import com.weixindevkits.message.OutputMessage;
import com.weixindevkits.message.normal.ImageInputMessage;
import com.weixindevkits.message.normal.LinkInputMessage;
import com.weixindevkits.message.normal.LocationInputMessage;
import com.weixindevkits.message.normal.NormalMessage;
import com.weixindevkits.message.normal.ShortVideoInputMessage;
import com.weixindevkits.message.normal.TextInputMessage;
import com.weixindevkits.message.normal.VideoInputMessage;
import com.weixindevkits.message.normal.VoiceInputMessage;
import com.weixindevkits.message.output.TextOutputMessage;

/**
 * <p>
 * Title: 微信公众平台接受消息处理器</p>
 *
 * <p>
 * Description: 此消息处理器只负责接收消息和返回已收到消息的功能，无特殊功能。</p>
 *
 * @author NBchao
 */
public class DefaultNormalMessageHandler implements INormalMessageHandler {

    private OutputMessage allType(NormalMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage textTypeMsg(TextInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage msg) {
        return allType(msg);
    }
}
