create table t_customer
(
    id               int unsigned primary key auto_increment comment '主键',
    username         varchar(200)  not null comment '用户名',
    password         varchar(2000) not null comment '密码(AES加密)',
    wechat           varchar(200) comment '微信号',
    tel              char(11) comment '手机号',
    level_id         int unsigned comment '会员等级ID',
    create_time      timestamp     not null default now() comment '添加时间',
    last_update_time timestamp     not null default now() comment '最后修改时间',
    index idx_username (username),
    unique unq_username (username)
) comment '客户表';

create table t_spu
(
    id               int unsigned primary key auto_increment comment '主键',
    title            varchar(200) not null comment '标题',
    sub_title        varchar(200) comment '副标题',
    category_id      int unsigned not null comment '分类ID',
    brand_id         int unsigned comment '品牌ID',
    spg_id           int unsigned comment '品类ID',
    saleable         boolean      not null comment '是否上架',
    valid            boolean      not null comment '是否有效',
    create_time      timestamp    not null default now() comment '添加时间',
    last_update_time timestamp    not null default now() comment '最后修改时间',
    index idx_category_id (category_id),
    index idx_brand_id (brand_id),
    index idx_spg_id (spg_id),
    index idx_saleable (saleable),
    index idx_valid (valid)

) comment ='产品表';

create table t_order
(
    id           int unsigned primary key auto_increment comment '主键',
    `code`       varchar(200)            not null comment '流水号',
    type         tinyint unsigned        not null comment '订单类型：1实体销售，2网络销售',
    shop_id      int unsigned comment '零售店ID',
    customer_id  int unsigned comment '会员ID',
    amount       decimal(10, 2) unsigned not null comment '总金额',
    payment_type tinyint unsigned        not null comment '支付方式：1借记卡、2信用卡、3微信、4支付宝、5现金',
    `status`     tinyint unsigned        not null comment '状态：1未付款、2已付款、3已发货、4已签收',
    postage      decimal(10, 2) unsigned comment '邮费',
    weight       int unsigned comment '重量：单位克',
    voucher_id   int unsigned comment '购物券ID',
    create_time  timestamp               not null default now(),
    index idx_code (`code`),
    index idx_customer_id (customer_id),
    index idx_status (`status`),
    index idx_create_time (create_time),
    index idx_type (type),
    index idx_shop_id (shop_id),
    unique unq_code (`code`)
) comment = '订单表';

create table t_order_detail
(
    order_id     int unsigned            not null comment '订单ID',
    sku_id       int unsigned            not null comment '商品ID',
    price        decimal(10, 2) unsigned not null comment '原价格',
    actual_price decimal(10, 2) unsigned not null comment '实际购买价格',
    num          int unsigned            not null comment '购买数量',
    primary key (order_id, sku_id)
) comment '订单详情表'