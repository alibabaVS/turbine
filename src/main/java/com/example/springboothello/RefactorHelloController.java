package com.example.springboothello;

import com.example.helloserviceapi.HelloService;
import com.example.helloserviceapi.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * PackageName:com.example.springboothello
 * ClassName: RefactorHelloController
 *
 * @author zha.jiangjiang
 * @Description:
 * @Date: 2018/9/27 23:05
 * @see
 * @since JDK 1.8
 */
@RestController
public class RefactorHelloController implements HelloService {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String hello() {
//        logger.info("op=start_hello, >>>>>>>>>>>>>>>>>>>>>>>" );
        return "hello String";
    }

    @Override
    public User hello(String name, Integer age) {
        User user = new User(name,age);
        return user;
    }
}
