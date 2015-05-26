/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/sdk/
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
package org.weixin4j.spi;

import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.TextOutputMessage;

/**
 * <p>Title: 微信公众平台接受消息处理器</p>
 *
 * <p>Description: 此消息处理器只负责接收消息和返回已收到消息的功能，无特殊功能。</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class DefaultMessageHandler implements IMessageHandler {

    private OutputMessage allType(InputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage textTypeMsg(InputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationTypeMsg(InputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage imageTypeMsg(InputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage linkTypeMsg(InputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage eventTypeMsg(InputMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage voiceTypeMsg(InputMessage msg) {
        return allType(msg);
    }
}
