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
package org.weixin4j.message;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复音乐消息
 *
 * <p>提供了获取音乐链接<code>getMusicURL()</code>等主要方法.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class MusicOutputMessage extends OutputMessage {

    /**
     * 消息类型:音乐消息
     */
    private String MsgType = "music";
    /**
     * 音乐消息对象
     */
    private Music Music;

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    public MusicOutputMessage(Music music) {
        super();
        Music = music;
    }

    /**
     * @return the Music
     */
    public Music getMusic() {
        return Music;
    }

    /**
     * @param Music the Music to set
     */
    public void setMusic(Music Music) {
        this.Music = Music;
    }
}
