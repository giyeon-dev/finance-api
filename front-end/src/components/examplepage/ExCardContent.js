import React, { useState, useEffect } from 'react';
import styles from './ExCardContent.module.css';
import China from '../../assets/img/China.PNG';
import JPN from '../../assets/img/JPN.PNG';
import US from '../../assets/img/US.PNG';
import EU from '../../assets/img/EU.PNG';

import basicHttp from '../../api/basicHttp';
import tokenHttp from '../../api/tokenHttp';

const ExCardContent = () => {
    const [exchangeAllList, setExchangeAllList] = useState([]);

    useEffect(() => {
        const getExchangeAll = async () => {
            try {
                const res = await basicHttp.get(`/api/exchange`);
                console.log(res.data.data.list);
                console.log(res.data.data.list[2].price);

                setExchangeAllList(res.data.data.list);
            } catch (error) {}
        };
        getExchangeAll();
    }, []);

    return (
        <div className={styles.chartContainer}>
            <div className={styles.chartCard}>
                <div className={styles.chartTitle}>
                    <h1>카드내역</h1>
                    <div>카드내역 뜰 칸</div>
                </div>
            </div>
        </div>
    );
};

export default ExCardContent;
