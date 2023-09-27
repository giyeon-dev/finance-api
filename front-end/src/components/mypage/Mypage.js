// src/components/mypage/Mypage.js

import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './Mypage.module.css';

import basicHttp from '../../api/basicHttp';
import tokenHttp from '../../api/tokenHttp';

const Mypage = () => {
    const [apiToken, setApiToken] = useState('');
    const [redirectURI, setRedirectURI] = useState('');
    const handleapiToken = (e) => {
        setApiToken(e.target.value);
    };
    const handleRedirectURI = (e) => {
        setRedirectURI(e.target.value);
    };
	
    const onClickAddRedirectURI = async () => {
        try {
            const res = await tokenHttp.post(`/docs/client`, {
                web_server_redirect_uri: redirectURI,
            });
            console.log(res);
        } catch (error) {
            if (error.message === 'no token' || error.message === 'expire refresh-token') {
                navigate('/login'); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
            }
        }
    };

    const navigate = useNavigate();

    useEffect(() => {
        const getApiToken = async () => {
            try {
                const res = await tokenHttp.get(`/docs/service/token`);
                console.log(res);
                console.log('api토큰 발급 성공');

                localStorage.setItem('api-token', res.data.data);
                setApiToken(res.data.data);
            } catch (error) {
                if (error.message === 'no token' || error.message === 'expire refresh-token') {
                    navigate('/login'); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
                }
            }
        };
        getApiToken();
    }, []);
    // input value 수정되면 set해주는 함수

    async function onClickapiTokenRefreshBtn() {
        try {
            const res = await tokenHttp.post(`/docs/service/token`);
            console.log(res);
            console.log('api토큰 재발급 성공');

            localStorage.setItem('api-token', res.data.data);
            alert('api토큰 재발급 성공');
        } catch (error) {
            if (error.message === 'no token' || error.message === 'expire refresh-token') {
                navigate('/login'); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
            }
            console.error('api토큰 재발급  실패:', error);
            alert('api토큰 재발급  실패');
        }
    }

    return (
        <div className={styles.mypageBody}>
            <div className={styles.mypageContainer}>
                <div className={styles.logoText}>마이페이지</div>
                <input
                    className={styles.inputBox}
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
                    value={redirectURI}
                    onChange={handleRedirectURI}
                    type="text"
                    placeholder=""
                />
                <button className={styles.apiTokenRefreshBtn} onClick={onClickAddRedirectURI}>
                    RedirectURI 추가하기
                </button>
            </div>
        </div>
    );
};

export default Mypage;
