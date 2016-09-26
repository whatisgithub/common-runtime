package com.qmcaifu.common.service;

/**
 * Created by nihao on 2016/9/21.
 */
public interface MQService {

    /**
     * 默认采用直连交换机
     * @param routeKey 匹配key
     * @param msg 消息内容转化为json后传输
     */
    public void send(String routeKey, Object msg);
}
