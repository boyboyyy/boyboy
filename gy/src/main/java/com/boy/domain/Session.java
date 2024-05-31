package com.boy.domain;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable {
    private Long id;

    /**
     * 水果种类
     */
    private String name;

    /**
     * 第一季度
     */
    private Long firstSeason;

    /**
     * 第二季度
     */
    private Long secondSeason;

    /**
     * 第三季度
     */
    private Long thirdSeason;

    /**
     * 第四季度
     */
    private Long forth;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateBy;

    /**
     * 逻辑删除
     */
    private Byte delFlag;

    public Session() {
    }

    public Session(Long id, String name, Long firstSeason, Long secondSeason, Long thirdSeason, Long forth, Date createTime, Long createBy, Date updateTime, Long updateBy, Byte delFlag) {
        this.id = id;
        this.name = name;
        this.firstSeason = firstSeason;
        this.secondSeason = secondSeason;
        this.thirdSeason = thirdSeason;
        this.forth = forth;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.delFlag = delFlag;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFirstSeason() {
        return firstSeason;
    }

    public void setFirstSeason(Long firstSeason) {
        this.firstSeason = firstSeason;
    }

    public Long getSecondSeason() {
        return secondSeason;
    }

    public void setSecondSeason(Long secondSeason) {
        this.secondSeason = secondSeason;
    }

    public Long getThirdSeason() {
        return thirdSeason;
    }

    public void setThirdSeason(Long thirdSeason) {
        this.thirdSeason = thirdSeason;
    }

    public Long getForth() {
        return forth;
    }

    public void setForth(Long forth) {
        this.forth = forth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstSeason=" + firstSeason +
                ", secondSeason=" + secondSeason +
                ", thirdSeason=" + thirdSeason +
                ", forth=" + forth +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateTime=" + updateTime +
                ", updateBy=" + updateBy +
                ", delFlag=" + delFlag +
                '}';
    }
}
