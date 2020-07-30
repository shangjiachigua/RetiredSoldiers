package com.caifu.service.impl;

import com.caifu.pojo.JxBigscreenInterval;
import com.caifu.mapper.JxBigscreenIntervalMapper;
import com.caifu.service.JxBigscreenIntervalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 军休大屏滚动间隔时间（秒）  服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
@Service
public class JxBigscreenIntervalServiceImpl extends ServiceImpl<JxBigscreenIntervalMapper, JxBigscreenInterval> implements JxBigscreenIntervalService {

    @Autowired
    private JxBigscreenIntervalMapper jxBigscreenIntervalMapper;

    @Override
    public JxBigscreenInterval getBigscreenInterval() {
        return jxBigscreenIntervalMapper.selectById(1);
    }

    @Override
    public void setBigscreenInterval(String second) {
        JxBigscreenInterval jxBigscreenInterval = new JxBigscreenInterval();
        jxBigscreenInterval.setId(1);
        jxBigscreenInterval.setSecond(second);
        jxBigscreenIntervalMapper.updateById(jxBigscreenInterval);
    }


}
