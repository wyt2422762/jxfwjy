package com.ruoyi.fg.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 房改房屋对象 fg_fw
 *
 * @author ruoyi
 * @date 2021-11-26
 */
@Data
public class FgFw extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 房改信息id
     */
    @Excel(name = "房改信息id")
    private String fkFgid;

    /**
     * 总层数
     */
    @Excel(name = "总层数")
    private Long zcs;

    /**
     * 层次
     */
    @Excel(name = "层次")
    private Long cc;

    /**
     * 面积
     */
    @Excel(name = "面积")
    private Double mj;

    /**
     * 性质
     */
    @Excel(name = "性质")
    private String xz;

    /**
     * 用途
     */
    @Excel(name = "用途")
    private String yt;

    /**
     * 年代
     */
    @Excel(name = "年代")
    private String nd;

    /**
     * 结构
     */
    @Excel(name = "结构")
    private String jg;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String bz;
}
