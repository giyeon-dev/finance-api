package com.ssafy.iNine.Document.domain.serviceprovider.repository;

import com.ssafy.iNine.Document.common.entity.oauth.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, String> {
}
