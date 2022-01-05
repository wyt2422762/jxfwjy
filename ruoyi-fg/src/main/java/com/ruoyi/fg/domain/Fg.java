package com.ruoyi.fg.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 房改信息管理对象 fg
 *
 * @author ruoyi
 * @date 2021-11-26
 */
@Data
public class Fg extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 房改信息id
     */
    private String id;

    /**
     * 房屋坐落
     */
    @Excel(name = "房屋坐落")
    private String fwzl;

    /**
     * 权证(证明)号
     */
    @Excel(name = "权证(证明)号")
    private String qzh;

    /**
     * 转让方式
     */
    @Excel(name = "转让方式")
    private String zrfs;

    /**
     * 转让方式_其他
     */
    @Excel(name = "转让方式_其他")
    private String zrfsQt;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号")
    private String htbh;

    /**
     * 受理编号
     */
    @Excel(name = "受理编号")
    private String slbh;

    /**
     * 申请日期
     */
    private Date sqrq;

    /**
     * 受理日期
     */
    private Date slrq;

    /**
     * 备注
     */
    private String bz;

    /**
     * 附记
     */
    private String fj;

    /**
     * 转让方姓名
     */
    private String zrfName;

    /**
     * 转让方电话
     */
    private String zrfDh;

    /**
     * 转让方证件类型
     */
    private String zrfZjLx;

    /**
     * 转让方证件号
     */
    private String zrfZj;

    /**
     * 转让方代理人姓名
     */
    private String zrfDlName;

    /**
     * 转让方代理人电话
     */
    private String zrfDlDh;

    /**
     * 转让方代理人证件类型
     */
    private String zrfDlZjLx;

    /**
     * 转让方代理人证件号
     */
    private String zrfDlZj;

    /**
     * 转让方共有情况
     */
    private String zrfGy;

    /**
     * 转让方共有份额(按份共有)
     */
    private String zrfGyFe;

    /**
     * 受让方姓名
     */
    private String srfName;

    /**
     * 受让方电话
     */
    private String srfDh;

    /**
     * 转让方证件类型
     */
    private String srfZjLx;

    /**
     * 受让方证件号
     */
    private String srfZj;

    /**
     * 受让方代理人姓名
     */
    private String srfDlName;

    /**
     * 受让方代理人电话
     */
    private String srfDlDh;

    /**
     * 受让方代理人证件类型
     */
    private String srfDlZjLx;

    /**
     * 受让方代理人证件号
     */
    private String srfDlZj;

    /**
     * 受让方共有情况
     */
    private String srfGy;

    /**
     * 受让方共有份额(按份共有)
     */
    private String srfGyFe;

    /**
     * 房改房屋信息
     */
    private List<FgFw> fgFwList;
}
