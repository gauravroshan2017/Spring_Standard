package com.gaurav.dao;

import java.util.List;

import com.gaurav.model.CartInfo;
import com.gaurav.model.OrderDetailInfo;
import com.gaurav.model.OrderInfo;
import com.gaurav.model.PaginationResult;


 
public interface OrderDAO {
	
 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
 
}