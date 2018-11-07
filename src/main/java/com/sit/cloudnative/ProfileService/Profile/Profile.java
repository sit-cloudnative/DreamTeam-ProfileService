package com.sit.cloudnative.ProfileService.Profile;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.sit.cloudnative.ProfileService.Favorite.Favorite;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

@Table(name = "profile")
@Entity
public class Profile extends SerializableSerializer{
    @UniqueElements
    @Id
    private String studentId;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "favorites_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Favorite> favoriteSubject;
    @NotNull
    private Date startStuiesAt;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }


    /**
     * @return the startStuiesAt
     */
    public Date getStartStuiesAt() {
        return startStuiesAt;
    }

    /**
     * @param startStuiesAt the startStuiesAt to set
     */
    public void setStartStuiesAt(Date startStuiesAt) {
        this.startStuiesAt = startStuiesAt;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @param name the name to set
     */
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

}