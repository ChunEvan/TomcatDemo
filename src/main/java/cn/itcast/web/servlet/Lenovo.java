package cn.itcast.web.servlet;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("sale");
        return "sale "+money;
    }
}
