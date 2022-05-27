SELECT * FROM COURSE;
--
insert into course(id, name, created_date, last_updated_date) 
values(1,'Spring Boot JPA', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(2,'Spring Boot AWS Utilites', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(3,'Spring Boot PCF Cloud Deployment', sysdate(), sysdate());

insert into student(id,name)
values(1,'Sam');
insert into student(id,name)
values(2,'Hiran');

-- When Course is the owning side of the relationship.
--insert into COURSE_ENROLLED_BY_STUDENTS(course_id,student_id)
--values(1,1);
--insert into COURSE_ENROLLED_BY_STUDENTS(course_id,student_id)
--values(2,1);
--insert into COURSE_ENROLLED_BY_STUDENTS(course_id,student_id)
--values(3,1);
--insert into COURSE_ENROLLED_BY_STUDENTS(course_id,student_id)
--values(1,2);
--insert into COURSE_ENROLLED_BY_STUDENTS(course_id,student_id)
--values(2,2);

-- When Student is the owning side of the relationship.
insert into student_enrolled_courses(student_id,course_id)
values(1,1);
insert into student_enrolled_courses(student_id,course_id)
values(1,2);
insert into student_enrolled_courses(student_id,course_id)
values(1,3);
insert into student_enrolled_courses(student_id,course_id)
values(2,1);
insert into student_enrolled_courses(student_id,course_id)
values(2,2);

