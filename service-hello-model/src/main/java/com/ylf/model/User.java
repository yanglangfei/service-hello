package com.ylf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author YangLF
 * @Date 2017/10/28
 */
@Data
public class User implements Serializable{
    private  int id;
    private  String name;
    private  int age;
    @JsonIgnore
    private  int isDel;
}
