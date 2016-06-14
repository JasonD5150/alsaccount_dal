package fwp.alsaccount.hibernate.dao;

import static javax.persistence.GenerationType.SEQUENCE;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * AlsMisc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_MISC"
    ,schema="ALS"
)

public class AlsMisc  implements java.io.Serializable {


    // Fields    

	 private static final long serialVersionUID = 380245413540714344L;
	 private Integer amSeqNo;
     private String amKey1;
     private String amKey2;
     private String amKey3;
     private String amKey4;
     private String amKey5;
     private String amDesc1;
     private String amDesc2;
     private String amDesc3;
     private String amDesc4;
     private String amDesc5;
     private String amParVal;
     private String amValDesc;
     private String amWhoLog;
     private Timestamp amWhenLog;


    // Constructors

    /** default constructor */
    public AlsMisc() {
    }

	/** minimal constructor */
    public AlsMisc(String amKey1, String amDesc1, String amParVal, String amValDesc, String amWhoLog, Timestamp amWhenLog) {
        this.amKey1 = amKey1;
        this.amDesc1 = amDesc1;
        this.amParVal = amParVal;
        this.amValDesc = amValDesc;
        this.amWhoLog = amWhoLog;
        this.amWhenLog = amWhenLog;
    }
    
    /** full constructor */
    public AlsMisc(String amKey1, String amKey2, String amKey3, String amKey4, String amKey5, String amDesc1, String amDesc2, String amDesc3, String amDesc4, String amDesc5, String amParVal, String amValDesc, String amWhoLog, Timestamp amWhenLog) {
        this.amKey1 = amKey1;
        this.amKey2 = amKey2;
        this.amKey3 = amKey3;
        this.amKey4 = amKey4;
        this.amKey5 = amKey5;
        this.amDesc1 = amDesc1;
        this.amDesc2 = amDesc2;
        this.amDesc3 = amDesc3;
        this.amDesc4 = amDesc4;
        this.amDesc5 = amDesc5;
        this.amParVal = amParVal;
        this.amValDesc = amValDesc;
        this.amWhoLog = amWhoLog;
        this.amWhenLog = amWhenLog;
    }

   
    // Property accessors
    @SequenceGenerator(name="generator", sequenceName="ALS.ALS_MISC_SEQ")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    
    @Column(name="AM_SEQ_NO", unique=true, nullable=false, precision=8, scale=0)

    public Integer getAmSeqNo() {
        return this.amSeqNo;
    }
    
    public void setAmSeqNo(Integer amSeqNo) {
        this.amSeqNo = amSeqNo;
    }
    
    @Column(name="AM_KEY1", nullable=false, length=30)

    public String getAmKey1() {
        return this.amKey1;
    }
    
    public void setAmKey1(String amKey1) {
        this.amKey1 = amKey1;
    }
    
    @Column(name="AM_KEY2", length=30)

    public String getAmKey2() {
        return this.amKey2;
    }
    
    public void setAmKey2(String amKey2) {
        this.amKey2 = amKey2;
    }
    
    @Column(name="AM_KEY3", length=30)

    public String getAmKey3() {
        return this.amKey3;
    }
    
    public void setAmKey3(String amKey3) {
        this.amKey3 = amKey3;
    }
    
    @Column(name="AM_KEY4", length=30)

    public String getAmKey4() {
        return this.amKey4;
    }
    
    public void setAmKey4(String amKey4) {
        this.amKey4 = amKey4;
    }
    
    @Column(name="AM_KEY5", length=30)

    public String getAmKey5() {
        return this.amKey5;
    }
    
    public void setAmKey5(String amKey5) {
        this.amKey5 = amKey5;
    }
    
    @Column(name="AM_DESC1", nullable=false, length=200)

    public String getAmDesc1() {
        return this.amDesc1;
    }
    
    public void setAmDesc1(String amDesc1) {
        this.amDesc1 = amDesc1;
    }
    
    @Column(name="AM_DESC2", length=200)

    public String getAmDesc2() {
        return this.amDesc2;
    }
    
    public void setAmDesc2(String amDesc2) {
        this.amDesc2 = amDesc2;
    }
    
    @Column(name="AM_DESC3", length=200)

    public String getAmDesc3() {
        return this.amDesc3;
    }
    
    public void setAmDesc3(String amDesc3) {
        this.amDesc3 = amDesc3;
    }
    
    @Column(name="AM_DESC4", length=200)

    public String getAmDesc4() {
        return this.amDesc4;
    }
    
    public void setAmDesc4(String amDesc4) {
        this.amDesc4 = amDesc4;
    }
    
    @Column(name="AM_DESC5", length=200)

    public String getAmDesc5() {
        return this.amDesc5;
    }
    
    public void setAmDesc5(String amDesc5) {
        this.amDesc5 = amDesc5;
    }
    
    @Column(name="AM_PAR_VAL", nullable=false, length=50)

    public String getAmParVal() {
        return this.amParVal;
    }
    
    public void setAmParVal(String amParVal) {
        this.amParVal = amParVal;
    }
    
    @Column(name="AM_VAL_DESC", nullable=false, length=200)

    public String getAmValDesc() {
        return this.amValDesc;
    }
    
    public void setAmValDesc(String amValDesc) {
        this.amValDesc = amValDesc;
    }
    
    @Column(name="AM_WHO_LOG", nullable=false, length=15)

    public String getAmWhoLog() {
        return this.amWhoLog;
    }
    
    public void setAmWhoLog(String amWhoLog) {
        this.amWhoLog = amWhoLog;
    }
    
    @Column(name="AM_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAmWhenLog() {
        return this.amWhenLog;
    }
    
    public void setAmWhenLog(Timestamp amWhenLog) {
        this.amWhenLog = amWhenLog;
    }
   








}