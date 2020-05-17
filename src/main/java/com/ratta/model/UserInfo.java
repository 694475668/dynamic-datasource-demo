package com.ratta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘明
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer id;

    private String userName;

    private Integer userAge;

    private String address;

    private Date addTime;

    private String remarks;
    
}