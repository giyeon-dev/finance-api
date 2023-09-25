import React, { useState } from 'react';
import styles from './Login.module.css';
import { Link } from 'react-router-dom';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const handleEmail = (e) => {
        
    }
    

    return (
        <div className={styles.loginBody}>
            <div className={styles.loginContainer}>
                <div className={styles.logoText}>S.F.O.API</div>
                <input className={styles.loginInput} type="text" placeholder="아이디" />
                <input className={styles.loginInput} type="password" placeholder="비밀번호" />
                <button className={styles.loginBtn}>로그인</button>
                <div className={styles.otherContainer}>
                    <a className={`${styles.rightBorder} ${styles.otherBtn}`} href="#">
                        <span>비밀번호 재설정</span>
                    </a>
                    <Link className={`${styles.alignRight} ${styles.otherBtn}`} to="/signup">
                        <span>회원가입</span>
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default Login;
