package com.xzj.gmall.gmallmember.dao;

import com.xzj.gmall.gmallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author xuzhaoju
 * @email xuzhaoju@gmail.com
 * @date 2021-08-11 16:13:31
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
