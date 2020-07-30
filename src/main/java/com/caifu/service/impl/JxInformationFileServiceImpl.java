package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caifu.pojo.JxInformationFile;
import com.caifu.mapper.JxInformationFileMapper;
import com.caifu.service.JxInformationFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 军休资料附件 服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
@Service
public class JxInformationFileServiceImpl extends ServiceImpl<JxInformationFileMapper, JxInformationFile> implements JxInformationFileService {

    @Autowired
    private JxInformationFileMapper jxInformationFileMapper;

    @Override
    public List<JxInformationFile> getInformationfileById(String informationId) {
        QueryWrapper<JxInformationFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("INFORMATION_ID", Integer.parseInt(informationId)).eq("status", "1");
        return jxInformationFileMapper.selectList(queryWrapper);
    }
}
