package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Cloie Andrea on 15/07/2018.
 */

@Entity
@Table(name="complaint")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},allowGetters=true)
public class Complaint implements Serializable {

    @Id
    @GeneratedValue
    private Long complaint_id;

@Column(name="user_id")
    private Long userId;

    private String user_complaint;

    private String user_location;

    private String file_path;


    public Long getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(Long complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getUser_complaint() {
        return user_complaint;
    }

    public void setUser_complaint(String user_complaint) {
        this.user_complaint = user_complaint;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
