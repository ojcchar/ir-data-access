package seers.irda.entity;
// Generated Nov 19, 2015 11:09:07 AM by Hibernate Tools 4.3.1.Final


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IrRelevanceJudgementId generated by hbm2java
 */
@Embeddable
public class IrRelevanceJudgementId  implements java.io.Serializable {


     private int documentId;
     private int queryId;

    public IrRelevanceJudgementId() {
    }

    public IrRelevanceJudgementId(int documentId, int queryId) {
       this.documentId = documentId;
       this.queryId = queryId;
    }
   


    @Column(name="document_id", nullable=false)
    public int getDocumentId() {
        return this.documentId;
    }
    
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }


    @Column(name="query_id", nullable=false)
    public int getQueryId() {
        return this.queryId;
    }
    
    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof IrRelevanceJudgementId) ) return false;
		 IrRelevanceJudgementId castOther = ( IrRelevanceJudgementId ) other; 
         
		 return (this.getDocumentId()==castOther.getDocumentId())
 && (this.getQueryId()==castOther.getQueryId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getDocumentId();
         result = 37 * result + this.getQueryId();
         return result;
   }   


}


