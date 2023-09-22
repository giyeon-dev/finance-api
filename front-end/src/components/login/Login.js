import React from 'react';
import styles from './Login.module.css';
const Login = () => {
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
                    <a className={`${styles.alignRight} ${styles.otherBtn}`} href="#">
                        <span>회원가입</span>
                    </a>
                </div>
            </div>
        </div>
    );
};

export default Login;
