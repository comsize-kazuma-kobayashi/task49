// 上から順にユーザマスタ、カテゴリマスタ、ステータスマスタ、テスクテーブル

INSERT INTO m_user (user_id,password,user_name) VALUES ('kobayashi','kazuma','小林一馬');
INSERT INTO m_user (user_id,password,user_name) VALUES ('furukawa','masami','古川真己');
INSERT INTO m_user (user_id,password,user_name) VALUES ('yukizane','kanako','行實香菜子');
INSERT INTO m_user (user_id,password,user_name) VALUES ('aoki','yukie','青木雪絵');
INSERT INTO m_user (user_id,password,user_name) VALUES ('emura','maika','江村舞花');
INSERT INTO m_category(category_name) VALUES ('新商品A：開発プロジェクト');
INSERT INTO m_category(category_name) VALUES ('既存商品B：改良プロジェクト');
INSERT INTO m_status(status_code,status_name) VALUES ('00','未着手');
INSERT INTO m_status(status_code,status_name) VALUES ('50','着手');
INSERT INTO m_status(status_code,status_name) VALUES ('99','完了');
INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo) VALUES ('テスト１','1','21000101','kobayashi','00','テスト１メモ');
INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo) VALUES ('テスト２','1','21000101','furukawa','50','テスト２メモ');
INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo) VALUES ('テスト３','2','21000101','yukizane','50','テスト３メモ');
INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo) VALUES ('テスト４','2','21000101','aoki','99','テスト４メモ');
INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo) VALUES ('テスト５','2','21000101','emura','99','テスト５メモ');