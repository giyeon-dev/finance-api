// src/components/mypage/Mypage.js

import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import styles from "./Mypage.module.css";

import basicHttp from "../../api/basicHttp";
import tokenHttp from "../../api/tokenHttp";

const Mypage = () => {
	const [apiToken, setApiToken] = useState("");
	const [redirectURI, setRedirectURI] = useState("");
	const [clientList, setClientList] = useState([]);
	const handleapiToken = (e) => {
		setApiToken(e.target.value);
	};
	const handleRedirectURI = (e) => {
		setRedirectURI(e.target.value);
	};

	const getClientList = async () => {
		try {
			const res = await tokenHttp.get(`/docs/service/client`);
			console.log(res);
			setClientList(res.data.data);
		} catch (error) {
			if (error.message === "no token" || error.message === "expire token") {
				navigate("/login"); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
			}
		}
	};
	const onClickAddRedirectURI = async () => {
		if (!redirectURI) {
			// 내용이 없을 경우 처리
			return;
		}
		try {
			const res = await tokenHttp.post(`/docs/service/client`, {
				web_server_redirect_uri: redirectURI,
			});
			console.log(res.data.data);
			setClientList((clientList) => [
				...clientList,
				{
					web_server_redirectUri: res.data.data.webServerRedirectUri,
					client_id: res.data.data.clientId,
					secret_id: res.data.data.secretId,
				},
			]);
			// window.location.reload(); // 페이지 새로고침
		} catch (error) {
			if (error.message === "no token" || error.message === "expire token") {
				navigate("/login"); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
			}
		}
	};

	const navigate = useNavigate();

	useEffect(() => {
		const getApiToken = async () => {
			try {
				const res = await tokenHttp.get(`/docs/service/token`);
				console.log(res);
				console.log("api토큰 발급 성공");

				localStorage.setItem("api-token", res.data.data);
				setApiToken(res.data.data);
			} catch (error) {
				if (error.message === "no token" || error.message === "expire token") {
					navigate("/login"); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
				}
			}
		};
		getApiToken();
		getClientList();
	}, []);
	// input value 수정되면 set해주는 함수

	async function onClickapiTokenRefreshBtn() {
		try {
			const res = await tokenHttp.post(`/docs/service/token`);
			console.log(res);
			console.log("api토큰 재발급 성공");

			localStorage.setItem("api-token", res.data.data);
			setApiToken(res.data.data);
			alert("api토큰 재발급 성공");
		} catch (error) {
			if (error.message === "no token" || error.message === "expire token") {
				navigate("/login"); // 토큰없음이나 토큰만료 에러발생시 로그인화면으로 이동
			}
			console.error("api토큰 재발급  실패:", error);
			alert("api토큰 재발급  실패");
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
				{/*redirectURI 목록*/}
				{clientList.map((client) => (
					<div key={client.client_id} className={styles.client}>
						<label className={styles.clientText}>RedirectURI</label>
						<div>{client.web_server_redirect_uri}</div>
						<label className={styles.clientText}>client-id</label>
						<div>{client.client_id}</div>
						<label className={styles.clientText}>secret-id</label>
						<div>{client.secret_id}</div>
					</div>
				))}
			</div>
		</div>
	);
};

export default Mypage;
