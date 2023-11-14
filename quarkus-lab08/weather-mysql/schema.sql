create database if not exists `training`;
create table `training`.`temperatures` (
    `id` int(11) not null auto_increment,
    `temperature` float not null,
    `city` varchar(255) not null,
    `observation_date_time` timestamp not null default current_timestamp,
    primary key (`id`)
) engine=InnoDB default charset=utf8;
