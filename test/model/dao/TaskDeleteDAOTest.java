package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.TaskDeleteBean;

class TaskDeleteDAOTest {
	
	TaskDeleteBean TaskDeleteBean = new TaskDeleteBean();
	TaskDeleteDAO TaskDeleteDAO = new TaskDeleteDAO();
	Date date = Date.valueOf("2024-07-26");

	@Test
	void test_selectTask() {
		try {
			TaskDeleteBean = TaskDeleteDAO.selectTask(40);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			fail("データベース操作エラー");
		}
		assertEquals(40, TaskDeleteBean.getTaskId());
		assertEquals("テスト6", TaskDeleteBean.getTaskName());
		assertEquals("新商品A：開発プロジェクト", TaskDeleteBean.getCategoryName());
		assertEquals(date, TaskDeleteBean.getLimitDate());
		assertEquals("emura", TaskDeleteBean.getUserId());
		assertEquals("江村舞花", TaskDeleteBean.getUserName());
		assertEquals("未着手", TaskDeleteBean.getStatusName());
		assertEquals("", TaskDeleteBean.getMemo());
		
	}
	
	@Test
	void test_deleteTask() {
		int count = 0;
		try {
			count = TaskDeleteDAO.deleteTask(35);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			fail("データベース操作エラー");
		}
		assertEquals(1, count);
	}


}
