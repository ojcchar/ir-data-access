package seers.irda.entity;
// Generated Dec 9, 2015 11:27:45 AM by Hibernate Tools 4.3.1.Final


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * IssueRevision generated by hbm2java
 */
@Entity
@Table(name="issue_revision"
    ,catalog="ir_issues"
)
public class IssueRevision  implements java.io.Serializable {


     private IssueRevisionId id;
     private Issue issue;
     private Revision revision;

    public IssueRevision() {
    }

    public IssueRevision(IssueRevisionId id, Issue issue, Revision revision) {
       this.id = id;
       this.issue = issue;
       this.revision = revision;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="issueId", column=@Column(name="issue_id", nullable=false) ), 
        @AttributeOverride(name="revisionId", column=@Column(name="revision_id", nullable=false) ), 
        @AttributeOverride(name="type", column=@Column(name="type", nullable=false, length=200) ) } )
    public IssueRevisionId getId() {
        return this.id;
    }
    
    public void setId(IssueRevisionId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="issue_id", nullable=false, insertable=false, updatable=false)
    public Issue getIssue() {
        return this.issue;
    }
    
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="revision_id", nullable=false, insertable=false, updatable=false)
    public Revision getRevision() {
        return this.revision;
    }
    
    public void setRevision(Revision revision) {
        this.revision = revision;
    }




}


