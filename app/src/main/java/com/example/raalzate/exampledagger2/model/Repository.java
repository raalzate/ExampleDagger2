package com.example.raalzate.exampledagger2.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by raul-alzate on 3/06/16.
 */
@Table(name = "Repository")
public class Repository extends Model {

    @Column(name = "Name")
    String name;

    @Column(name = "FullName")
    String fullName;

    @Column(name = "Description")
    String description;

    // Make sure to have a default constructor for every ActiveAndroid model
    public Repository(){
        super();
    }

    public Repository(String name, String fullName, String description){
        super();
        this.fullName = fullName;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }


    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }



}
