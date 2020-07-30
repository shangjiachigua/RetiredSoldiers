package com.caifu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caifu.mapper.JxStaffMapper;
import com.caifu.pojo.JxStaff;
import com.caifu.service.JxStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 军休员工  服务实现类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-28
 */
@Service
public class JxStaffServiceImpl extends ServiceImpl<JxStaffMapper, JxStaff> implements JxStaffService {

    @Autowired
    private JxStaffMapper jxStaffMapper;

    @Override
    public IPage<JxStaff> getStaffList(String currentPage, String pageSize) {
        QueryWrapper<JxStaff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "1").orderByDesc("IS_EXHIBITION").orderByDesc("CREATE_TIME");
        Page<JxStaff> page = new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize));
        return jxStaffMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void updateRoomById(String id, String name, String photoUrl, String isExhibition) {
        JxStaff jxStaff = new JxStaff();
        jxStaff.setId(Integer.parseInt(id));
        jxStaff.setIsExhibition(isExhibition);
        jxStaff.setName(name);
        jxStaff.setPhotoUrl(photoUrl);
        jxStaff.setUpdateTime(new Date());
        jxStaffMapper.updateById(jxStaff);
    }

    @Override
    public void add(String name, String photoUrl, String isExhibition) {
        JxStaff jxStaff = new JxStaff();
        jxStaff.setCreateBy(1);
        jxStaff.setCreateTime(new Date());
        jxStaff.setIsExhibition(isExhibition);
        jxStaff.setName(name);
        jxStaff.setPhotoUrl(photoUrl);
        jxStaff.setUpdateBy(1);
        jxStaff.setUpdateTime(new Date());
        jxStaff.setStatus("1");
        jxStaffMapper.insert(jxStaff);
    }

    @Override
    public void deleteById(String id) {
        JxStaff jxStaff = new JxStaff();
        jxStaff.setId(Integer.parseInt(id));
        jxStaff.setStatus("9");
        jxStaffMapper.updateById(jxStaff);
    }
}
