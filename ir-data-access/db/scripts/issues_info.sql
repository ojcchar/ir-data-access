use ir_issues;

set @sysname='aspectj';

select @sys := id from software_system
where name = @sysname;

select s.summary, q.id as query_id,rj.doc_id,  r.id as revision_id, r.commit_id, f.id as file_id, f.file_path, c.change_type, s.issue_id
from issue s, ir_query q, 
	issue_revision ir, revision r,
    change_set c, code_file f, v_ir_relevance_judgement rj
where s.system_id = @sys
and s.id = q.issue_id
and ir.issue_id = s.id
and ir.revision_id = r.id
and c.revision_id = r.id
and c.file_id = f.id
and f.type = 'JAVA'
and ir.type = 'CHANGE'
and rj.query_id = q.id
and rj.revision_id = r.id
and rj.file_id = f.id
order by s.issue_id,  ir.type desc,  r.commit_id, f.file_path
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/data_issues.csv'
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';
;

/*
select s.issue_id, s.summary, q.id as query_id, d.id as doc_id, r.id as rev_id, r.commit_id, f.file_path
from issue s, ir_query q, ir_relevance_judgement rj,
	ir_document d, revision r, code_file f
where s.system_id = @sys
and s.id = q.issue_id
and rj.query_id = q.id
and rj.document_id = d.id
and d.revision_id = r.id
and d.file_id = f.id
order by s.issue_id, r.commit_id, f.file_path
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/data_queries.csv'
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';
;
*/

select q.id
from issue s, ir_query q
where s.system_id = @sys
and s.id = q.issue_id
INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/queries.csv'
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';


