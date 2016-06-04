--�������ݿ�
CREATE DATABASE seckill;
--ʹ�����ݿ�
use seckill;
--������ɱ����
CREATE TABLE seckill(
	seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
	name varchar(120) NOT NULL COMMENT '��Ʒ����',
	number int NOT NULL COMMENT '�������',
	start_time datetime NOT NULL COMMENT '��ɱ��ʼʱ��',
	end_time datetime NOT NULL COMMENT '��ɱ����ʱ��',
	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	PRIMARY KEY (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 COMMENT='��ɱ����';

--��ʼ������
insert into 
	seckill(name,number,start_time,end_time)
values
	('1000Ԫ��ɱiPhone6',100,'2015-5-14 00:00:00','2015-5-15 00:00:00'),
	('500Ԫ��ɱiPhone5',200,'2015-5-14 00:00:00','2015-5-15 00:00:00'),
	('600Ԫ��ɱiPhone6s',300,'2015-5-14 00:00:00','2015-5-15 00:00:00'),
	('300Ԫ��ɱС��5',400,'2015-5-14 00:00:00','2015-5-15 00:00:00'),
	('100Ԫ��ɱipad2',500,'2015-5-14 00:00:00','2015-5-15 00:00:00');
	
--��ɱ�ɹ���ϸ��
--�û���¼��֤�����Ϣ
create table success_killed(
	seckill_id bigint NOT NULL COMMENT '��ɱ��Ʒid',
	user_phone bigint NOT NULL COMMENT '�û��ֻ���',
	state tinyint NOT NULL DEFAULT -1 COMMENT '״̬��ʾ��-1����Ч 0���ɹ� 1���Ѹ��� 2���ѷ���',
	create_time timestamp NOT NULL COMMENT '����ʱ��',
	PRIMARY KEY (seckill_id,user_phone),/*��������*/
	key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf-8 COMMENT='��ɱ�ɹ���ϸ��';

--�������ݿ����̨
mysql -uroot -proot

