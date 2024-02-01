package com.org.springboot.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Collections;

@Document(collection="JobPost")
public class JobPost {
    private String desc;
    private int experience;
    private String profile;
    private String[] techs;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return experience;
    }

    public void setExp(int exp) {
        this.experience = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "desc='" + desc + '\'' +
                ", exp=" + experience +
                ", profile='" + profile + '\'' +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
