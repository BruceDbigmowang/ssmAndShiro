package com.demo.mapper;

import com.demo.pojo.Functions;
import com.demo.pojo.FunctionsExample;
import java.util.List;

public interface FunctionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer funcId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    int insert(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    int insertSelective(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    List<Functions> selectByExample(FunctionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    Functions selectByPrimaryKey(Integer funcId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Functions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_functions
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Functions record);
}