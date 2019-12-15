package com.eventmanagment.event.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable {

    @Id
    private String username;
    private String password;
    private String displayedName;
    private String address;
    private String mobPhoneNumber;
    private String emailAddress;
    private boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authorities> authorities;

}
