package com.ssafy.iNine.FinancialAPI.entity.point;

import com.ssafy.tingbackend.entity.common.BaseCreatedTimeEntity;
import com.ssafy.tingbackend.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"user", "pointCategory", "changeCost", "resultPoint"})
public class PointHistory extends BaseCreatedTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_code")
    private PointCategory pointCategory;

    private Long changeCost;
    private Long resultPoint;
}
