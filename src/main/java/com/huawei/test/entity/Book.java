package com.huawei.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Table(name="t_book")
@Accessors(chain=true)
@ToString
public class Book{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String author;
    @Getter
    @Setter
    private Date createTime;
    @Getter
    @Setter
    private Date updateTime;

}
