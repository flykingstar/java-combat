CREATE TABLE IF NOT EXISTS t_order
(
    id           int unsigned primary key auto_increment comment '主键',
    `code`       varchar(200)            not null comment '流水号',
    type         tinyint unsigned        not null comment '订单类型：1实体销售，2网络销售',
    shop_id      int unsigned comment '零售店ID',
    user_id  int unsigned comment '会员ID',
    amount       decimal(10, 2) unsigned not null comment '总金额',
    payment_type tinyint unsigned        not null comment '支付方式：1借记卡、2信用卡、3微信、4支付宝、5现金',
    `status`     tinyint unsigned        not null comment '状态：1未付款、2已付款、3已发货、4已签收',
    postage      decimal(10, 2) unsigned comment '邮费',
    weight       int unsigned comment '重量：单位克',
    voucher_id   int unsigned comment '购物券ID',
    create_time  timestamp               not null default now()
) comment = '订单表';


INSERT INTO sharding_db.t_order
(code, `type`, shop_id, user_id, amount, payment_type, status, postage, weight, voucher_id, create_time)
VALUES('W00001', 1, 6666, 1001, 100.00, 1, 1, 5.00, 5, 333, CURRENT_TIMESTAMP);

INSERT INTO sharding_db.t_order
(code, `type`, shop_id, user_id, amount, payment_type, status, postage, weight, voucher_id, create_time)
VALUES('W00002', 1, 6666, 1002, 100.00, 1, 1, 5.00, 5, 333, CURRENT_TIMESTAMP);

INSERT INTO sharding_db.t_order
(code, `type`, shop_id, user_id, amount, payment_type, status, postage, weight, voucher_id, create_time)
VALUES('W00003', 1, 6666, 1003, 100.00, 1, 1, 5.00, 5, 333, CURRENT_TIMESTAMP);

INSERT INTO sharding_db.t_order
(code, `type`, shop_id, user_id, amount, payment_type, status, postage, weight, voucher_id, create_time)
VALUES('W00004', 1, 6666, 1004, 100.00, 1, 1, 5.00, 5, 333, CURRENT_TIMESTAMP);

INSERT INTO sharding_db.t_order
(code, `type`, shop_id, user_id, amount, payment_type, status, postage, weight, voucher_id, create_time)
VALUES('W00005', 1, 6666, 1005, 100.00, 1, 1, 5.00, 5, 333, CURRENT_TIMESTAMP);

update sharding_db.t_order set type = 2 where code = 'W00002';

delete from sharding_db.t_order where code = 'W00002';

select * from sharding_db.t_order;