package com.huawei.test.service;

import java.util.ArrayList;
import java.util.List;

import com.huawei.test.dao.BookDao;
import com.huawei.test.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public Book findOne(int id){
		return bookDao.findOne(id);
	}

	public List<Book> list() {
		Iterable<Book> list = bookDao.findAll();
		List<Book> result = new ArrayList<Book>();
		list.forEach(result::add);
		return result;
	}
}
