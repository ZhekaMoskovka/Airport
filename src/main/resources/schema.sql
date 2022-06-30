create database airport;

use airport;

create table passengers
(
id int not null auto_increment,
name varchar(255),
password varchar(255),
primary key (id)
);

create table passports 
(
id int not null auto_increment,
birthday date,
passport_number varchar(255),
passenger_id int,
primary key (id),
foreign key (passenger_id) references passengers (id)
);
create table roles 
(
id integer not null auto_increment, 
role varchar(255), 
primary key (id)
);

create table routes
(
id int not null auto_increment,
place_from varchar(255),
place_to varchar(255),
primary key (id)
);

create table airlines
(
id int not null auto_increment,
name varchar(255),
rating double precision not null,
planes varchar(255),
primary key (id)
);

create table planes
(
id int not null auto_increment,
name varchar(255),
primary key (id)
);

create table terminals
(
gate varchar(255),
name varchar(255),
primary key (gate)
);

create table flights
(
id int not null auto_increment,
time datetime,
route_id int,
airline_id int,
status varchar(255),
gate varchar(255),
primary key (id),
foreign key (airline_id) references airlines (id),
foreign key (route_id) references routes (id),
foreign key (gate) references terminals (gate)
);

create table tickets
(
id int not null auto_increment,
place varchar(255),
flight_id int,
passenger_id int,
primary key (id),
foreign key (flight_id) references flights (id),
foreign key (passenger_id) references passengers (id)
);

create table work_types
(
id int not null auto_increment,
name varchar(255),
primary key (id)
);

create table employees
(
id int not null auto_increment,
name varchar(255),
salary double precision not null,
work_type_id int,
primary key(id),
foreign key (work_type_id) references work_types (id)
);

create table planes_airlines 
(
plane_id integer not null, 
airline_id integer not null, 
foreign key (airline_id) references airlines (id),
foreign key (plane_id) references planes (id)
);
create table employees_terminals 
(
employee_id integer not null,
gate varchar(255) not null,
foreign key (gate) references terminals (gate),
foreign key (employee_id) references employees (id)
);
create table roles_passengers 
(
role_id integer not null, 
passenger_id integer not null,
foreign key (passenger_id) references passengers (id),
foreign key (role_id) references roles (id)
);