import React from "react";
import oauthImage from "../../assets/img/oauth.PNG";
import styles from "./Oauth.module.css";

const OauthExplain = () => {
  return (
    <div className={styles.backBody}>
      <h1>OAuth 2.0</h1>
      <img src={oauthImage} alt="oauth" className={styles.imageContainer} />
      <div className={styles.text}>
        <h2>Step1: 인가 코드 받기</h2>
        <p>
          요청 <span>&nbsp;</span><strong>GET</strong> <span>&nbsp;</span>https://j9b309.p.ssafy.io/oauth/authorize
        </p>
      </div>

      <table className={styles.table}>
        <thead>
          <tr>
            <th>파라미터</th>
            <th>필수 여부</th>
            <th>설명</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>response_type</td>
            <td>Y</td>
            <td>code 고정</td>
          </tr>

          <tr>
            <td>client_id</td>
            <td>Y</td>
            <td>
              마이 페이지에 redirect_uri를 등록한 후 생성된 client_id를 넣어야
              한다.
            </td>
          </tr>
          <tr>
            <td>redirect_uri</td>
            <td>Y</td>
            <td>마이 페이지에 등록한 redirect_uri를 넣어야 한다.</td>
          </tr>
        </tbody>
      </table>
      <div className={styles.text2}>
      <h3>응답 예시</h3>
      </div>
      <pre id="json" className={styles.code}>
        HTTP/1.1 302 Found<br></br>
        Location: {"${REDIRECT_URI}?code=${authorize_code}"}
      </pre>
      <div className={styles.text}>
        <h2>Step2: 토큰 받기</h2>
        <p>
          요청 <span>&nbsp;</span> <strong>POST</strong> <span>&nbsp;</span>https://j9b309.p.ssafy.io/oauth/token
        </p>
      </div>

      <table className={styles.table}>
        <thead>
          <tr>
            <th>header</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Authorization</td>
            <td>필수</td>
            <td>Basic {"{client_id:client_secret를 Base64로 인코드한 값}"}</td>
          </tr>
        </tbody>
      </table>

      <table className={styles.table}>
        <thead>
          <tr>
            <th>파라미터</th>
            <th>필수 여부</th>
            <th>설명</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>grant_type</td>
            <td>Y</td>
            <td>authorization_code로 고정</td>
          </tr>
          <tr>
            <td>redirect_uri</td>
            <td>Y</td>
            <td>마이 페이지에 등록한 redirect_uri를 넣어야 한다.</td>
          </tr>
          <tr>
            <td>scope</td>
            <td>Y</td>
            <td>read 고정</td>
          </tr>
          <tr>
            <td>code</td>
            <td>Y</td>
            <td>이전에 받은 authorize_code 입력해야 한다.</td>
          </tr>
        </tbody>
      </table>
      <div className={styles.text2}>
      <h3>응답 예시</h3>
      </div>
      <pre id="json" className={styles.code}>
        {`
    HTTP/1.1 200 OK Content-Type: application/json;charset=UTF-8
    {
      token_type: "bearer",
      access_token: "Your Access Token",
    }
  `}
      </pre>
    </div>
  );
};

export default OauthExplain;
