package com.fdmgroup.flexdronewarehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseUser {
	@Id
	@GeneratedValue
	private long id;
	
    @Column( unique = true, length = 45, nullable = false)
    private String username;

    @Column( nullable = false)
    private String password;

    @Column( unique = true, length = 45, nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING) 
    private Role role;
    
    

}
