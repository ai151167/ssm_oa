package com.oa.demo.qsy.pojo.mapper;

import com.oa.demo.qsy.pojo.SysRoleOrgRel;
import com.oa.demo.qsy.pojo.SysRoleOrgRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleOrgRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    long countByExample(SysRoleOrgRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int deleteByExample(SysRoleOrgRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int deleteByPrimaryKey(Long roleOrgRelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int insert(SysRoleOrgRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int insertSelective(SysRoleOrgRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    List<SysRoleOrgRel> selectByExample(SysRoleOrgRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    SysRoleOrgRel selectByPrimaryKey(Long roleOrgRelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysRoleOrgRel record, @Param("example") SysRoleOrgRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int updateByExample(@Param("record") SysRoleOrgRel record, @Param("example") SysRoleOrgRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int updateByPrimaryKeySelective(SysRoleOrgRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_org_rel
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    int updateByPrimaryKey(SysRoleOrgRel record);
}