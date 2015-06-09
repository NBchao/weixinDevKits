package org.weixin4j.spi;

import java.util.List;

/**
 * SendPicsInfo业务
 *
 * @author qsyang
 * @version 1.0
 */
public class SendPicsInfo {

    private int Count;
    private List<PicList> PicList;

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<PicList> getPicList() {
        return PicList;
    }

    public void setPicList(List<PicList> PicList) {
        this.PicList = PicList;
    }
}
