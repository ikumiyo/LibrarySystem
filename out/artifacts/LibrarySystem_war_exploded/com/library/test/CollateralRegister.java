package com.library.test;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-11-14-9:58
 */
public class CollateralRegister {
    private String ColId;
    private String ColName;
    private Integer ColType;
    private Integer ColStatus;
    private String OperateDate;
    private String OperateInstitute;
    private String OperateStaff;
    private Double LatestValue;
    private Integer Currency;
    private String CertificateName;
    private String CertificateId;
    private String ColOwner;
    private Integer OwnerCertificateType;
    private String OwnerCertificateNumber;

    public CollateralRegister() {
    }

    public CollateralRegister(String colId, String colName, Integer colType, Integer colStatus, String operateDate, String operateInstitute, String operateStaff, Double latestValue, Integer currency, String certificateName, String certificateId, String colOwner, Integer ownerCertificateType, String ownerCertificateNumber) {
        ColId = colId;
        ColName = colName;
        ColType = colType;
        ColStatus = colStatus;
        OperateDate = operateDate;
        OperateInstitute = operateInstitute;
        OperateStaff = operateStaff;
        LatestValue = latestValue;
        Currency = currency;
        CertificateName = certificateName;
        CertificateId = certificateId;
        ColOwner = colOwner;
        OwnerCertificateType = ownerCertificateType;
        OwnerCertificateNumber = ownerCertificateNumber;
    }

    public String getColId() {
        return ColId;
    }

    public void setColId(String colId) {
        ColId = colId;
    }

    public String getColName() {
        return ColName;
    }

    public void setColName(String colName) {
        ColName = colName;
    }

    public Integer getColType() {
        return ColType;
    }

    public void setColType(Integer colType) {
        ColType = colType;
    }

    public Integer getColStatus() {
        return ColStatus;
    }

    public void setColStatus(Integer colStatus) {
        ColStatus = colStatus;
    }

    public String getOperateDate() {
        return OperateDate;
    }

    public void setOperateDate(String operateDate) {
        OperateDate = operateDate;
    }

    public String getOperateInstitute() {
        return OperateInstitute;
    }

    public void setOperateInstitute(String operateInstitute) {
        OperateInstitute = operateInstitute;
    }

    public String getOperateStaff() {
        return OperateStaff;
    }

    public void setOperateStaff(String operateStaff) {
        OperateStaff = operateStaff;
    }

    public Double getLatestValue() {
        return LatestValue;
    }

    public void setLatestValue(Double latestValue) {
        LatestValue = latestValue;
    }

    public Integer getCurrency() {
        return Currency;
    }

    public void setCurrency(Integer currency) {
        Currency = currency;
    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public String getCertificateId() {
        return CertificateId;
    }

    public void setCertificateId(String certificateId) {
        CertificateId = certificateId;
    }

    public String getColOwner() {
        return ColOwner;
    }

    public void setColOwner(String colOwner) {
        ColOwner = colOwner;
    }

    public Integer getOwnerCertificateType() {
        return OwnerCertificateType;
    }

    public void setOwnerCertificateType(Integer ownerCertificateType) {
        OwnerCertificateType = ownerCertificateType;
    }

    public String getOwnerCertificateNumber() {
        return OwnerCertificateNumber;
    }

    public void setOwnerCertificateNumber(String ownerCertificateNumber) {
        OwnerCertificateNumber = ownerCertificateNumber;
    }
}
