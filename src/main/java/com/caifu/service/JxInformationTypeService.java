package com.caifu.service;

import com.caifu.pojo.JxInformationType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 军休资料类型 服务类
 * </p>
 *
 * @author Tianwenwen
 * @since 2020-07-27
 */
public interface JxInformationTypeService extends IService<JxInformationType> {

    List<JxInformationType> getInformationType();
}
