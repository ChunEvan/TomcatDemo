package cn.itcast.web.servlet;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();

        SaleComputer computer = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), (proxy, method, args1) -> {
            System.out.println("invoke");
            System.out.println(method.getName());
            System.out.println(args1[0]);
            Object o = method.invoke(lenovo, args1);
            return o;
        });

        String sale = computer.sale(10);
        System.out.println(sale);
    }
}
