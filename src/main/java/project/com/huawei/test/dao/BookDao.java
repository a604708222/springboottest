package project.com.huawei.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import project.com.huawei.test.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> , JpaSpecificationExecutor<Book>{

}
