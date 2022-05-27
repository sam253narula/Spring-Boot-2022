select * from student;

--For Passport is the owning side of the relationship
--insert into student (id,name) values (1,'Sam');
--insert into student (id,name) values (2,'Hiren');
--
--insert into passport (id, number,student_id) values(1,'IND100',1);
--insert into passport (id, number,student_id) values(2,'IND101',2);



--For Student is the owning side of the relationship
insert into passport (id, number) values(1,'IND100');
insert into passport (id, number) values(2,'IND101');

insert into student (id,name,passport_id) values (1,'Sam',1);
insert into student (id,name,passport_id) values (2,'Hiren',2);