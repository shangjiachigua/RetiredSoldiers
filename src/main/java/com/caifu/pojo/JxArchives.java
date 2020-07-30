package com.caifu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 档案表 军休档案
 * </p>
 *
 * @author Lyf
 * @since 2020-07-17
 */
public class JxArchives extends Model<JxArchives> {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人
     */
    @TableField("CREATE_BY")
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField("UPDATE_BY")
    private Integer updateBy;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 身份证
     */
    @TableField("CERTIFICATE_NUMBER")
    private String certificateNumber;

    /**
     * 性别
     */
    @TableField("SEX")
    private String sex;

    /**
     * 出生日期
     */
    @TableField("BIRTH_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    /**
     * 离退休类型
     */
    @TableField("TYPE")
    private String type;

    /**
     * 支部
     */
    @TableField("BRANCH")
    private String branch;

    /**
     * 籍贯
     */
    @TableField("NATIVE_PLACE")
    private String nativePlace;

    /**
     * 民族
     */
    @TableField("NATION")
    private String nation;

    /**
     * 文化程度
     */
    @TableField("EDUCATIONAL_LEVEL")
    private String educationalLevel;

    /**
     * 政治面貌
     */
    @TableField("POLITICAL_AFFILIATION")
    private String politicalAffiliation;

    /**
     * 入党时间
     */
    @TableField("JOINPARTY_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinpartyDate;

    /**
     * 婚姻状况
     */
    @TableField("MARITAL_STATUS")
    private String maritalStatus;

    /**
     * 户籍地址
     */
    @TableField("HOUSEHOLD_REGISTRATION")
    private String householdRegistration;

    /**
     * 现居住地址
     */
    @TableField("RESIDE_ADDRESS")
    private String resideAddress;

    /**
     * 手机号码
     */
    @TableField("PHONE_NUMBER")
    private String phoneNumber;

    /**
     * 固定电话
     */
    @TableField("TEL_NUMBER")
    private String telNumber;

    /**
     * 是否去世（0.否 1.是）
     */
    @TableField("ALIVE_STATUS")
    private String aliveStatus;

    /**
     * 去世时间
     */
    @TableField("DEATH_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deathDate;

    /**
     * 是否因公伤残
     */
    @TableField("INVALIDISM_COMMUNAL")
    private String invalidismCommunal;

    /**
     * 因公伤残级别
     */
    @TableField("INVALIDISM_COMMUNAL_LEVEL")
    private String invalidismCommunalLevel;

    /**
     * 是否因病伤残
     */
    @TableField("INVALIDISM_ILLNESS")
    private String invalidismIllness;

    /**
     * 因病伤残级别
     */
    @TableField("INVALIDISM_ILLNESS_LEVEL")
    private String invalidismIllnessLevel;

    /**
     * 是否因战伤残
     */
    @TableField("INVALIDISM_WARFARE")
    private String invalidismWarfare;

    /**
     * 因战伤残级别
     */
    @TableField("INVALIDISM_WARFARE_LEVEL")
    private String invalidismWarfareLevel;

    /**
     * 重大疾病
     */
    @TableField("SERIOUS_DISEASE")
    private String seriousDisease;

    /**
     * 入伍时间
     */
    @TableField("JOINUP_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinupDate;

    /**
     * 参加工作时间
     */
    @TableField("START_WORK_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startWorkDate;

    /**
     * 离退休时间
     */
    @TableField("END_WORK_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endWorkDate;

    /**
     * 接收时间
     */
    @TableField("RECEIVE_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date receiveDate;

    /**
     * 原部职别
     */
    @TableField("TROOPS_DUTIES")
    private String troopsDuties;

    /**
     * 部队类别
     */
    @TableField("TROOPS_TYPE")
    private String troopsType;

    /**
     * 干部类别
     */
    @TableField("CADER_TYPE")
    private String caderType;

    /**
     * 军衔文职
     */
    @TableField("MILITARY_RANK")
    private String militaryRank;

    /**
     * 技术等级
     */
    @TableField("SKILL_LEVEL")
    private String skillLevel;

    /**
     * 职务等级
     */
    @TableField("DUTIES_LEVEL")
    private String dutiesLevel;

    /**
     * 现职级待遇
     */
    @TableField("NOW_TREATMENT")
    private String nowTreatment;

    /**
     * 是否享受国务院特殊津贴
     */
    @TableField("SPECIAL_SUBSIDY")
    private String specialSubsidy;

    /**
     * 是否享受护理费
     */
    @TableField("NURSING_EXPENSES")
    private String nursingExpenses;

    /**
     * 享受护理费起始时间
     */
    @TableField("NURSE_START_DATE")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nurseStartDate;

    /**
     * 是否享受长护险
     */
    @TableField("LONGTERM_INSURANCE")
    private String longtermInsurance;

    /**
     * 是否享受家庭医生
     */
    @TableField("FAMILY_DOCTOR")
    private String familyDoctor;

    /**
     * 是否购买‘久久关爱’
     */
    @TableField("PURCHASE_JJGA")
    private String purchaseJjga;

    /**
     * 是否购买‘安康通’
     */
    @TableField("PURCHASE_AKT")
    private String purchaseAkt;

    /**
     * 备注
     */
    @TableField("REMARKS")
    private String remarks;

    /**
     * 具体内容
     */
    @TableField("POLITICAL_EXPLAIN")
    private String politicalExplain;

    /**
     * 状态(1.正常  9.删除）
     */
    @TableField("STATUS")
    private String status;

    /**
     * 照片
     */
    @TableField("PHOTO_URL")
    private String photoUrl;

    /**
     * 人脸状态（1.未通过 2.通过）
     */
    @TableField("FACE_STATE")
    private String faceState;

    /**
     * 人脸id
     */
    @TableField("FACE_ID")
    private String faceId;

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }
    public String getPoliticalAffiliation() {
        return politicalAffiliation;
    }

    public void setPoliticalAffiliation(String politicalAffiliation) {
        this.politicalAffiliation = politicalAffiliation;
    }
    public Date getJoinpartyDate() {
        return joinpartyDate;
    }

    public void setJoinpartyDate(Date joinpartyDate) {
        this.joinpartyDate = joinpartyDate;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getHouseholdRegistration() {
        return householdRegistration;
    }

    public void setHouseholdRegistration(String householdRegistration) {
        this.householdRegistration = householdRegistration;
    }
    public String getResideAddress() {
        return resideAddress;
    }

    public void setResideAddress(String resideAddress) {
        this.resideAddress = resideAddress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    public String getAliveStatus() {
        return aliveStatus;
    }

    public void setAliveStatus(String aliveStatus) {
        this.aliveStatus = aliveStatus;
    }
    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }
    public String getInvalidismCommunal() {
        return invalidismCommunal;
    }

    public void setInvalidismCommunal(String invalidismCommunal) {
        this.invalidismCommunal = invalidismCommunal;
    }
    public String getInvalidismCommunalLevel() {
        return invalidismCommunalLevel;
    }

    public void setInvalidismCommunalLevel(String invalidismCommunalLevel) {
        this.invalidismCommunalLevel = invalidismCommunalLevel;
    }
    public String getInvalidismIllness() {
        return invalidismIllness;
    }

    public void setInvalidismIllness(String invalidismIllness) {
        this.invalidismIllness = invalidismIllness;
    }
    public String getInvalidismIllnessLevel() {
        return invalidismIllnessLevel;
    }

    public void setInvalidismIllnessLevel(String invalidismIllnessLevel) {
        this.invalidismIllnessLevel = invalidismIllnessLevel;
    }
    public String getInvalidismWarfare() {
        return invalidismWarfare;
    }

    public void setInvalidismWarfare(String invalidismWarfare) {
        this.invalidismWarfare = invalidismWarfare;
    }
    public String getInvalidismWarfareLevel() {
        return invalidismWarfareLevel;
    }

    public void setInvalidismWarfareLevel(String invalidismWarfareLevel) {
        this.invalidismWarfareLevel = invalidismWarfareLevel;
    }
    public String getSeriousDisease() {
        return seriousDisease;
    }

    public void setSeriousDisease(String seriousDisease) {
        this.seriousDisease = seriousDisease;
    }
    public Date getJoinupDate() {
        return joinupDate;
    }

    public void setJoinupDate(Date joinupDate) {
        this.joinupDate = joinupDate;
    }
    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }
    public Date getEndWorkDate() {
        return endWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }
    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }
    public String getTroopsDuties() {
        return troopsDuties;
    }

    public void setTroopsDuties(String troopsDuties) {
        this.troopsDuties = troopsDuties;
    }
    public String getTroopsType() {
        return troopsType;
    }

    public void setTroopsType(String troopsType) {
        this.troopsType = troopsType;
    }
    public String getCaderType() {
        return caderType;
    }

    public void setCaderType(String caderType) {
        this.caderType = caderType;
    }
    public String getMilitaryRank() {
        return militaryRank;
    }

    public void setMilitaryRank(String militaryRank) {
        this.militaryRank = militaryRank;
    }
    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
    public String getDutiesLevel() {
        return dutiesLevel;
    }

    public void setDutiesLevel(String dutiesLevel) {
        this.dutiesLevel = dutiesLevel;
    }
    public String getNowTreatment() {
        return nowTreatment;
    }

    public void setNowTreatment(String nowTreatment) {
        this.nowTreatment = nowTreatment;
    }
    public String getSpecialSubsidy() {
        return specialSubsidy;
    }

    public void setSpecialSubsidy(String specialSubsidy) {
        this.specialSubsidy = specialSubsidy;
    }
    public String getNursingExpenses() {
        return nursingExpenses;
    }

    public void setNursingExpenses(String nursingExpenses) {
        this.nursingExpenses = nursingExpenses;
    }
    public Date getNurseStartDate() {
        return nurseStartDate;
    }

    public void setNurseStartDate(Date nurseStartDate) {
        this.nurseStartDate = nurseStartDate;
    }
    public String getLongtermInsurance() {
        return longtermInsurance;
    }

    public void setLongtermInsurance(String longtermInsurance) {
        this.longtermInsurance = longtermInsurance;
    }
    public String getFamilyDoctor() {
        return familyDoctor;
    }

    public void setFamilyDoctor(String familyDoctor) {
        this.familyDoctor = familyDoctor;
    }
    public String getPurchaseJjga() {
        return purchaseJjga;
    }

    public void setPurchaseJjga(String purchaseJjga) {
        this.purchaseJjga = purchaseJjga;
    }
    public String getPurchaseAkt() {
        return purchaseAkt;
    }

    public void setPurchaseAkt(String purchaseAkt) {
        this.purchaseAkt = purchaseAkt;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoliticalExplain() {
        return politicalExplain;
    }

    public void setPoliticalExplain(String politicalExplain) {
        this.politicalExplain = politicalExplain;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getFaceState() {
        return faceState;
    }

    public void setFaceState(String faceState) {
        this.faceState = faceState;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "JxArchives{" +
        "createBy=" + createBy +
        ", createTime=" + createTime +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        ", id=" + id +
        ", name=" + name +
        ", certificateNumber=" + certificateNumber +
        ", sex=" + sex +
        ", birthDate=" + birthDate +
        ", type=" + type +
        ", branch=" + branch +
        ", nativePlace=" + nativePlace +
        ", nation=" + nation +
        ", educationalLevel=" + educationalLevel +
        ", politicalAffiliation=" + politicalAffiliation +
        ", joinpartyDate=" + joinpartyDate +
        ", maritalStatus=" + maritalStatus +
        ", householdRegistration=" + householdRegistration +
        ", resideAddress=" + resideAddress +
        ", phoneNumber=" + phoneNumber +
        ", telNumber=" + telNumber +
        ", aliveStatus=" + aliveStatus +
        ", deathDate=" + deathDate +
        ", invalidismCommunal=" + invalidismCommunal +
        ", invalidismCommunalLevel=" + invalidismCommunalLevel +
        ", invalidismIllness=" + invalidismIllness +
        ", invalidismIllnessLevel=" + invalidismIllnessLevel +
        ", invalidismWarfare=" + invalidismWarfare +
        ", invalidismWarfareLevel=" + invalidismWarfareLevel +
        ", seriousDisease=" + seriousDisease +
        ", joinupDate=" + joinupDate +
        ", startWorkDate=" + startWorkDate +
        ", endWorkDate=" + endWorkDate +
        ", receiveDate=" + receiveDate +
        ", troopsDuties=" + troopsDuties +
        ", troopsType=" + troopsType +
        ", caderType=" + caderType +
        ", militaryRank=" + militaryRank +
        ", skillLevel=" + skillLevel +
        ", dutiesLevel=" + dutiesLevel +
        ", nowTreatment=" + nowTreatment +
        ", specialSubsidy=" + specialSubsidy +
        ", nursingExpenses=" + nursingExpenses +
        ", nurseStartDate=" + nurseStartDate +
        ", longtermInsurance=" + longtermInsurance +
        ", familyDoctor=" + familyDoctor +
        ", purchaseJjga=" + purchaseJjga +
        ", purchaseAkt=" + purchaseAkt +
        ", remarks=" + remarks +
        ", status=" + status +
        "}";
    }
}
