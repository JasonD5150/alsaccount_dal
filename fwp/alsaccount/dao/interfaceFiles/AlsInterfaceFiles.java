package fwp.alsaccount.dao.interfaceFiles;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * AlsInterfaceFiles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_INTERFACE_FILES"
    ,schema="ALSMAN"
)

public class AlsInterfaceFiles  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer aifId;
     private Timestamp aifCreateDate;
     private String aifCreatePersonid;
     private String aifModPersonid;
     private Integer aifAwgcId;
     private String aifFileName;
     private String aifParentProcess;
     private String aifFileSent;
     private String aifFile;
     private Timestamp aifProcessDate;
     private Integer aifOrigfileId;
     private String aifNotes;
     private String aifSendFlag;


    // Constructors

    /** default constructor */
    public AlsInterfaceFiles() {
    }

	/** minimal constructor */
    public AlsInterfaceFiles(Timestamp aifCreateDate, String aifCreatePersonid, Integer aifAwgcId, String aifFileName, String aifParentProcess, String aifFileSent) {
        this.aifCreateDate = aifCreateDate;
        this.aifCreatePersonid = aifCreatePersonid;
        this.aifAwgcId = aifAwgcId;
        this.aifFileName = aifFileName;
        this.aifParentProcess = aifParentProcess;
        this.aifFileSent = aifFileSent;
    }
    
    /** full constructor */
    public AlsInterfaceFiles(Timestamp aifCreateDate, String aifCreatePersonid, String aifModPersonid, Integer aifAwgcId, String aifFileName, String aifParentProcess, String aifFileSent, String aifFile, Timestamp aifProcessDate, Integer aifOrigfileId, String aifNotes, String aifSendFlag) {
        this.aifCreateDate = aifCreateDate;
        this.aifCreatePersonid = aifCreatePersonid;
        this.aifModPersonid = aifModPersonid;
        this.aifAwgcId = aifAwgcId;
        this.aifFileName = aifFileName;
        this.aifParentProcess = aifParentProcess;
        this.aifFileSent = aifFileSent;
        this.aifFile = aifFile;
        this.aifProcessDate = aifProcessDate;
        this.aifOrigfileId = aifOrigfileId;
        this.aifNotes = aifNotes;
        this.aifSendFlag = aifSendFlag;
    }

   
    // Property accessors
    @SequenceGenerator(name="generator", sequenceName="ALSMAN.ALSMAN_SEQ")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    
    @Column(name="AIF_ID", unique=true, nullable=false, precision=10, scale=0)

    public Integer getAifId() {
        return this.aifId;
    }
    
    public void setAifId(Integer aifId) {
        this.aifId = aifId;
    }
    
    @Column(name="AIF_CREATE_DATE", nullable=false, length=7)

    public Timestamp getAifCreateDate() {
        return this.aifCreateDate;
    }
    
    public void setAifCreateDate(Timestamp aifCreateDate) {
        this.aifCreateDate = aifCreateDate;
    }
    
    @Column(name="AIF_CREATE_PERSONID", nullable=false, length=50)

    public String getAifCreatePersonid() {
        return this.aifCreatePersonid;
    }
    
    public void setAifCreatePersonid(String aifCreatePersonid) {
        this.aifCreatePersonid = aifCreatePersonid;
    }
    
    @Column(name="AIF_MOD_PERSONID", length=50)

    public String getAifModPersonid() {
        return this.aifModPersonid;
    }
    
    public void setAifModPersonid(String aifModPersonid) {
        this.aifModPersonid = aifModPersonid;
    }
    
    @Column(name="AIF_AWGC_ID", nullable=false, precision=10, scale=0)

    public Integer getAifAwgcId() {
        return this.aifAwgcId;
    }
    
    public void setAifAwgcId(Integer aifAwgcId) {
        this.aifAwgcId = aifAwgcId;
    }
    
    @Column(name="AIF_FILE_NAME", nullable=false, length=55)

    public String getAifFileName() {
        return this.aifFileName;
    }
    
    public void setAifFileName(String aifFileName) {
        this.aifFileName = aifFileName;
    }
    
    @Column(name="AIF_PARENT_PROCESS", nullable=false, length=100)

    public String getAifParentProcess() {
        return this.aifParentProcess;
    }
    
    public void setAifParentProcess(String aifParentProcess) {
        this.aifParentProcess = aifParentProcess;
    }
    
    @Column(name="AIF_FILE_SENT", nullable=false, length=1)

    public String getAifFileSent() {
        return this.aifFileSent;
    }
    
    public void setAifFileSent(String aifFileSent) {
        this.aifFileSent = aifFileSent;
    }
    @Lob
    @Column(name="AIF_FILE")

    public String getAifFile() {
        return this.aifFile;
    }
    
    public void setAifFile(String aifFile) {
        this.aifFile = aifFile;
    }
    
    @Column(name="AIF_PROCESS_DATE", length=7)

    public Timestamp getAifProcessDate() {
        return this.aifProcessDate;
    }
    
    public void setAifProcessDate(Timestamp aifProcessDate) {
        this.aifProcessDate = aifProcessDate;
    }
    
    @Column(name="AIF_ORIGFILE_ID", precision=10, scale=0)

    public Integer getAifOrigfileId() {
        return this.aifOrigfileId;
    }
    
    public void setAifOrigfileId(Integer aifOrigfileId) {
        this.aifOrigfileId = aifOrigfileId;
    }
    
    @Column(name="AIF_NOTES", length=1000)

    public String getAifNotes() {
        return this.aifNotes;
    }
    
    public void setAifNotes(String aifNotes) {
        this.aifNotes = aifNotes;
    }
    
    @Column(name="AIF_SEND_FLAG", length=1)

    public String getAifSendFlag() {
        return this.aifSendFlag;
    }
    
    public void setAifSendFlag(String aifSendFlag) {
        this.aifSendFlag = aifSendFlag;
    }
   








}