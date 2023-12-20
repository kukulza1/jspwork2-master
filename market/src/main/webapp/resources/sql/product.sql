create table product(
    pno int primary key auto_increment, -- 일련번호 
    pid varchar(10) unique,     -- 상품코드    
    pname  varchar(30) not null,
    price    int not null,
    p_description  text not null,  -- 상세설명
    p_category   varchar(30),       -- 상품분류
    p_stock       long,              -- 재고
    p_condition  varchar(30),          -- 신상품,재고품
    p_image      varchar(30),
    regdate       datetime default now(),  -- 등록일
    updatedate     datetime   -- 수정일
);
