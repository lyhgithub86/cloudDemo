package com.li.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 仿写轮询算法
 *
 * @author lixs
 * @version 1.0
 * @date 2022/9/17 8:31
 */
// 交给容器管理      还有一个@server (创建业务层对象)是对 @Component 的细化，当不确定这个类什么时候和作甚的时候可用
@Component
public class MyLB implements Loadbalancer {

    //原子整形类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**@Description:  判断第几次访问， 就是  1 % 2 = ？ 对应的 1
     * @param
     * @return next 就是1
     * @version v1.0
     * @author lixs
     * @date 2022/9/17 8:45
     */
    private final int getAndIncrement() {
        int current;
        int next;
        do {

            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current+1;
        } while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("第几次访问，次数next:" + next);
        return next;
    }


    /**@Description:  根据取余运算返回的是需要调用那个接口
     * @param
     * @return
     * @version v1.0
     * @author lixs
     * @date 2022/9/17 9:02
     */

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
