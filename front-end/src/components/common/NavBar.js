import React from 'react';

import styles from "./NavBar.module.css";

import { Link } from "react-router-dom";    

const NavBar = () => {
    return (
        <div className={styles.mainNav}>
            <div className={styles.navLeft}>
                <Link className={styles.navMenu} to = "/">Home</Link>
                <Link className={styles.navMenu} to = "/serviceinfo">서비스 소개</Link>
                <Link className={styles.navMenu} to = "/apidock">API문서</Link>  
            </div>

            <div className={styles.navRight}>
                <Link className={styles.navMenu} to = "/login">로그인</Link>
                <Link className={styles.navMenu}  to = "/signup">회원가입</Link>
             </div>       
        </div>
    );
};

export default NavBar;