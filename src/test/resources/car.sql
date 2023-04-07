insert into jpa.public.car
(id, type, color, registration_plate)
values
(1, 'Seat', 'Blauw', 'P-468-LJ');

update jpa.public.person
set car_id = 1
where id = 1;
