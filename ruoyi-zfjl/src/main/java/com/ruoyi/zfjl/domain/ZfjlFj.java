package com.ruoyi.zfjl.domain;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 执法记录-附件对象
 * 
 * @author ruoyi
 * @date 2021-12-07
 */
@Data
public class ZfjlFj
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 执法记录id */
    private String fkZfjlid;

    /** 附件名称 */
    private String name;

    /** 附件路劲 */
    private String url;

    /** 附件类型 */
    private String type;
}
