package com.sit.cloudnative.ProfileService.Profile;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.sit.cloudnative.ProfileService.Favorite.Favorite;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

@Table(name = "profile")
@Entity
public class Profile extends SerializableSerializer{
    @Id
    private long studentId;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Favorite> favoriteSubject;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startStuiesAt;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }


    /**
     * @return the favoriteSubject
     */
    public List<Favorite> getFavoriteSubject() {
        return favoriteSubject;
    }

    /**
     * @param favoriteSubject the favoriteSubject to set
     */
    public void setFavoriteSubject(List<Favorite> favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
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
    public long getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * @param name the name to set
     */
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String toString(){
        return ""+this.firstname+" "+this.lastname+" "+this.studentId+" "+this.startStuiesAt;   
    }
}