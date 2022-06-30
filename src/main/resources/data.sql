use airport;

insert passengers (name, password)
values ('Ivanov Ivan', 'd648c6a77fb7a109e0f0128c65b33cfd9594f28c0db3eda99e79ceafce14948f1e1472dafc2cf9b5'),
('Moroz Bogdan', 'd648c6a77fb7a109e0f0128c65b33cfd9594f28c0db3eda99e79ceafce14948f1e1472dafc2cf9b5'),
('Lepuh Oleksandr', 'd648c6a77fb7a109e0f0128c65b33cfd9594f28c0db3eda99e79ceafce14948f1e1472dafc2cf9b5'),
('Zhyla Vladislav', 'd648c6a77fb7a109e0f0128c65b33cfd9594f28c0db3eda99e79ceafce14948f1e1472dafc2cf9b5'),
('Gonchar Sergij', '5922cd0a0d7609ff96b5afaddc49e46783696aea890db4db7f05bd38b864665f69881737778b1918');

insert passports (birthday, passport_number, passenger_id)
values ('1994-02-12', 'TH-4567891', 1),
('2000-11-02', '632574352', 2),
('1984-06-12', '736948783', 3),
('1999-10-24', 'JK-7435672', 4),
('1988-02-11', '247591083', 5);

insert roles (role)
values ('USER'),
('ADMIN');

insert terminals (gate, name)
values ('N37', 'West Terminal'),
('T45', 'East Terminal');

insert airlines (name, rating)
values ('Turkish Airlines', 4.7),
('Singapour Airlines', 3.9);

insert routes (place_from, place_to)
values ('Kiev', 'Berlin'),
('Kiev', 'Barcelona'),
('Kiev', 'Budapesht'),
('Kiev', 'London');

insert flights (route_id, time, airline_id, status, gate)
values (4, '2022-04-12 19:40:00', 2, 'waiting', 'N37'),
(2, '2022-04-10 12:15:00', 1, 'finished', 'T45');

insert tickets (place, flight_id, passenger_id)
values ('744F', 2, 1),
('782H', 1, 2),
('621H', 1, 3),
('143J', 2, 4),
('560M', 1, null),
('111G', 2, null),
('523F', 1, 5);

insert planes (name)
values ('Boeing 747'),
('Boeing 757'),
('Boeing 797'),
('Airbus A380');

insert work_types (name)
values ('Manager'),
('Airport dispatcher'),
('Pilot');

insert employees (name, salary, work_type_id)
values ('Lehov Maxim', 34000, 3),
('Olivenko Gregorii', 26000, 1),
('Olivenko Natalia', 28000, 3),
('Niverenko Oleg', 32000, 2),
('Telibov Valery', 26000, 1);

insert planes_airlines (plane_id, airline_id)
values (1, 1),
(2, 1),
(3, 1),
(3, 2),
(4, 1),
(4, 2);

insert employees_terminals (employee_id, gate)
values (1, 'N37'),
(2, 'N37'),
(2, 'T45'),
(3, 'T45'),
(4, 'T45'),
(4, 'N37'),
(5, 'T45');

insert roles_passengers(role_id, passenger_id)
values (1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5);