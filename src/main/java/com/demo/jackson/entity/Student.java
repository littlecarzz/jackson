package com.demo.jackson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 1.如果json字符串中的属性个数小于java对象中的属性个数，可以顺利转换，java中多的那个属性为null
 * 2.如果json字符串中出现java对象中没有的属性，则在将json转换为java对象时会报错,
 * Unrecognized field, not marked as ignorable，加上这个注解可解决
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String name;
    private Integer age;
    /**
     * 忽略属性
     */
    @JsonIgnore
    private String profileImageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 当Json的属性值和Java的属性值不一样时，会映射失败，用这个注解指定映射关系，
     * 在属性上用这个注解，则序列化和反序列化都会用这个值。
     * 如果序列化和反序列化的属性不一致，可以在get方法或者set方法上用这个注解，set方法影响反序列化，get方法影响序列化。
     *
     */
    @JsonProperty("getImage")
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
    @JsonProperty("setImage")
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
