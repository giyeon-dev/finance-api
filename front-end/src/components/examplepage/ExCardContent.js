import React, { useLocation, useState, useEffect } from 'react';
import styles from './ExCardContent.module.css';

import basicHttp from '../../api/basicHttp';
import tokenHttp from '../../api/tokenHttp';

const ExCardContent = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const code = queryParams.get('code');

    // code를 useState로 저장
    const [codeState, setCodeState] = useState(code);

    useEffect(() => {
        const getcardContent = async () => {
            try {
                const res = await basicHttp.get(`/api/exchange`);
                console.log(res.data.data.list);
                console.log(res.data.data.list[2].price);
            } catch (error) {}
        };
        getcardContent();
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
