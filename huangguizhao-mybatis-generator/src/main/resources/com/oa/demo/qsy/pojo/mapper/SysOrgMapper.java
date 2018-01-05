package com.oa.demo.qsy.pojo.mapper;

import com.oa.demo.qsy.pojo.SysOrg;
import com.oa.demo.qsy.pojo.SysOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    long countByExample(SysOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int deleteByExample(SysOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int deleteByPrimaryKey(Long orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int insert(SysOrg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int insertSelective(SysOrg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    List<SysOrg> selectByExample(SysOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    SysOrg selectByPrimaryKey(Long orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int updateByExample(@Param("record") SysOrg record, @Param("example") SysOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int updateByPrimaryKeySelective(SysOrg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_org
     *
     * @mbg.generated Fri Jan 05 09:39:27 CST 2018
     */
    int updateByPrimaryKey(SysOrg record);
}