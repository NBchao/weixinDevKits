package com.weixindevkits.message.event;

import com.weixindevkits.message.EventType;

/**
 * 关注事件
 *
 * @author NBchao
 * @version 1.0
 */
public class SubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Subscribe.toString();
    }

}
