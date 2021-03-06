package seers.irda.entity;
// Generated Dec 9, 2015 11:27:45 AM by Hibernate Tools 4.3.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Revision generated by hbm2java
 */
@Entity
@Table(name="revision"
    ,catalog="ir_issues"
    , uniqueConstraints = @UniqueConstraint(columnNames={"commit_id", "system_id"}) 
)
public class Revision  implements java.io.Serializable {


     private Integer id;
     private SoftwareSystem softwareSystem;
     private String alias;
     private String commitId;
     private String message;
     private String author;
     private Date date;
     private Set<ChangeSet> changeSets = new HashSet<ChangeSet>(0);
     private Set<IssueRevision> issueRevisions = new HashSet<IssueRevision>(0);
     private Set<IrDocument> irDocuments = new HashSet<IrDocument>(0);

    public Revision() {
    }

	
    public Revision(SoftwareSystem softwareSystem, String commitId, String message, String author, Date date) {
        this.softwareSystem = softwareSystem;
        this.commitId = commitId;
        this.message = message;
        this.author = author;
        this.date = date;
    }
    public Revision(SoftwareSystem softwareSystem, String alias, String commitId, String message, String author, Date date, Set<ChangeSet> changeSets, Set<IssueRevision> issueRevisions, Set<IrDocument> irDocuments) {
       this.softwareSystem = softwareSystem;
       this.alias = alias;
       this.commitId = commitId;
       this.message = message;
       this.author = author;
       this.date = date;
       this.changeSets = changeSets;
       this.issueRevisions = issueRevisions;
       this.irDocuments = irDocuments;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="system_id", nullable=false)
    public SoftwareSystem getSoftwareSystem() {
        return this.softwareSystem;
    }
    
    public void setSoftwareSystem(SoftwareSystem softwareSystem) {
        this.softwareSystem = softwareSystem;
    }

    
    @Column(name="alias", length=400)
    public String getAlias() {
        return this.alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }

    
    @Column(name="commit_id", nullable=false, length=200)
    public String getCommitId() {
        return this.commitId;
    }
    
    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    
    @Column(name="message", nullable=false)
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    
    @Column(name="author", nullable=false, length=400)
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", nullable=false, length=19)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="revision")
    public Set<ChangeSet> getChangeSets() {
        return this.changeSets;
    }
    
    public void setChangeSets(Set<ChangeSet> changeSets) {
        this.changeSets = changeSets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="revision")
    public Set<IssueRevision> getIssueRevisions() {
        return this.issueRevisions;
    }
    
    public void setIssueRevisions(Set<IssueRevision> issueRevisions) {
        this.issueRevisions = issueRevisions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="revision")
    public Set<IrDocument> getIrDocuments() {
        return this.irDocuments;
    }
    
    public void setIrDocuments(Set<IrDocument> irDocuments) {
        this.irDocuments = irDocuments;
    }




}


