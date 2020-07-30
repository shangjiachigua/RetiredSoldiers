package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.mapper.JxInformationTypeMapper;
import com.caifu.pojo.JxInformationType;
import com.caifu.service.JxInformationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 军休资料类型 服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
@Service
public class JxInformationTypeServiceImpl extends ServiceImpl<JxInformationTypeMapper, JxInformationType> implements JxInformationTypeService {

    @Autowired
    private JxInformationTypeMapper jxInformationTypeMapper;

    @Override
    public List<JxInformationType> getInformationType() {
        QueryWrapper<JxInformationType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "1").orderByAsc("sort");
        return jxInformationTypeMapper.selectList(queryWrapper);
    }

}
