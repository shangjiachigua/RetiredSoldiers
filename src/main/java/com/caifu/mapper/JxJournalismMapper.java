package com.caifu.mapper;

import com.caifu.dto.JxJournalismDto;
import com.caifu.pojo.JxJournalism;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 新闻信息表 Mapper 接口
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-22
 */
public interface JxJournalismMapper extends BaseMapper<JxJournalism> {

    List<JxJournalismDto> selectJxJournalismList(Map<String, Object> map);

}
