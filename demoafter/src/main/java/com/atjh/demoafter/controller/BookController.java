package com.atjh.demoafter.controller;

import cn.hutool.core.util.StrUtil;
import com.atjh.demoafter.common.Result;
import com.atjh.demoafter.entity.Book;
import com.atjh.demoafter.entity.User;
import com.atjh.demoafter.mapper.BookMapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;


@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookMapper bookMapper;




    /**
     * 新增
     * @param book
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody Book book){

        bookMapper.insert(book);
        return Result.success();
    }

    /**
     * 更新
     * @param book
     * @return
     */
    @PutMapping
    public Result<?> update(@RequestBody Book book){
        bookMapper.updateById(book);
        return Result.success();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable long id){
        bookMapper.deleteById(id);
        return Result.success();
    }

    /**
     * 查询
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Book> wrapper = Wrappers.<Book>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Book::getName,search);
        }
        Page<Book> bookPage = bookMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(bookPage);
    }
}
