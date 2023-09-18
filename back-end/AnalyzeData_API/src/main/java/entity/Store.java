package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(length = 12, name = "merchant_regno")
    private String merchantRegno;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "induty_L_name")
    private String lName;

    @Column(name = "induty_S_name")
    private String sName;

    private String local;

    @Column(name = "store_cnt")
    private Long storeCnt;


}
