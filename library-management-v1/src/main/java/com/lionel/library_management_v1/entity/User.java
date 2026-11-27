package com.lionel.library_management_v1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.Instant;

// 1. DEFINE ENTITY
@Entity
@Table(name = "users")
public class User {
    // 2. DEFINE ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "User ID cannot be Empty")
    private Integer id;

    @Column(name = "user_name")
    @NotBlank(message = "Enter valid User Name")
    @Size(min = 3,max = 40,message = "User name must be between 3 to 40 characters")
    private String userName;

    @Column(name = "password")
    @NotBlank(message = "Enter valid Password")
    @Size(min = 12, max = 60, message = "Password must be between 12 to 60 characters")
    private String password;

    @Column(name = "email")
    @NotBlank(message = "Enter Valid Email")
    @Size(min = 6, max = 60, message = "Email must be between 6 to 60 characters")
    @Email(message = "Enter Valid Email")
    private String email;

    @Column(name = "wallet_amount")
    @NotNull(message = "Enter Valid Amount")
    @Min(value = 0, message = "Enter valid Amount")
    private int amount;

    @Column(name = "enabled")
    @NotNull(message = "Enter valid status")
    private boolean enabled;

    @Column(name = "created_at")
    @NotNull(message = "Enter valid created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    @NotNull(message = "Enter valid updated_at")
    private Instant updatedAt;

//    @Column(name = "created_by")
    @NotNull(message = "Enter valid created_by")
//    private Integer createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

//    @Column(name = "updated_by")
    @NotNull(message = "Enter valid updated_by")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    // 3. DEFINE CONSTRUCTORS
    public User() {
    }

    public User(Integer id, String userName, String password, String email, int amount, boolean enabled, Instant createdAt, Instant updatedAt, User createdBy, User updatedBy) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.amount = amount;
        this.enabled = enabled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    // 4. DEFINE GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    // 5. DEFINE toString()

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                ", enabled=" + enabled +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
//                ", createdBy=" + createdBy +
//                ", updatedBy=" + updatedBy +
                '}';
    }
}
