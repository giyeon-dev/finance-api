package com.ssafy.iNine.FinancialAPI.common.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 256)
    private String password;

    @Column(name = "class")
    private String userClass;

    @Column(name = "area", length = 30)
    private String area;

    @Column(name = "api_token", length = 256)
    private String apiToken;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    @Column(name = "is_deleted")
    @ColumnDefault("false")
    private Boolean isDeleted;
}
