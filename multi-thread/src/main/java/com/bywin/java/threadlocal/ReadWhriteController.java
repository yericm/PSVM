package com.bywin.java.threadlocal;

import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

/**
 * @author yeric
 * @date 2020/7/1 8:36 下午
 */
@RestController
public class ReadWhriteController {

    static HashSet<Val<Integer>> set = new HashSet();
//    private Integer num = 0;

    static ThreadLocal<Val<Integer>> threadLocal = new ThreadLocal<Val<Integer>>() {
        @Override
        protected Val<Integer> initialValue() {
            Val<Integer> val = new Val<>();
            val.setNum(0);
            add(val);
            return val;
        }
    };

    @RequestMapping("/read")
    public Integer readNum() {
//        return threadLocal.get();
        return set.stream().map(var -> var.getNum()).reduce(0,(a, b) -> a + b);
    }

    @RequestMapping("/add")
    public String addNum() {
        Val<Integer> integerVal = threadLocal.get();
        integerVal.setNum(integerVal.getNum()+1);
//        threadLocal.set(integerVal);
        return "成功";
    }

    synchronized static void add (Val<Integer> val) {
        set.add(val);
    }
}
