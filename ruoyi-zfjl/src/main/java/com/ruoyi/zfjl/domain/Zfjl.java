package com.ruoyi.zfjl.domain;

import java.util.List;

import com.ruoyi.common.validation.EditGroup;
import lombok.Data;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 执法记录主对象 zfjl
 * 
 * @author ruoyi
 * @date 2021-12-07
 */
@Data
public class Zfjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @NotBlank(message = "id不能为空", groups = {EditGroup.class})
    private String id;

    /** 案件名称 */
    @NotBlank(message = "参数键值不能为空")
    private String name;

    /** 执法记录-附件信息 */
    private List<ZfjlFj> fjList;
}
