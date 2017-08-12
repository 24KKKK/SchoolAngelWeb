create table table_order(
	foodnum int not null,    -- 菜品序号
	apartnum int not null,    -- 楼号
	dormitorynum int not null,			-- 宿舍号
	ordername varchar(10),		-- 提交人姓名
	date varchar(19)		-- 提交日期
)