package com.huawei.test.dao;

import com.huawei.test.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface BookDao extends JpaRepository<Book, Integer> , JpaSpecificationExecutor<Book>{

}
