package org.phstudy.sample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Petri Kainulainen
 */
@Entity
@Table(name = "user_accounts")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 100,nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "password", length = 255)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;

    public User() {

    }

   

      
    public Long getId() {
		return id;
	}

	public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("creationTime", this.getCreationTime())
                .append("email", email)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("modificationTime", this.getModificationTime())
                .append("signInProvider", this.getSignInProvider())
                .append("version", this.getVersion())
                .toString();
    }

	private String getVersion() {
		return "v1";
	}

	private Date getModificationTime() {
		return new Date();
	}

	private Date getCreationTime() {
		return new Date();
	}
}
