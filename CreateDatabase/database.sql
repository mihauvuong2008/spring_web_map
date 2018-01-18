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
 
---------------------
 
-- Create table
create table USER_ROLES
(
ROLE_ID   VARCHAR(50) not null,
USERNAME  VARCHAR(36) not null,
USER_ROLE VARCHAR(30) not null
) ;

-- Create table
create table POINT
( 
POINT_ID   SERIAL PRIMARY KEY,
X_DATA bigint not null, 
Y_DATA bigint not null
) ;


-- Create table
create table TUYEN_CAP
(
TUYEN_CAP_ID   SERIAL PRIMARY KEY,
TEN_TUYEN_CAP VARCHAR(300) not null,
CHIEU_DAI_TUYEN_CAP integer,
SO_CORE integer,
VI_TRI_DIEM_DAU_ID SERIAL not null,
VI_TRI_DIEM_CUOI_ID SERIAL not null,
MO_TA_TUYEN_CAP VARCHAR(500) not null,
  FOREIGN KEY   (VI_TRI_DIEM_DAU_ID) REFERENCES POINT(POINT_ID),
  FOREIGN KEY   (VI_TRI_DIEM_CUOI_ID) REFERENCES POINT(POINT_ID)
);

create table HAM_CAP
(
HAM_CAP_ID  SERIAL PRIMARY KEY,
TEN_HAM_CAP VARCHAR(300) not null,
TREO_NGAM smallint,
VI_TRI_ID integer not null,
  FOREIGN KEY (VI_TRI_ID) REFERENCES POINT(POINT_ID)
) ;

create table MANG_XONG
(
MANG_XONG_ID   SERIAL PRIMARY KEY,
GHI_CHU   VARCHAR(500)
) ;

create table TUYEN_CAP_HAM_CAP_MANG_XONG
(
TUYEN_CAP_ID  serial not null,
HAM_CAP_ID   serial not null,
MANG_XONG_ID   serial,
  FOREIGN KEY (TUYEN_CAP_ID) REFERENCES TUYEN_CAP(TUYEN_CAP_ID),
  FOREIGN KEY (HAM_CAP_ID) REFERENCES HAM_CAP(HAM_CAP_ID),
  FOREIGN KEY (MANG_XONG_ID) REFERENCES MANG_XONG(MANG_XONG_ID)
) ;



alter table USERS
add constraint USER_PK primary key (USERNAME);
 
alter table USER_ROLES
add constraint USER_ROLE_PK primary key (ROLE_ID);
 
alter table USER_ROLES
add constraint USER_ROLE_UK unique (USERNAME, USER_ROLE);
 
-------------------------------

insert into users (USERNAME, HOTEN, NGAYSINH, LIENHE, GIOITHIEU, PASSWORD, ENABLED)
values ('dbuser1', 'Nguyen Van A', '1990-11-10', '0977245542', 'can bo', '12345', 1);
 
insert into users (USERNAME, PASSWORD, ENABLED)
values ('dbadmin1', 'Nguyen Van B', '1990-11-11', '0977245543', 'can bo', '12345', 1);
 
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('1', 'dbuser1', 'USER');
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('2', 'dbadmin1', 'ADMIN');
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('3', 'dbadmin1', 'USER');