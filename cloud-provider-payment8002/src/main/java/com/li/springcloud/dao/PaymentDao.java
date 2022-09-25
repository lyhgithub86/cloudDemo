package com.li.springcloud.dao;

import com.li.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



//1、使用@mapper后，不需要在spring配置中设置扫描地址，通过mapper .xml里面的namespace属性对应相关的mapper类, spring
//将动态的生成Bean后注入到Servicelmel中e n
//nki @repository则需要在Spring中配買扫描包地址，然后生成dao层的bean.之后被注入到Sevicelmel中
//Spring在扫描注解时，取消了扫描抽象类和接口，所以无法找到你用@reponsitory注解的dao接口。如果在idea中使用@Mapper注解，
//在@Autowired时，idea会 提示找不到bean,但是不影响运行。但是我看着又难受，百度一 堆规避的方法， 包括设置改为warning等，后来
//发现一个骚操作，可以把两个注解同时使用，这样，@Mapper 可以让你找到bean, @reponsitory可 以帮你治疗强迫症。
//Mapper只是用来扫描用的，当然你可以去掉，在springboot的启动类 上@MapperScan(basePackages = ["com.xx.xx"])来扫描
//@Mappler是mybatis注解，mybatis运行时 需要能找到到mapper文件，然后运行时构建代理类来完成功能，和Spring没有关系。 你应该
//用@MapperScan来扫描mapper接口，让mybatis能找倒这些接口。 然后Spring的@ComponetScan也要扫描这些接口，这样Spring才
//能管理这些mybatis生成的代理类。@Repository是 Spring的注解，而且注解放在接口上也没用也没有意义。

@Mapper
public interface PaymentDao {
    public int add(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
