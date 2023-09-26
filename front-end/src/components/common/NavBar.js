import React from "react";

import styles from "./NavBar.module.css";

import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { logout } from "../../redux/userInfo";

const NavBar = () => {
	const dispatch = useDispatch();
	const userInfo = useSelector((state) => {
		return state;
	});
	const onClickLogout = () => {
		localStorage.removeItem("access-token");
		localStorage.removeItem("refresh-token");
		dispatch(logout());
	};
	return (
		<div className={styles.mainNav}>
			<div className={styles.navLeft}>
				<Link className={styles.navMenu} to="/">
					Home
				</Link>
				<Link className={styles.navMenu} to="/serviceinfo">
					서비스 소개
				</Link>
				<Link className={styles.navMenu} to="/apidock">
					API문서
				</Link>
			</div>
			{/* 로그인 상태에 따라 Login 또는 Mypage로 링크 변경 */}
			{userInfo ? (
				<div className={styles.navRight}>
					<Link className={styles.navMenu} to="/mypage">
						마이페이지
					</Link>
					<a className={styles.navMenu} onClick={onClickLogout}>
						로그아웃
					</a>
				</div>
			) : (
				<div className={styles.navRight}>
					<Link className={styles.navMenu} to="/login">
						로그인
					</Link>
					<Link className={styles.navMenu} to="/signup">
						회원가입
					</Link>
				</div>
			)}
		</div>
	);
};

export default NavBar;
