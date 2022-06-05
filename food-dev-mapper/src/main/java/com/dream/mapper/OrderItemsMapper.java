package com.dream.mapper;

import com.dream.my.mapper.MyMapper;
import com.dream.pojo.OrderItems;

public interface OrderItemsMapper extends MyMapper<OrderItems> {


    public void insertOrderItem(OrderItems orderItems);

}