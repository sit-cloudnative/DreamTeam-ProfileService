package com.sit.cloudnative.ProfileService.Profile;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.sit.cloudnative.ProfileService.Favorite.Favorite;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "profiles")
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

    public String getFirstname() {
        return firstname;
    }
    public List<Favorite> getFavoriteSubject() {
        return favoriteSubject;
    }
    public Date getStartStuiesAt() {
        return startStuiesAt;
    }
    public String getLastname() {
        return lastname;
    }
    public long getStudentId() {
        return studentId;
    }

    public void setFavoriteSubject(List<Favorite> favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String toString(){
        return ""+this.firstname+" "+this.lastname+" "+this.studentId+" "+this.startStuiesAt;   
    }
}