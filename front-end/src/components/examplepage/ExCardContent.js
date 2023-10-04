import React, { useState, useEffect } from 'react';
import { useSearchParams, useLocation } from 'react-router-dom';
import styles from './ExCardContent.module.css';

import basicHttp from '../../api/basicHttp';
import tokenHttp from '../../api/tokenHttp';

const ExCardContent = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const code = searchParams.get('code');

    useEffect(() => {
        const getcardContent = async () => {
            try {
                const res = await basicHttp.get(`/oauth/access-token?code=${code}`);
                console.log(res.data);
                const res2 = await basicHttp.get(
                    `https://j9b309.p.ssafy.io/api/cards?orgCode=example
                    Orgcode&nextPage=2&limit=10`,
                    {
                        headers: {
                            Authorization: `Bearer ${res.data.access_token}`, // Bearer 토큰 포함
                        },
                    }
                );
                console.log(res2.data);
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
