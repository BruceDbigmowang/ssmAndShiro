package com.demo.pojo;

public class RoleAndFunctionKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_role_function.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_role_function.func_id
     *
     * @mbg.generated
     */
    private Integer funcId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_role_function.role_id
     *
     * @return the value of tb_role_function.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_role_function.role_id
     *
     * @param roleId the value for tb_role_function.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_role_function.func_id
     *
     * @return the value of tb_role_function.func_id
     *
     * @mbg.generated
     */
    public Integer getFuncId() {
        return funcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_role_function.func_id
     *
     * @param funcId the value for tb_role_function.func_id
     *
     * @mbg.generated
     */
    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }
}