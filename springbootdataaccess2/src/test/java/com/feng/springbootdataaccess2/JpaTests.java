package com.feng.springbootdataaccess2;

import com.feng.springbootdataaccess2.domain.Discuss;
import com.feng.springbootdataaccess2.repository.DiscussRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
/**
 * JpaTests：用于编写Jpa相关的单元测试
 */
@SpringBootTest
public class JpaTests {
    @Autowired
    private DiscussRepository repository;
    //1. 使用JpaRepository内部方法进行操作
    // findById(1)=>接口文件自己提供的查询方法，可以直接使用
    @Test
    public void selectComment() {
        Optional<Discuss> optional = repository.findById(1);
        if (optional.isPresent()) {//查回来内容不为空
            System.out.println("内部方法findById(1)查询\n" + optional.get());//输出查出的内容
        }
        System.out.println();
    }
    //2. 使用方法名关键字findByAuthorNotNull()进行数据操作
    @Test
    public void selectCommentByKeys() {
        List<Discuss> list = repository.findByAuthorNotNull();
        System.out.println("方法名关键字查询：作者非空时的评论\n" + list);
    }
    //3. 使用@Query注解进行操作=>根据文章id查询评论，并根据指定分页来显示查询结果
    @Test
    public void selectCommentPaged() {
        /*
            pageable封装了分页的参数，当前页page(开始页是0)，和每页最多显示的条数3
            - aid=1时，查询的结果有4条，每页最多显示3条，所以共有2页(0页[3条]和1页[1条])
            - 这里我设置了当前页为1，表示我想要得到第1页的内容
            - 结果会出现第1页的一条内容
         */
        Pageable pageable = PageRequest.of(1, 3);
        List<Discuss> currentPagedComment = repository.getDiscussPaged(1, pageable);
        System.out.println("@Query注解查询：aid=1时第一页的评论\n" + currentPagedComment);
    }
}