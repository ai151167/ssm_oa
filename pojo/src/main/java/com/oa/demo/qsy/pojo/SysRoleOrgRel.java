package com.oa.demo.qsy.pojo;

import java.util.Date;

public class SysRoleOrgRel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_org_rel.ROLE_ORG_REL_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    private Long roleOrgRelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_org_rel.ROLE_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_org_rel.ORG_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    private Long orgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_org_rel.CREATED_DATE
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    private Date createdDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_org_rel.ROLE_ORG_REL_ID
     *
     * @return the value of sys_role_org_rel.ROLE_ORG_REL_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public Long getRoleOrgRelId() {
        return roleOrgRelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_org_rel.ROLE_ORG_REL_ID
     *
     * @param roleOrgRelId the value for sys_role_org_rel.ROLE_ORG_REL_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public void setRoleOrgRelId(Long roleOrgRelId) {
        this.roleOrgRelId = roleOrgRelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_org_rel.ROLE_ID
     *
     * @return the value of sys_role_org_rel.ROLE_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_org_rel.ROLE_ID
     *
     * @param roleId the value for sys_role_org_rel.ROLE_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_org_rel.ORG_ID
     *
     * @return the value of sys_role_org_rel.ORG_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_org_rel.ORG_ID
     *
     * @param orgId the value for sys_role_org_rel.ORG_ID
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_org_rel.CREATED_DATE
     *
     * @return the value of sys_role_org_rel.CREATED_DATE
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_org_rel.CREATED_DATE
     *
     * @param createdDate the value for sys_role_org_rel.CREATED_DATE
     *
     * @mbg.generated Thu Jan 18 16:35:51 CST 2018
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}