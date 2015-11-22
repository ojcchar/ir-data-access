

INSERT INTO `ir_issues`.`software_system`
(`name`)
VALUES
('birt');

select * from 
`ir_issues`.`software_system`;

#-----------------------------------------------------


select bug_id, "Bug", summary, description, report_time, status, importance, reporter, CONCAT_WS(' ', product, component), 3
 from birt.bug_commit;

INSERT INTO `ir_issues`.`issue`
(`issue_id`,
`type`,
`summary`,
`description`,
`create_date`,
`status`,
`priority`,
`reporter`,
`components`,
`system_id`)
select distinct bug_id, "Bug", summary, description, report_time, status, importance, reporter, CONCAT_WS(' ', product, component), 3
 from birt.bug_commit;

#-----------------------------------------------------
  
select commit,log,author,commit_time, 3
 from birt.bug_commit;

INSERT INTO `ir_issues`.`revision`
(`commit_id`,
`message`,
`author`,
`date`,
`system_id`)
select distinct commit,log,author,commit_time, 3
 from birt.bug_commit;

#-----------------------------------------------------

select distinct c.id as  issue_id, d.id as revision_id
from 
(
select b.id, b.issue_id
from 
birt.bug_commit a, ir_issues.issue b 
where a.bug_id = b.issue_id
and b.system_id =3
) c,
(
select b.id, a.bug_id
from 
birt.bug_commit a, ir_issues.revision b 
where a.commit = b.commit_id
and b.system_id =3
) d
where c.issue_id= d.bug_id;


INSERT INTO `ir_issues`.`issue_revision`
(`issue_id`,
`revision_id`)
select distinct c.id as  issue_id, d.id as revision_id
from 
(
select b.id, b.issue_id
from 
birt.bug_commit a, ir_issues.issue b 
where a.bug_id = b.issue_id
and b.system_id =3
) c,
(
select b.id, a.bug_id
from 
birt.bug_commit a, ir_issues.revision b 
where a.commit = b.commit_id
and b.system_id =3
) d
where c.issue_id= d.bug_id;

#-----------------------------------------------------

select distinct a.bag_of_word_stemmed, 'default', b.id
from birt.bug_and_files a, ir_issues.issue b 
where a.bug_id = b.issue_id
and b.system_id = 3;


INSERT INTO `ir_issues`.`ir_query`
(`txt`,
`type`,
`issue_id`)
select distinct a.bag_of_word_stemmed, 'default', b.id
from birt.bug_and_files a, ir_issues.issue b 
where a.bug_id = b.issue_id
and b.system_id = 3;


#-----------------------------------------------------

