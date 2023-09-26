import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './Mypage.module.css';

import basicHttp from '../../api/basicHttp';
import tokenHttp from '../../api/tokenHttp';

const Mypage = () => {
    // useState, useEffect
    const [apiToken, setApiToken] = useState('');
    const [redirectURL, setRedirectURL] = useState('');
    useEffect(() => {
        const getApiToken = async () => {
            const res = await tokenHttp.get(`/docs/service/token`);
            console.log(res);
        };

        getApiToken();
    }, []);
    // input value 수정되면 set해주는 함수
    const handleapiToken = (e) => {
        setApiToken(e.target.value);
    };
    const handleRedirectURL = (e) => {
        setRedirectURL(e.target.value);
    };

    const navigate = useNavigate();

    async function onClickapiTokenRefreshBtn() {
        try {
            const res = await tokenHttp.post(`/docs/service/token`);
            console.log(res);
            console.log('api토큰 재발급 성공');

            localStorage.setItem('refresh-token', res.data.data['refresh-token']);
            alert('api토큰 재발급 성공');
        } catch (error) {
            console.error('api토큰 재발급  실패:', error);
            alert('api토큰 재발급  실패');
        }
    }

    return (
        <div className={styles.mypageBody}>
            <div className={styles.mypageContainer}>
                <div className={styles.logoText}>마이페이지</div>
                <input
                    className={styles.apiTokenInput}
                    value={apiToken}
                    onChange={handleapiToken}
                    type="text"
                    placeholder="apiToken"
                    disabled
                />
                <button className={styles.apiTokenRefreshBtn} onClick={onClickapiTokenRefreshBtn}>
                    토큰 재발급
                </button>
                <input
                    className={styles.inputBox}
                    value={redirectURL}
                    onChange={handleRedirectURL}
                    type="text"
                    placeholder=""
                />
            </div>
        </div>
    );
};

export default Mypage;
