import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import basicHttp from '../../api/basicHttp';

import styles from './Signup.module.css';

const Signup = () => {
    const [ssafyClass, setSsafyClass] = useState('');
    const [ssafyArea, setSsafyArea] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [passwordConfirm, setPasswordConfirm] = useState('');
    const handleSsafyClass = (e) => {
        setSsafyClass(e.target.value);
    };
    const handleSsafyArea = (e) => {
        setSsafyArea(e.target.value);
    };
    const handleEmail = (e) => {
        setEmail(e.target.value);
    };
    const handlePassword = (e) => {
        setPassword(e.target.value);
    };
    const handlePasswordConfirm = (e) => {
        setPasswordConfirm(e.target.value);
    };

    return (
        <div className={styles.signupBody}>
            <div className={styles.signupContainer}>
                <div className={styles.logoText}>S.F.O.API</div>
                <div className={styles.signupTitle}>회원가입</div>
                <div className={styles.signupBox}>
                    <label htmlFor="nickname" className={styles.signupText}>
                        싸피 지역
                    </label>
                    <input
                        type="text"
                        name="ssafyArea"
                        value={ssafyArea}
                        onChange={handleSsafyArea}
                        className={styles.signupInput}
                        placeholder="싸피지역을 입력해주세요"
                    />
                </div>
                <div className={styles.signupBox}>
                    <label htmlFor="ssafyClass" className={styles.signupText}>
                        싸피 반
                    </label>
                    <input
                        type="text"
                        name="ssafyClass"
                        value={ssafyClass}
                        onChange={handleSsafyClass}
                        className={styles.signupInput}
                        placeholder="싸피반을 입력해주세요"
                    />
                </div>
                <div className={styles.signupBox}>
                    <label htmlFor="email" className={styles.signupText}>
                        아이디(이메일)
                    </label>
                    <input
                        type="email"
                        name="email"
                        value={email}
                        onChange={handleEmail}
                        className={styles.signupInput}
                        placeholder="아이디(이메일)를 입력해주세요"
                    />
                </div>
                <div className={styles.signupBox}>
                    <label htmlFor="password" className={styles.signupText}>
                        비밀번호
                    </label>
                    <input
                        type="password"
                        name="password"
                        value={password}
                        onChange={handlePassword}
                        className={styles.signupInput}
                        placeholder="비밀번호를 입력해주세요"
                    />
                </div>
                <div className={styles.signupBox}>
                    <label htmlFor="passwordConfirm" className={styles.signupText}>
                        비밀번호 확인
                    </label>
                    <input
                        type="password"
                        name="passwordConfirm"
                        value={passwordConfirm}
                        onChange={handlePasswordConfirm}
                        className={styles.signupInput}
                        placeholder="비밀번호를 입력해주세요"
                    />
                </div>
                <button className={styles.signupBtn}>가입하기</button>
            </div>
        </div>
    );
};

export default Signup;
