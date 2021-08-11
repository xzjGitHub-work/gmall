package com.xzj.gmall.gmallorder.dao;

import com.xzj.gmall.gmallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 16:25:33
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
