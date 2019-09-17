create table departments(
	did int(12) primary key auto_increment,
	dname char(12),
	id int(12),
	job char(1)
);

insert into departments(did,dname,id,job)values(1,'magic',1010,'S');

select * from departments;
