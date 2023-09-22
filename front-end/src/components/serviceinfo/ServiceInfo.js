import React, {useState} from 'react';
import styles from "./ServiceInfo.module.css";

import basicHttp from "../../api/basicHttp";

const ServiceInfo = () => {
    
    const [serviceList, setServiceList] = useState([]);

    const getAllServiceData = async () => {
        try {
            const response = await basicHttp.get("/service");
            const responseData = response.data;

            if (responseData.serviceList) {
                setServiceList(responseData.serviceList);
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
                    <div className= {styles.card}>
                        <div className={styles.cardTop}>
                            <h4>API 서비스 1</h4>
                        </div>
                        <div className={styles.cardBody}>
                            <p>API 서비스 1에 대한 설명</p>
                        </div>
                    </div>
                    </div>
            </div>    
        
           
        </div>
    );
};

export default ServiceInfo;