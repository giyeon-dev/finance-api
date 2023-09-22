import React from "react";
import styles from "./APIContent.module.css";

const APIContent = () => {
  return (
    <div>
    
      <div className={styles.contentBody}>
        <h3>기본정보</h3>
        <p>기능</p>
        <p>메서드</p>
        <p>호출 경로</p>
        <p>호출 결과</p>
      </div>
    </div>
    
  );
};

export default APIContent;
