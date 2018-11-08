package com.sit.cloudnative.ProfileService.Favorite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private long studentId;
    
    /**
     * @return the subjectId
     */
    public long getSubjectId() {
        return subjectId;
    }

    /**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public String toString(){
        return ""+this.subjectId+" "+this.subjectName+" "+this.id+" "+this.studentId;   
    }
}