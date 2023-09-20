package com.ssafy.iNine.Document.common.entity.oauth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "oauth_approvals")
public class OAuthApproval {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "client_id")
    private String clientId;
    private String scope;
    private String status;

    @Column(name = "expires_at")
    private Timestamp expiresAt;
    @Column(name = "lastModified_at")
    private Timestamp lastModifiedAt;
}
