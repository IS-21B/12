create table orders (
  id bigint generated by default as identity primary key,
  user_id uuid not null references auth.users,
  adress text not null,
  phone text not null,
  comment text,
  amount float not null
);

create table order_products (
  order_id bigint not null references orders,
  product_id bigint not null references products,
  product_price float not null
);