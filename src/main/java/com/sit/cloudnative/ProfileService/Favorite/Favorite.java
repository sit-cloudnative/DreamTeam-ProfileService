package com.sit.cloudnative.ProfileService.Favorite;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

@Entity
@Table(name="favorites")
public class Favorite extends SerializableSerializer{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long subjectId;

    @NotBlank
    private String subjectName;

    @NotNull
    private Long studentId;

    public long getSubjectId() {
        return subjectId;
    }
	public Long getStudentId() {
		return studentId;
	}
    public String getSubjectName() {
        return subjectName;
    }
    public long getId(){
        return this.id;
    }

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }
    public void setId(long id){
        this.id = id;
    }

    public String toString(){
        return ""+this.subjectId+" "+this.subjectName+" "+this.id+" "+this.studentId;   
    }
}