package service;

import java.util.List;

import dao.StudentDao;
import domain.Student;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	public List<Student> list() {
		return studentDao.list();
	}
}
