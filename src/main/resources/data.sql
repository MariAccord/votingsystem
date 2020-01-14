DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM restaurants;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (id, name, email, password, enabled, registered) VALUES
(100000, 'User0', 'user0@yandex.ru', '{noop}password', true, now()),
(100001, 'User1', 'user1@yandex.ru', '{noop}password', true, now()),
(100005, 'User5', 'user5@yandex.ru', '{noop}password', true, now()),
(100006, 'User6', 'user6@yandex.ru', '{noop}password', true, now()),
(100007, 'User7', 'user7@yandex.ru', '{noop}password', true, now()),
(100008, 'User8', 'user8@yandex.ru', '{noop}password', true, now()),
(100009, 'Admin1', 'admin@gmail.com', '{noop}admin', true, now());

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_USER', 100001),
('ROLE_USER', 100005),
('ROLE_USER', 100006),
('ROLE_USER', 100007),
('ROLE_USER', 100008),
('ROLE_USER', 100009),
('ROLE_ADMIN', 100009);

INSERT INTO restaurants (name, id, enabled) VALUES
('Пельменная', 100002, true),
('Семейное кафе', 100003, true),
('Закусочная', 100010, true),
('Маяк', 100004, true);

UPDATE restaurants SET enabled = false WHERE id = 100010;

INSERT INTO meals (restaurant_id, name, price, date) VALUES
(100004, 'Борщ', 140, '2020-01-14'),
(100004, 'Макароны', 90, '2020-01-14'),
(100004, 'Компот', 20, '2020-01-14'),
(100002, 'Суп', 120, '2020-01-14'),
(100002, 'Пельмени', 70, '2020-01-14'),
(100002, 'Сок', 30, '2020-01-14'),
(100003, 'Уха', 130, '2020-01-14'),
(100003, 'Плов', 100, '2020-01-14'),
(100003, 'Чай', 20, '2020-01-14');

INSERT INTO votes (restaurant_id, user_id, date_time) VALUES
(100004, 100008, '2020-01-14 10:01:00'),
(100002, 100006, '2020-01-14 10:07:00'),
(100002, 100005, '2020-01-14 10:09:00'),
(100003, 100007, '2020-01-14 10:10:00'),
(100003, 100009, '2020-01-14 10:11:00'),
(100003, 100001, '2020-01-14 10:12:00');

DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM restaurants;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (id, name, email, password, enabled, registered) VALUES
(100000, 'User0', 'user0@yandex.ru', '{noop}password', true, now()),
(100001, 'User1', 'user1@yandex.ru', '{noop}password', true, now()),
(100005, 'User5', 'user5@yandex.ru', '{noop}password', true, now()),
(100006, 'User6', 'user6@yandex.ru', '{noop}password', true, now()),
(100007, 'User7', 'user7@yandex.ru', '{noop}password', true, now()),
(100008, 'User8', 'user8@yandex.ru', '{noop}password', true, now()),
(100009, 'Admin1', 'admin@gmail.com', '{noop}admin', true, now());

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_USER', 100001),
('ROLE_USER', 100005),
('ROLE_USER', 100006),
('ROLE_USER', 100007),
('ROLE_USER', 100008),
('ROLE_USER', 100009),
('ROLE_ADMIN', 100009);

INSERT INTO restaurants (name, id, enabled) VALUES
('Пельменная', 100002, true),
('Семейное кафе', 100003, true),
('Закусочная', 100010, true),
('Маяк', 100004, true);

UPDATE restaurants SET enabled = false WHERE id = 100010;

INSERT INTO meals (restaurant_id, name, price, date) VALUES
(100004, 'Борщ', 140, '2020-01-14'),
(100004, 'Макароны', 90, '2020-01-14'),
(100004, 'Компот', 20, '2020-01-14'),
(100002, 'Суп', 120, '2020-01-14'),
(100002, 'Пельмени', 70, '2020-01-14'),
(100002, 'Сок', 30, '2020-01-14'),
(100003, 'Уха', 130, '2020-01-14'),
(100003, 'Плов', 100, '2020-01-14'),
(100003, 'Чай', 20, '2020-01-14');

INSERT INTO votes (restaurant_id, user_id, date_time) VALUES
(100004, 100008, '2020-01-14 10:01:00'),
(100002, 100006, '2020-01-14 10:07:00'),
(100002, 100005, '2020-01-14 10:09:00'),
(100003, 100007, '2020-01-14 10:10:00'),
(100003, 100009, '2020-01-14 10:11:00'),
(100003, 100001, '2020-01-14 10:12:00');

