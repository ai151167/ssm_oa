package com.oa.demo.qsy.pojo;

public class BaseAreaRel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_area_rel.AREA_REL_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    private Long areaRelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_area_rel.AREA_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    private String areaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_area_rel.AREA_PARENT_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    private String areaParentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_area_rel.AREA_REL_ID
     *
     * @return the value of base_area_rel.AREA_REL_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    public Long getAreaRelId() {
        return areaRelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_area_rel.AREA_REL_ID
     *
     * @param areaRelId the value for base_area_rel.AREA_REL_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    public void setAreaRelId(Long areaRelId) {
        this.areaRelId = areaRelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_area_rel.AREA_ID
     *
     * @return the value of base_area_rel.AREA_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_area_rel.AREA_ID
     *
     * @param areaId the value for base_area_rel.AREA_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_area_rel.AREA_PARENT_ID
     *
     * @return the value of base_area_rel.AREA_PARENT_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    public String getAreaParentId() {
        return areaParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_area_rel.AREA_PARENT_ID
     *
     * @param areaParentId the value for base_area_rel.AREA_PARENT_ID
     *
     * @mbg.generated Tue Jan 16 14:22:36 CST 2018
     */
    public void setAreaParentId(String areaParentId) {
        this.areaParentId = areaParentId == null ? null : areaParentId.trim();
    }
}