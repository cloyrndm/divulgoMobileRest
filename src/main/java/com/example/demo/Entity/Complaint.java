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


    private Long user_id;

    @NotBlank
    private String user_complaint;

    @NotBlank
    private String user_location;

    @Lob
    private Blob content;



    public Long getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(Long complaint_id) {
        this.complaint_id = complaint_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }
}
