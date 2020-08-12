package edu.miu.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "GroupsToo")
public class Group {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    String group_name;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//    List<Authority> authority = new ArrayList<Authority>();
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    List<UserCredentials> userCredentials = new ArrayList<UserCredentials>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }


}
