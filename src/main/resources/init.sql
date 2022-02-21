drop database airport;

create database airport;

use airport;

create table passengers
(
passport_id varchar(15),
name varchar(50),
birthday_date varchar(10)
);

create table tickets
(
id int not null,
place varchar(5),
flight_id int,
passanger_id varchar(20)
);

create table flights
(
id int not null,
route_id int,
time varchar(20),
airline_id int,
status varchar(20)
);

create table routes
(
id int not null,
place_from varchar(20),
place_to varchar(20)
);

create table airlines
(
id int not null,
name varchar(30),
rating double,
planes varchar(30)
);

create table planes
(
id int not null,
name varchar(30)
);

create table terminals
(
gate varchar(10),
name varchar(30)
);

create table employees
(
id int not null,
name varchar(30),
salary double,
work_type_id int
);

create table work_types
(
id int not null,
name varchar(20)
);

insert passengers (passport_id, name, birthday_date)
values ('TH-4567891', 'Ivanov Ivan', '12.04.1994'),
('632574352', 'Moroz Bogdan', '02.11.2000'),
('736948783', 'Lepuh Oleksandr', '16.06.1984'),
('JK-7435672', 'Zhyla Vladislav', '24.10.1999'),
('247591083', 'Gonchar Sergij', '11.02.1988');

insert tickets (id, place, flight_id, passanger_id)
values (452341, '744F', 2, 'TH-4567891'),
(874781, '782H', 1, '632574352'),
(652562, '621H', 1, '736948783'),
(432356, '143J', 2, 'JK-7435672'),
(922476, '523F', 1, '247591083');

insert flights (id, route_id, time, airline_id, status)
values (1, 4, '19:40', 2, 'waiting'),
(2, 2, '12:15', 1, 'finished');

insert routes (id, place_from, place_to)
values (1, 'Kiev', 'Berlin'),
(2, 'Kiev', 'Barcelona'),
(3, 'Kiev', 'Budapesht'),
(4, 'Kiev', 'London');


insert airlines (id, name, rating, planes)
values (1, 'Turkish Airlines', 4.7, 'Boeing'),
(2, 'Singapour Airlines', 3.9, 'Airbus');

insert planes (id, name)
values (1, 'Boeing 747'),
(2, 'Boeing 757'),
(3, 'Boeing 797'),
(4, 'Airbus A380');

insert terminals (gate, name)
values ('N37', 'West Terminal'),
('T45', 'East Terminal');

insert employees (id, name, salary, work_type_id)
values (1, 'Lehov Maxim', 34000, 3),
(2, 'Olivenko Gregorii', 26000, 1),
(3, 'Olivenko Natalia', 28000, 3),
(4, 'Niverenko Oleg', 32000, 2),
(5, 'Telibov Valery', 26000, 1);

insert work_types (id, name)
values (1, 'Manager'),
(2, 'Airport dispatcher'),
(3, 'Pilot');