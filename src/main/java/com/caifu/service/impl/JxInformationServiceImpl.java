package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.dto.JxInformationDto;
import com.caifu.mapper.JxInformationFileMapper;
import com.caifu.mapper.JxInformationMapper;
import com.caifu.mapper.JxInformationTypeMapper;
import com.caifu.pojo.JxInformation;
import com.caifu.pojo.JxInformationFile;
import com.caifu.pojo.JxInformationType;
import com.caifu.service.JxInformationService;
import com.caifu.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 军休资料 服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
@Service
public class JxInformationServiceImpl extends ServiceImpl<JxInformationMapper, JxInformation> implements JxInformationService {

    @Autowired
    private JxInformationMapper jxInformationMapper;

    @Autowired
    private JxInformationTypeMapper jxInformationTypeMapper;

    @Autowired
    private JxInformationFileMapper jxInformationFileMapper;

    @Override
    public IPage<JxInformation> getInformation(String currentPage, String pageSize, String title, String type) {
        QueryWrapper<JxInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "1");
        if (Utils.isNotNull(title)) {
            queryWrapper.like("title", title);
        }
        if (Utils.isNotNull(type)) {
            queryWrapper.like("type", type);
        }
        Page<JxInformation> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        IPage<JxInformation> jxInformationIPage = jxInformationMapper.selectPage(page, queryWrapper);

        //通过id获取type名称
        List<JxInformation> records = jxInformationIPage.getRecords();
        if (Utils.isNotNull(records)) {
            for (JxInformation record : records) {
                JxInformationType jxInformationType = jxInformationTypeMapper.selectById(record.getType());
                record.setType(jxInformationType.getName());
            }
        }
        return jxInformationIPage;
    }

    @Override
    public void deleteById(String id) {
        JxInformation jxInformation = new JxInformation();
        jxInformation.setId(Integer.parseInt(id));
        jxInformation.setStatus("9");
        jxInformationMapper.updateById(jxInformation);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateInformationById(JxInformationDto jxInformationDto) {
        JxInformation jxInformation = new JxInformation();
        jxInformation.setType(jxInformationDto.getType());
        jxInformation.setBriefIntroduction(jxInformationDto.getBriefIntroduction());
        jxInformation.setContent(jxInformationDto.getContent());
        jxInformation.setTitle(jxInformationDto.getTitle());
        jxInformation.setUpdateTime(new Date());
        jxInformation.setId(jxInformationDto.getId());
        jxInformationMapper.updateById(jxInformation);

        //修改资料附件先将之前的删除
        UpdateWrapper<JxInformationFile> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("INFORMATION_ID", jxInformationDto.getId()).eq("status", "1");
        JxInformationFile update = new JxInformationFile();
        update.setStatus("9");
        jxInformationFileMapper.update(update, updateWrapper);

        //资料附件添加
        String fileUrl = jxInformationDto.getFileUrl();
        //fileurl数组
        String[] fileUrls = fileUrl.split(",");
        String name = jxInformationDto.getName();
        //filename数组
        String[] fileName = name.split(",");
        JxInformationFile jxInformationFile = null;
        for (int i = 0; i < fileUrls.length; i++) {
            jxInformationFile = new JxInformationFile();
            jxInformationFile.setName(fileName[i]);
            jxInformationFile.setFileUrl(fileUrls[i]);
            jxInformationFile.setCreateBy(1);
            jxInformationFile.setCreateTime(new Date());
            jxInformationFile.setInformationId(jxInformation.getId());
            jxInformationFile.setStatus("1");
            jxInformationFile.setUpdateBy(1);
            jxInformationFile.setUpdateTime(new Date());
            jxInformationFileMapper.insert(jxInformationFile);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(JxInformationDto jxInformationDto) {
        //资料添加
        JxInformation jxInformation = new JxInformation();
        jxInformation.setStatus("1");
        jxInformation.setType(jxInformationDto.getType());
        jxInformation.setBriefIntroduction(jxInformationDto.getBriefIntroduction());
        jxInformation.setContent(jxInformationDto.getContent());
        jxInformation.setCreateBy(1);
        jxInformation.setCreateTime(new Date());
        jxInformation.setTitle(jxInformationDto.getTitle());
        jxInformation.setUpdateBy(1);
        jxInformation.setUpdateTime(new Date());
        jxInformationMapper.insert(jxInformation);
        //资料附件添加
        String fileUrl = jxInformationDto.getFileUrl();
        //fileurl数组
        String[] fileUrls = fileUrl.split(",");
        String name = jxInformationDto.getName();
        //filename数组
        String[] fileName = name.split(",");
        JxInformationFile jxInformationFile = null;
        for (int i = 0; i < fileUrls.length; i++) {
            jxInformationFile = new JxInformationFile();
            jxInformationFile.setName(fileName[i]);
            jxInformationFile.setFileUrl(fileUrls[i]);
            jxInformationFile.setCreateBy(1);
            jxInformationFile.setCreateTime(new Date());
            jxInformationFile.setInformationId(jxInformation.getId());
            jxInformationFile.setStatus("1");
            jxInformationFile.setUpdateBy(1);
            jxInformationFile.setUpdateTime(new Date());
            jxInformationFileMapper.insert(jxInformationFile);
        }
    }

    @Override
    public JxInformation getInformationById(String id) {
        return jxInformationMapper.selectById(Integer.parseInt(id));
    }
}
