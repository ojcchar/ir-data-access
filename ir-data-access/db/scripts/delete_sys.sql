set @sysname='solr';

select @sys := id from software_system
where name = @sysname;

delete from change_set 
	where revision_id in (
	select id from revision
	where system_id =@sys
);

delete from ir_relevance_judgement
where document_id in (
	select d.id from revision r, ir_document d
	where r.system_id =@sys
    and d.revision_id = r.id
);

delete from ir_document 
	where revision_id in (
	select id from revision
	where system_id =@sys
);

delete from issue_revision
where revision_id  in (
	select id from revision
	where system_id =@sys
); 

delete from revision
where system_id =@sys;

delete from code_file
where system_id = @sys;

delete from ir_query 
where issue_id in (
	select id from issue
	where system_id =@sys
);

delete from issue
where system_id =@sys;


delete from software_system
where id = @sys;

