package seers.irda.entity;
// Generated Dec 9, 2015 11:27:45 AM by Hibernate Tools 4.3.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VIrRelevanceJudgementId generated by hbm2java
 */
@Embeddable
public class VIrRelevanceJudgementId  implements java.io.Serializable {


     private int queryId;
     private String queryTxt;
     private String queryType;
     private int issueId;
     private int docId;
     private String docName;
     private String docTxt;
     private String docType;
     private int fileId;
     private int revisionId;

    public VIrRelevanceJudgementId() {
    }

    public VIrRelevanceJudgementId(int queryId, String queryTxt, String queryType, int issueId, int docId, String docName, String docTxt, String docType, int fileId, int revisionId) {
       this.queryId = queryId;
       this.queryTxt = queryTxt;
       this.queryType = queryType;
       this.issueId = issueId;
       this.docId = docId;
       this.docName = docName;
       this.docTxt = docTxt;
       this.docType = docType;
       this.fileId = fileId;
       this.revisionId = revisionId;
    }
   


    @Column(name="query_id", nullable=false)
    public int getQueryId() {
        return this.queryId;
    }
    
    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }


    @Column(name="query_txt", nullable=false)
    public String getQueryTxt() {
        return this.queryTxt;
    }
    
    public void setQueryTxt(String queryTxt) {
        this.queryTxt = queryTxt;
    }


    @Column(name="query_type", nullable=false, length=200)
    public String getQueryType() {
        return this.queryType;
    }
    
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }


    @Column(name="issue_id", nullable=false)
    public int getIssueId() {
        return this.issueId;
    }
    
    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }


    @Column(name="doc_id", nullable=false)
    public int getDocId() {
        return this.docId;
    }
    
    public void setDocId(int docId) {
        this.docId = docId;
    }


    @Column(name="doc_name", nullable=false, length=800)
    public String getDocName() {
        return this.docName;
    }
    
    public void setDocName(String docName) {
        this.docName = docName;
    }


    @Column(name="doc_txt", nullable=false)
    public String getDocTxt() {
        return this.docTxt;
    }
    
    public void setDocTxt(String docTxt) {
        this.docTxt = docTxt;
    }


    @Column(name="doc_type", nullable=false, length=200)
    public String getDocType() {
        return this.docType;
    }
    
    public void setDocType(String docType) {
        this.docType = docType;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VIrRelevanceJudgementId) ) return false;
		 VIrRelevanceJudgementId castOther = ( VIrRelevanceJudgementId ) other; 
         
		 return (this.getQueryId()==castOther.getQueryId())
 && ( (this.getQueryTxt()==castOther.getQueryTxt()) || ( this.getQueryTxt()!=null && castOther.getQueryTxt()!=null && this.getQueryTxt().equals(castOther.getQueryTxt()) ) )
 && ( (this.getQueryType()==castOther.getQueryType()) || ( this.getQueryType()!=null && castOther.getQueryType()!=null && this.getQueryType().equals(castOther.getQueryType()) ) )
 && (this.getIssueId()==castOther.getIssueId())
 && (this.getDocId()==castOther.getDocId())
 && ( (this.getDocName()==castOther.getDocName()) || ( this.getDocName()!=null && castOther.getDocName()!=null && this.getDocName().equals(castOther.getDocName()) ) )
 && ( (this.getDocTxt()==castOther.getDocTxt()) || ( this.getDocTxt()!=null && castOther.getDocTxt()!=null && this.getDocTxt().equals(castOther.getDocTxt()) ) )
 && ( (this.getDocType()==castOther.getDocType()) || ( this.getDocType()!=null && castOther.getDocType()!=null && this.getDocType().equals(castOther.getDocType()) ) )
 && (this.getFileId()==castOther.getFileId())
 && (this.getRevisionId()==castOther.getRevisionId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getQueryId();
         result = 37 * result + ( getQueryTxt() == null ? 0 : this.getQueryTxt().hashCode() );
         result = 37 * result + ( getQueryType() == null ? 0 : this.getQueryType().hashCode() );
         result = 37 * result + this.getIssueId();
         result = 37 * result + this.getDocId();
         result = 37 * result + ( getDocName() == null ? 0 : this.getDocName().hashCode() );
         result = 37 * result + ( getDocTxt() == null ? 0 : this.getDocTxt().hashCode() );
         result = 37 * result + ( getDocType() == null ? 0 : this.getDocType().hashCode() );
         result = 37 * result + this.getFileId();
         result = 37 * result + this.getRevisionId();
         return result;
   }   


}

