package com.main.akvelon.homework2;

import com.main.akvelon.homework2.model.entity.Driver;
import com.main.akvelon.homework2.model.entity.Order;
import com.main.akvelon.homework2.model.entity.Passenger;
import com.main.akvelon.homework2.service.DriverService;
import com.main.akvelon.homework2.service.OrderService;
import com.main.akvelon.homework2.service.PassengerService;
import com.main.akvelon.homework2.service.impl.DriverServiceImpl;
import com.main.akvelon.homework2.service.impl.OrderServiceImpl;
import com.main.akvelon.homework2.service.impl.PassengerServiceImpl;

import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        DriverService driverService = new DriverServiceImpl();
        OrderService orderService = new OrderServiceImpl(driverService);
        PassengerService passengerService = new PassengerServiceImpl();
        initData(driverService, orderService, passengerService);


//        print all orders
        List<Order> allOrders = orderService.findAll();
        System.out.println(allOrders);

//        set driver
        Order order = allOrders.stream().findAny().orElseThrow();
        orderService.setDriverToOrder(order, driverService.findFreeDriver());

//        get order
        System.out.println("Driver pick up client:" + orderService.getById(order.getId()));

//        cancel order
        orderService.cancelOrder(orderService.getById(order.getId()));
        System.out.println("Order canceled:" + orderService.getById(order.getId()));

//      set new driver
        Order order2 = orderService.findAll().stream().findAny().orElseThrow();
        orderService.setDriverToOrder(order2, driverService.findFreeDriver());

        System.out.println("Driver pick up 2 client:" + orderService.getById(order2.getId()));

//        end order
        orderService.endOrder(order2);
        System.out.println("Order canceled:" + orderService.getById(order2.getId()));


        System.out.println("Final list of orders:" + orderService.findAll());
        System.out.println("Final list of passengers:" + passengerService.findAll());
        System.out.println("Final list of drivers:" + driverService.findAll());
    }


    private static void initData(DriverService driverService, OrderService orderService, PassengerService passengerService) {
        driverService.save(new Driver(UUID.randomUUID(), "Driver1"));
        driverService.save(new Driver(UUID.randomUUID(), "Driver2"));
        driverService.save(new Driver(UUID.randomUUID(), "Driver3"));
        driverService.save(new Driver(UUID.randomUUID(), "Driver4"));

        passengerService.save(new Passenger(UUID.randomUUID(), "Passenger1"));
        passengerService.save(new Passenger(UUID.randomUUID(), "Passenger2"));
        passengerService.save(new Passenger(UUID.randomUUID(), "Passenger3"));
        passengerService.save(new Passenger(UUID.randomUUID(), "Passenger4"));

        orderService.createOrder("SomeWhere1", passengerService.findAnyPassenger());
        orderService.createOrder("SomeWhere2", passengerService.findAnyPassenger());
        orderService.createOrder("SomeWhere3", passengerService.findAnyPassenger());
    }
}

