package com.ssafy.iNine.FinancialAPI.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ReportStateType {
    REGISTERD("신고 접수"), PROCESSING("신고 검토"), PROCESSED("처리 완료");

    private String name;
}
