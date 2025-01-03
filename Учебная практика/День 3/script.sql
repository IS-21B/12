create table categories (
  id bigint generated by default as identity primary key,
  name text not null
);

create table products (
  id bigint generated by default as identity primary key,
  name text not null,
  category_id bigint not null references categories,
  time integer not null,
  price float not null
);

create table actions (
  id bigint generated by default as identity primary key,
  title text not null,
  description text not null,
  price float not null,
  img text
);

INSERT INTO "public"."actions" ("id", "title", "description", "price", "img") VALUES 
('1', 'Чек-ап для мужчин', '9 исследований', '8000', 'DItYlc26zVI.png'), 
('2', 'Подготовка к вакцинации', 'Комплексное обследование перед вакцинацией', '4000', 'ZeMRI9vO71o.png');

INSERT INTO "public"."categories" ("id", "name") VALUES 
('1', 'Популярные'), 
('2', 'Covid'), 
('3', 'Комплексные'), 
('4', 'Чекапы'), 
('5', 'Биохимия'), 
('6', 'Гормоны'), 
('7', 'Иммунитет'), 
('8', 'Витамины'), 
('9', 'Аллергены'), 
('10', 'Анализ крови'), 
('11', 'Анализ мочи'), 
('12', 'Анализ кала'), 
('13', 'Только в клинике');

INSERT INTO "public"."products" ("id", "name", "category_id", "time", "price") VALUES 
('1', 'ПЦР-тест на определение РНК коронавируса стандартный', '1', '2', '1800'), 
('2', 'Клинический анализ крови с лейкоцитарной формулировкой', '1', '1', '690'), 
('3', 'Биохимический анализ крови, базовый', '1', '1', '2440'), 
('4', 'СОЭ (венозная кровь)', '1', '1', '240'), 
('5', 'Общий анализ мочи', '1', '1', '350'), 
('6', 'Тироксин свободный (Т4 свободный)', '1', '1', '680'), 
('7', 'Группа крови + Резус-фактор', '1', '1', '750'), 
('8', 'ПЦР-тест на определение РНК коронавируса стандартный', '2', '2', '1800'), 
('9', 'Клинический анализ крови с лейкоцитарной формулировкой', '10', '1', '690'), 
('10', 'Биохимический анализ крови, базовый', '5', '1', '2440'), 
('11', 'СОЭ (венозная кровь)', '10', '1', '240'), 
('12', 'Общий анализ мочи', '11', '1', '350'), 
('13', 'Тироксин свободный (Т4 свободный)', '6', '1', '680'), 
('14', 'Группа крови + Резус-фактор', '3', '1', '750'), 
('15', 'СОЭ (капиллярная кровь)', '10', '1', '400'), 
('16', 'Исследования кала на скрытую кровь', '12', '1', '400'), 
('17', 'Исследования кала на скрытую кровь', '12', '1', '400'), 
('18', 'Инфекции, передающиеся половым путем (кровь)', '10', '1', '800');