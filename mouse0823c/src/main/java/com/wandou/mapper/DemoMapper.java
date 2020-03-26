package com.wandou.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wandou.model.po.AccountPO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author liming
 * @date 2020-03-26
 * @description
 */
public class DemoMapper implements BaseMapper<AccountPO> {
    /**
     * <p>
     * 插入一条记录
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public int insert(AccountPO entity) {
        return 0;
    }

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    /**
     * <p>
     * 根据 columnMap 条件，删除记录
     * </p>
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    /**
     * <p>
     * 根据 entity 条件，删除记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public int delete(Wrapper<AccountPO> queryWrapper) {
        return 0;
    }

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    /**
     * <p>
     * 根据 ID 修改
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public int updateById(AccountPO entity) {
        return 0;
    }

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象 (set 条件值,不能为 null)
     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    @Override
    public int update(AccountPO entity, Wrapper<AccountPO> updateWrapper) {
        return 0;
    }

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     */
    @Override
    public AccountPO selectById(Serializable id) {
        return null;
    }

    /**
     * <p>
     * 查询（根据ID 批量查询）
     * </p>
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    @Override
    public List<AccountPO> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    /**
     * <p>
     * 查询（根据 columnMap 条件）
     * </p>
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public List<AccountPO> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    /**
     * <p>
     * 根据 entity 条件，查询一条记录
     * </p>
     *
     * @param queryWrapper 实体对象
     */
    @Override
    public AccountPO selectOne(Wrapper<AccountPO> queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryWrapper 实体对象
     */
    @Override
    public Integer selectCount(Wrapper<AccountPO> queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public List<AccountPO> selectList(Wrapper<AccountPO> queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<AccountPO> queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * 注意： 只返回第一个字段的值
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public List<Object> selectObjs(Wrapper<AccountPO> queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public IPage<AccountPO> selectPage(IPage<AccountPO> page, Wrapper<AccountPO> queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param page         分页查询条件
     * @param queryWrapper 实体对象封装操作类
     */
    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<AccountPO> page, Wrapper<AccountPO> queryWrapper) {
        return null;
    }
}
