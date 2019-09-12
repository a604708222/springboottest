package project.com.huawei.test.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.com.huawei.test.dao.BookDao;
import project.com.huawei.test.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {
    
    @Resource
    private BookDao bookDao;

    
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 查找所有图书
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        List<Book> bookList = bookDao.findAll();
        mav.addObject("bookList", bookList);
        mav.setViewName("bookList");
        return mav;
    }
    
    /**
     * 添加图书
     */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(Book book){
        bookDao.save(book);
        return "redirect:/book/list";
    }
    
    /**
     * 根据id查找图书
     */
    @RequestMapping("/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", bookDao.getOne(id));
        mav.setViewName("bookUpdate");
        return mav;
    }
    
    /**
     * 修改图书
     */
    @PostMapping("/update")
    public String update(Book book){
        bookDao.save(book); //依然是save，有id就修改，没有id就添加
        return "redirect:/book/list";
    }
    
    /**
     * 修改图书
     */
    @RequestMapping("/bookAdd")
    public ModelAndView bookAdd(Book book){
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("bookAdd");
        return mav;
    }
    
    /**
     * 删除图书
     */
    @GetMapping("/delete")
    public String delete(Integer id){
        bookDao.delete(id);
        return "redirect:/book/list";
    }
    /**
     * 删除图书
     */
    @GetMapping("/testquery")
    public String testquery(){
    	test10();
    	return "redirect:/book/list";
    }
    
    private void test1(){
    	Pageable page = new PageRequest(0, 2);
    	Page<Book> p = bookDao.findAll(page);
    	List<Book> list = p.getContent();
    	list.forEach(System.out::println);
    	System.out.println("总条数为："+p.getTotalElements());
    	System.out.println("总页数为："+p.getTotalPages());
    }
    private void test2(){
    	Sort sort = new Sort(Direction.DESC,"id");
    	List<Book> list = bookDao.findAll(sort);
    	list.forEach(System.out::println);
    }
    
    private void test3(){
    	Order order1 = new Order(Direction.DESC,"id");
    	Order order2 = new Order(Direction.ASC,"author");
    	Sort sort = new Sort(order1,order2);
    	List<Book> list = bookDao.findAll(sort);
    	list.forEach(System.out::println);
    }
    
    private void test4(){
    	
    	List<Book> list = bookDao.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
    		return cb.equal(root.get("author"), "zuozhe3");
    	} );
    	list.forEach(System.out::println);
    }
    private void test5(){
    	
    	List<Book> list = bookDao.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
    		List<Predicate> listp = new ArrayList<>();
    		listp.add(cb.like(root.get("author"), "%zuozhe%"));
    		listp.add(cb.like(root.get("name"), "%shu%"));
    		
    		return cb.and(listp.toArray(new Predicate[listp.size()]));
    	} );
    	list.forEach(System.out::println);
    }
    private void test6(){
    	
    	List<Book> list = bookDao.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
    		List<Predicate> listp = new ArrayList<>();
    		listp.add(cb.like(root.get("author"), "%zuozhe%"));
    		listp.add(cb.like(root.get("name"), "%shu%"));
    		
    		return cb.and(cb.like(root.get("author"), "%zuozhe%"),cb.like(root.get("name"), "%shu%"));
    	} );
    	list.forEach(System.out::println);
    }
    private void test7(){
    	
    	Page<Book> list = bookDao.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
    		List<Predicate> listp = new ArrayList<>();
    		listp.add(cb.like(root.get("author"), "%zuozhe%"));
    		listp.add(cb.like(root.get("name"), "%shu%"));
    		
    		return cb.and(cb.like(root.get("author"), "%zuozhe%"),cb.like(root.get("name"), "%shu%"));
    	},new PageRequest(0, 2) );
    	list.getContent().forEach(System.out::println);
    	System.out.println(list.getTotalElements());
    	System.out.println(list.getTotalPages());
    }
    private void test8(){
    	
    	List<Book> list = bookDao.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
    		List<Predicate> listp = new ArrayList<>();
    		listp.add(cb.like(root.get("author"), "%zuozhe%"));
    		listp.add(cb.like(root.get("name"), "%shu%"));
    		return cb.and(cb.like(root.get("author"), "%zuozhe%"),cb.like(root.get("name"), "%shu%"));
    	},new Sort(new Order(Direction.DESC,"id"),new Order(Direction.ASC,"author")));
    	list.forEach(System.out::println);
    }
    private void test9(){
    	
    	Page<Book> list = bookDao.findAll((Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
    		List<Predicate> listp = new ArrayList<>();
    		listp.add(cb.like(root.get("author"), "%zuozhe%"));
    		listp.add(cb.like(root.get("name"), "%shu%"));
    		return cb.and(cb.like(root.get("author"), "%zuozhe%"),cb.like(root.get("name"), "%shu%"));
    	},new PageRequest(0, 2,new Sort(new Order(Direction.DESC,"id"),new Order(Direction.ASC,"author"))));
    	list.getContent().forEach(System.out::println);
    }
    private void test10(){
    	
    	Integer count = jdbcTemplate.queryForObject("select count(*) from t_book t where t.name like ?", Integer.class, new Object[]{"%shu%"});
    	System.out.println(count);
    	Book book = jdbcTemplate.queryForObject("select * from t_book t where t.name like ?", (ResultSet r, int i) -> {
    		return new Book().setName(r.getString("name")).setAuthor(r.getString("author")).setId(r.getInt("id"));
    	}, new Object[]{"%shu4"});
    	System.out.println(book);
    	
    	List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_book t where t.name like ?", new Object[]{"%shu%"});
    	list.forEach(System.out::println);
    	List<Book> list1 = jdbcTemplate.query("select * from t_book t where t.name like ?",(ResultSet r, int i) -> {
    		return new Book().setName(r.getString("name")).setAuthor(r.getString("author")).setId(r.getInt("id"));
    	}, new Object[]{"%shu%"});
    	System.out.println(list1);
    	
    	Map<String, Object> m = jdbcTemplate.queryForMap("select * from t_book t where t.name like ?", new Object[]{"%shu3%"});
    	System.out.println(m);
    }
    
    
}