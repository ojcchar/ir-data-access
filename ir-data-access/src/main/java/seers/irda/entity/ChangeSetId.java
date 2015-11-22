package seers.irda.entity;
// Generated Nov 19, 2015 11:09:07 AM by Hibernate Tools 4.3.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChangeSetId generated by hbm2java
 */
@Embeddable
public class ChangeSetId  implements java.io.Serializable {


     private int fileId;
     private int revisionId;
     private String changeType;

    public ChangeSetId() {
    }

    public ChangeSetId(int fileId, int revisionId, String changeType) {
       this.fileId = fileId;
       this.revisionId = revisionId;
       this.changeType = changeType;
    }
   


    @Column(name="file_id", nullable=false)
    public int getFileId() {
        return this.fileId;
    }
    
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }


    @Column(name="revision_id", nullable=false)
    public int getRevisionId() {
        return this.revisionId;
    }
    
    public void setRevisionId(int revisionId) {
        this.revisionId = revisionId;
    }


    @Column(name="change_type", nullable=false, length=200)
    public String getChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ChangeSetId) ) return false;
		 ChangeSetId castOther = ( ChangeSetId ) other; 
         
		 return (this.getFileId()==castOther.getFileId())
 && (this.getRevisionId()==castOther.getRevisionId())
 && ( (this.getChangeType()==castOther.getChangeType()) || ( this.getChangeType()!=null && castOther.getChangeType()!=null && this.getChangeType().equals(castOther.getChangeType()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFileId();
         result = 37 * result + this.getRevisionId();
         result = 37 * result + ( getChangeType() == null ? 0 : this.getChangeType().hashCode() );
         return result;
   }   


}


