package com.imooc.sell.repository;


import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "121213";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234568");
        orderMaster.setBuyerName("二师兄");
        orderMaster.setBuyerPhone("13223450218");
        orderMaster.setBuyerAddress("太古里");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(48.3));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);

        Assert.assertNotEquals(0, result.getTotalElements());
    }
}