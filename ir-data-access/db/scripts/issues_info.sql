set @sysname='aspectj';

select @sys := id from software_system
where name = @sysname;

select s.issue_id, s.summary, r.id as revision_id, r.commit_id, ir.type as iss_rev_type,  f.file_path, f.type as file_type
from issue s, ir_query q, 
	issue_revision ir, revision r,
    change_set c, code_file f
where s.system_id = @sys
and s.id = q.issue_id
and ir.issue_id = s.id
and ir.revision_id = r.id
and c.revision_id = r.id
and c.file_id = f.id
and f.type = 'JAVA'
order by s.issue_id,  ir.type desc,  r.commit_id, f.file_path
;


