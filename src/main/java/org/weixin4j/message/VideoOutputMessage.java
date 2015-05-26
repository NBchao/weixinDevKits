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
 * 这个类实现了<tt>OutputMessage</tt>，用来回复视频消息
 *
 * <p>提供了获取视频Id<code>getMediaId()</code>等主要方法.</p>
 *
 * @author weixin4j<weixin4j@ansitech.com>
 */
public class VideoOutputMessage extends OutputMessage {

    /**
     * 消息类型:视频消息
     */
    private String MsgType = "video";
    /**
     * 通过上传多媒体文件，得到的id
     */
    private Video Video;

    /**
     * 创建一个新的 Output Message.并且MsgType的值为text.
     */
    public VideoOutputMessage() {
    }

    /**
     * 创建一个自定义视频Id mediaId的Output Message.
     *
     * @param MediaId 视频资源Id
     */
    public VideoOutputMessage(Video video) {
        Video = video;
    }

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    /**
     * 获取 通过上传多媒体文件，得到的id
     *
     * @return 通过上传多媒体文件，得到的id
     */
    public Video getVideo() {
        return Video;
    }

    /**
     * 设置 通过上传多媒体文件，得到的id
     *
     * @param video 通过上传多媒体文件，得到的id
     */
    public void setVideo(Video video) {
        Video = video;
    }
}