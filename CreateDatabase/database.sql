-- Create table
create table USERS
(
USERNAME VARCHAR(36) not null,
HOTEN 	 VARCHAR(100) not null,
NGAYSINH DATE,
LIENHE   VARCHAR(300),
GIOITHIEU VARCHAR(600),
PASSWORD VARCHAR(36) not null,
LAST_MODIFY DATE,
ENABLED  smallint not null
) ;
 
alter table USERS
add constraint USER_PK primary key (USERNAME);
 
---------------------
 
-- Create table
create table USER_ROLES
(
ROLE_ID   VARCHAR(50) not null,
USERNAME  VARCHAR(36) not null,
USER_ROLE VARCHAR(30) not null
) ;

-- Create table
create table TUYEN_CAP
(
TUYEN_CAP_ID   VARCHAR(50) not null,
TEN_TUYEN_CAP VARCHAR(300) not null,
CHIEU_DAI_TUYEN_CAP integer,
SO_CORE integer,
MANG_XONG_DIEM_DAU_ID VARCHAR(50) not null,
MANG_XONG_DIEM_CUOI_ID VARCHAR(50) not null,
MO_TA_TUYEN_CAP VARCHAR(500) not null
);

 create table HAM_CAP
(
HAM_CAP_ID   VARCHAR(50) not null,
TEN_HAM_CAP VARCHAR(300) not null,
TREO_NGAM smallint,
VI_TRI_ID VARCHAR(50) not null
) ;
 
alter table USER_ROLES
add constraint USER_ROLE_PK primary key (ROLE_ID);
 
alter table USER_ROLES
add constraint USER_ROLE_UK unique (USERNAME, USER_ROLE);
 
-------------------------------
 
insert into users (USERNAME, PASSWORD, ENABLED)
values ('dbuser1', '12345', 1);
 
insert into users (USERNAME, PASSWORD, ENABLED)
values ('dbadmin1', '12345', 1);  
 
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('1', 'dbuser1', 'USER');
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('2', 'dbadmin1', 'ADMIN');
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('3', 'dbadmin1', 'USER');