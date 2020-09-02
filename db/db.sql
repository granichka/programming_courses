insert into courses (name) values ('Основы языка Java');
insert into courses (name) values ('Основы языка Python');
insert into courses (name) values ('Основы языка JavaScript');
insert into courses (name) values ('Java Enterprise');

insert into teachers (email, name, phone_number) values ('petrov@gmail.com', 'Петров Иван Сергеевич', '+380684669877');
insert into teachers (email, name, phone_number) values ('ivanov@gmail.com', 'Иванов Дмитрий Андреевич', '+380671249877');
insert into teachers (email, name, phone_number) values ('nikituk@gmail.com', 'Никитюк Светлана Васильевна', '+380971249111');
insert into teachers (email, name, phone_number) values ('afan@gmail.com', 'Афанасьева Мария Петровна', '+380666183877');

insert into groups (course_id, teacher_id) values (1, 1);
insert into groups (course_id, teacher_id) values (4, 1);
insert into groups (course_id, teacher_id) values (3, 4);
insert into groups (course_id, teacher_id) values (4, 3);


insert into students (email, name, phone_number, group_id) values ('slinko@gmail.com', 'Слинько Маргарита Дмитриевна', '+380984567123', 1);
insert into students (email, name, phone_number, group_id) values ('funfunfun@gmail.com', 'Кравцов Александр Анатольевич', '+380985588123', 1);
insert into students (email, name, phone_number, group_id) values ('samoylov@gmail.com', 'Самойлов Максим Иванович', '+380961847123', 4);
insert into students (email, name, phone_number, group_id) values ('timof@gmail.com', 'Тимофеев Евгений Александрович', '+380974511123', 4);


insert into topics (name) values ('ООП');
insert into topics (name) values ('SOLID');
insert into topics (name) values ('Синтаксис языка');
insert into topics (name) values ('Spring Framework');


insert into lessons (date, time, group_id, topic_id) values ('2020-09-01', '19:00:00' , 1, 3);
insert into lessons (date, time, group_id, topic_id) values ('2020-09-01', '15:00:00', 4, 2);
insert into lessons (date, time, group_id, topic_id) values ('2020-09-05', '19:00:00', 4, 4);
insert into lessons (date, time, group_id, topic_id) values ('2020-09-10', '19:00:00', 4, 4);

insert into grades (lesson_id, student_id, value) values (2, 4, 5);
insert into grades (lesson_id, student_id, value) values (2, 3, 4);
insert into grades (lesson_id, student_id, value) values (3, 4, 4);
insert into grades (lesson_id, student_id, value) values (3, 3, 5);

insert into students (email, name, phone_number, group_id)
values ('blablabla@gmail.com', 'Дубова Ирина Николаевна', '+380963451275', 1);
insert into students (email, name, phone_number, group_id)
values ('kukushkin@gmail.com', 'Кукушкин Дмитрий Степанович', '+380963883375', 1);

insert into students (email, name, phone_number, group_id)
values ('mishina@gmail.com', 'Мишина Елена Николаевна', '+380969152275', 2);
insert into students (email, name, phone_number, group_id)
values ('reznik@gmail.com', 'Резник Семен Анатольевич', '+380963451111', 2);
insert into students (email, name, phone_number, group_id)
values ('popov@gmail.com', 'Попов Никита Андреевич', '+380963452222', 2);
insert into students (email, name, phone_number, group_id)
values ('vicavica@gmail.com', 'Попова Виктория Андреевна', '+380963455555', 2);

insert into topics (name) values ('Module');

insert into lessons (date, time, group_id, topic_id) values ('2020-08-31', '13:00:00', 1, 5);
insert into lessons (date, time, group_id, topic_id) values ('2020-08-31', '13:00:00', 2, 5);

insert into grades (lesson_id, student_id, value) values (5, 1, 5);
insert into grades (lesson_id, student_id, value) values (5, 2, 4.5);
insert into grades (lesson_id, student_id, value) values (5, 5, 3);
insert into grades (lesson_id, student_id, value) values (5, 6, 3);

insert into grades (lesson_id, student_id, value) values (6, 7, 3.5);
insert into grades (lesson_id, student_id, value) values (6, 8, 4.5);
insert into grades (lesson_id, student_id, value) values (6, 9, 5);
insert into grades (lesson_id, student_id, value) values (6, 10, 5);