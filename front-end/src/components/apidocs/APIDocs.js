import React, { useState } from "react";
import styles from "./APIDocs.module.css";

import basicHttp from "../../api/basicHttp";
import SideBar from "./SideBar";
import APIContent from "./APIContent";

const APIDocs = () => {
  return (
    <div className={styles.backBody}>
      <div className={styles.boardContainer}>
        <div className={styles.boardTop}>
          <h3>오픈 API를 이용해 창의적인 애플리케이션을 제작해보세요</h3>
        </div>

        <div className={styles.boardContent}>
          <SideBar />
          <APIContent />
        </div>
      </div>
    </div>
  );
};

export default APIDocs;
