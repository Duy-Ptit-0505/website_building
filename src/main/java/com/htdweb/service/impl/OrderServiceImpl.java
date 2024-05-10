package com.htdweb.service.impl;

import com.htdweb.converter.OrderDTOtoEntity;
import com.htdweb.converter.OrderEntitytoDTO;
import com.htdweb.entity.OrderEntity;
import com.htdweb.model.dto.OrderDTO;
import com.htdweb.repository.CustomerRepository;
import com.htdweb.repository.OrderRepository;
import com.htdweb.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDTOtoEntity orderDTOtoEntity;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderEntitytoDTO orderEntitytoDTO;
    @Override
    public void saveOrder(OrderDTO orderDTO) throws ParseException {

        orderRepository.save(orderDTOtoEntity.toOrderEntity(orderDTO));
    }

    @Override
    public List<OrderDTO> getOrderListByUserName(String name) {
        List<OrderEntity> orderEntityList = customerRepository.findOneByUserName(name).getOrderEntityList();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderEntity x : orderEntityList){
            orderDTOList.add(orderEntitytoDTO.toOrderDTO(x));
        }
        return orderDTOList;
    }

}
