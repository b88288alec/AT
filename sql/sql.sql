create schema TFHK;

use TFHK;
create table CFG_PARAM (
	CODE varchar(50),
    CODE_NAME varchar(50),
    CODE_VALUE varchar(50),
    CODE_DESC varchar(50),
    primary key(CODE)
);

create table CFG_USER (
    account varchar(30) not null primary key,
    name_en varchar(50),
    name_ch varchar(50),
    password varchar(30) not null
);

create table CFG_ROOTPATH_MAPPING (
	ROOT_PATH varchar(50) not null,
    FILE_TYPE varchar(50),
    account varchar(30),
    foreign key(account) references CFG_USER(account),
    foreign key(FILE_TYPE) references CFG_PARAM(CODE),
    primary key(ROOT_PATH, account)
);

create table CFG_FOLDER (
	FOLDER_NAME varchar(50) not null,
    FOLDER_PATH varchar(50) not null,
    ROOT_PATH varchar(50),
    update_date date,
    create_date date,
    FILE_TYPE varchar(50),
    account varchar(30),
    foreign key(ROOT_PATH) references CFG_ROOTPATH_MAPPING(ROOT_PATH),
    foreign key(account) references CFG_USER(account),
    foreign key(FILE_TYPE) references CFG_PARAM(CODE),
    primary key(FOLDER_PATH, account)
);

create table CUR_FILE (
	FILE_NAME varchar(50) not null,
    FILE_PATH varchar(50) not null,
    FOLDER_PATH varchar(50),
    mine_type varchar(50),
    update_date date,
    upload_date date,
    FILE_TYPE varchar(50),
    account varchar(30),
    foreign key(FOLDER_PATH) references CFG_FOLDER(FOLDER_PATH),
    foreign key(account) references CFG_USER(account),
    foreign key(FILE_TYPE) references CFG_PARAM(CODE),
    primary key(FILE_PATH, account)
);

insert into CFG_USER(account, name_en, name_ch, password) values('abc123', 'Ziv Fat', '肥宅', '12345');

select * from cfg_user where account = 'b88288alec'