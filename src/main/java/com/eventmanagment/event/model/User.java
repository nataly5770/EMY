package com.eventmanagment.event.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable {

    public interface Role {
        String ADMIN = "ADMIN",
                USER = "USER";
    }

    @Id
    private String username;
    private String password;
    private String name;
    private String address;
    private String mobPhoneNumber;
    private boolean enabled;
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authorities> authorities;

}
