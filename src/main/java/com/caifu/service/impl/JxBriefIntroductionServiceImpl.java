package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.common.Result;
import com.caifu.mapper.JxBriefIntroductionMapper;
import com.caifu.pojo.JxBriefIntroduction;
import com.caifu.service.JxBriefIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-21
 */
@Service
public class JxBriefIntroductionServiceImpl extends ServiceImpl<JxBriefIntroductionMapper, JxBriefIntroduction> implements JxBriefIntroductionService {

    @Autowired
    private JxBriefIntroductionMapper jxBriefIntroductionMapper;

    @Override
    public void add(String content) {
        JxBriefIntroduction jxBriefIntroduction = new JxBriefIntroduction();
        jxBriefIntroduction.setContent(content);
        jxBriefIntroduction.setCreateBy(1);
        jxBriefIntroduction.setCreateTime(new Date());
        jxBriefIntroduction.setStatus("1");
        jxBriefIntroduction.setUpdateBy(1);
        jxBriefIntroduction.setUpdateTime(new Date());
        jxBriefIntroductionMapper.insert(jxBriefIntroduction);
    }

    @Override
    public Result<JxBriefIntroduction> getIntroduction() {
        Result<JxBriefIntroduction> result = new Result<>();
        QueryWrapper<JxBriefIntroduction> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "1");
        JxBriefIntroduction data = jxBriefIntroductionMapper.selectOne(queryWrapper);
        if (data == null) {
            result.setMsg("未找到");
            result.setCode(9997);
        } else {
            result.setMsg("成功");
            result.setCode(200);
            result.setData(data);
        }
        return result;
    }

    @Override
    public void deleteById(String id) {
        JxBriefIntroduction jxBriefIntroduction = new JxBriefIntroduction();
        jxBriefIntroduction.setId(Integer.parseInt(id));
        jxBriefIntroduction.setStatus("9");
        jxBriefIntroductionMapper.updateById(jxBriefIntroduction);
    }

    @Override
    public Result<JxBriefIntroduction> getIntroductionById(String id) {
        Result<JxBriefIntroduction> result = new Result<>();
        JxBriefIntroduction jxBriefIntroduction = jxBriefIntroductionMapper.selectById(id);
        result.setData(jxBriefIntroduction);
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    @Override
    public void updateById(String id, String content) {
        JxBriefIntroduction jxBriefIntroduction = new JxBriefIntroduction();
        jxBriefIntroduction.setId(Integer.parseInt(id));
        jxBriefIntroduction.setContent(content);
        jxBriefIntroduction.setUpdateTime(new Date());
        jxBriefIntroductionMapper.updateById(jxBriefIntroduction);
    }
}
