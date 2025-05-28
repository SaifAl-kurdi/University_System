-- University

Create Table Department (
	id int primary key,
	name varchar(255) unique not null
)

Insert into Department values (1, 'Information Technology')
Select * From Department 
Drop Table Department;

Create Table Course (
	id int primary key IDENTITY(1,1),
	name varchar(255) unique not null,
	isActive bit not null,
	numberOfHours int not null,
	departmentId int not null,
	CONSTRAINT FK_departmentId Foreign key (departmentId) References Department(id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
)

Insert Into Course Values ('Programming', 1, 3, 1)
Select * From Course

ALTER TABLE Course
DROP COLUMN departmentid_id;

Drop table Course
