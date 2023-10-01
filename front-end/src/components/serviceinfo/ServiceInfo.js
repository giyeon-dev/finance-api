import React, { useEffect, useState } from "react";
import styles from "./ServiceInfo.module.css";

import basicHttp from "../../api/basicHttp";

const ServiceInfo = () => {
  const [title, setTitle] = useState([]);
  const [content, setContent] = useState([]);

  useEffect(() => {
    getAllServiceData();
  }, []);

  const getAllServiceData = async () => {
    try {
      const response = await basicHttp.get("/docs/api");
      const responseData = response.data;
      console.log("responseData", responseData.data);

      if (responseData.data) {
        setTitle(responseData.data.map((item) => item.title));
        setContent(responseData.data.map((item) => item.content));
      }
    } catch (error) {
      console.log("Error fetching service data", error);
    }
  };

  return (
    <div className={styles.backBody}>
      <div className={styles.boardContainer}>
        <div className={styles.boardTop}>
          <h3>제공하는 API 서비스를 소개합니다</h3>
        </div>
        <div className={styles.cardList}>
          {title.map((item, index) => (
            <div className={styles.card} key={index}>
              <h5>{item}</h5>

              <div>
                <p>{content[index]}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default ServiceInfo;
