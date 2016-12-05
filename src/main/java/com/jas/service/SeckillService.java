package com.jas.service;

import java.util.List;

import com.jas.dto.Exposer;
import com.jas.dto.SeckillExecution;
import com.jas.expection.RepeatKillException;
import com.jas.expection.SeckillCloseException;
import com.jas.expection.SeckillExpection;
import com.jas.model.Seckill;

/**
 * 业务接口:站在：“使用者”的角度设计接口
 * 三个方面：方法的粒度，参数，返回类型（return 类型/异常)
 * Created by tianjun on 2016/8/4.
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
        throws SeckillExpection,RepeatKillException,SeckillCloseException;

}
