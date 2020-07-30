package com.caifu.service;

import com.caifu.pojo.JxBigscreenInterval;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 军休大屏滚动间隔时间（秒）  服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
public interface JxBigscreenIntervalService extends IService<JxBigscreenInterval> {
    /**
     * 功能描述: 获取大屏滚动时间
     *
     * @param: []
     * @return: com.caifu.pojo.JxBigscreenInterval
     * @auther: tian
     * @date: 2020/7/28 10:52
     */
    JxBigscreenInterval getBigscreenInterval();

    /**
     *
     * 功能描述: 修改大屏滚动时间
     *
     * @param: []
     * @return: void
     * @auther: tian
     * @date: 2020/7/28 10:54
     */
    void setBigscreenInterval(String second);
}
