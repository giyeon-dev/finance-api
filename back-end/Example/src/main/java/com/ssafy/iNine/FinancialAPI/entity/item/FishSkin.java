package com.ssafy.iNine.FinancialAPI.entity.item;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FishSkin {

    @Id
    private Long code;
    private String imagePath;

}
