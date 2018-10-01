package com.example.springboothello;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * PackageName:com.example.springboothello
 * ClassName: HelloController
 *
 * @author zha.jiangjiang
 * @Description:
 * @Date: 2018/9/16 20:08
 * @see
 * @since JDK 1.8
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DiscoveryClient client;

    @RequestMapping("hello")
    public String index(String ids) throws InterruptedException {
        List<String> instance = client.getServices();
        for (String s:instance){
            List<ServiceInstance> list = client.getInstances(s);
            for(ServiceInstance si : list){
                logger.info("op=start_index, {}",si.getHost()+"|"+si.getPort()+"|"+si.getScheme()+"|"+si.getServiceId()+"|"+si.getUri() );
            }
            logger.info(client.getInstances(s).toString());
        }
//        让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(1000);
//        logger.info("sleepTime={} ",sleepTime );
//        Thread.sleep(sleepTime);
        logger.info(instance.toString());
        return sleepTime+"";
    }
    @RequestMapping("hello2")
    public List<String> index2(String ids) throws InterruptedException {
        logger.info("op=start_index2, ids={}", ids);
        List<String> instance = client.getServices();
        for (String s:instance){
            List<ServiceInstance> list = client.getInstances(s);
            for(ServiceInstance si : list){
                logger.info("op=start_index, {}",si.getHost()+"|"+si.getPort()+"|"+si.getScheme()+"|"+si.getServiceId()+"|"+si.getUri() );
            }
            logger.info(client.getInstances(s).toString());
        }
//        让处理线程等待几秒钟
        List<String > list = new ArrayList<>();
        String[] str = StringUtils.split(ids,",");
        for (int i = 0,j=str.length; i < j; i++) {
            int sleepTime = new Random().nextInt(1000);
            list.add(String.valueOf(sleepTime));
        }
        logger.info("op=start_index2, list={}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", list);
//        logger.info("sleepTime={} ",sleepTime );
//        Thread.sleep(sleepTime);
        logger.info(instance.toString());
        return list;
    }
}
