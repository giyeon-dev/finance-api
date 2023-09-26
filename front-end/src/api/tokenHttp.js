//src/api/tokenHttp.js
import axios from 'axios';
import jwt_decode from 'jwt-decode';
import dayjs from 'dayjs';
import { useNavigate } from 'react-router-dom';

// 토큰이 필요한 인증에 사용

// const baseURL = process.env.REACT_APP_SERVER_URL;
const baseURL = 'https://j9b309.p.ssafy.io';

const tokenHttp = axios.create({
    baseURL,
    header: {
        'Content-Type': 'application/json',
    },
});

// 요청 인터셉터 설정 (요청 보내기 전에 수행되는 함수)
tokenHttp.interceptors.request.use(async (req) => {
    const accessToken = localStorage.getItem('access-token');
    if (!accessToken) {
        console.log('token 이 존재하지 않습니다.');
        throw new Error('expire token');
    }

    const user = jwt_decode(accessToken);
    const isExpired = dayjs().diff(dayjs.unix(user.exp)) < 1;

    // access token 이 만료되지 않았다면 access-token 을 넣어 요청 실행
    if (isExpired) {
        req.headers['Authorization'] = `Bearer ${accessToken}`;
        return req;
    }

    // 만료되었다면 강제 로그아웃
    console.log('api/tokenHttp.js : access token 만료');
    localStorage.removeItem('access-token');
    localStorage.removeItem('refresh-token');

    // 여기에서 로그인 페이지로 리디렉션을 수행할 수 있습니다.
    // 예를 들어, React Router의 navigate 또는 history.push 등을 사용하여 로그인 페이지로 이동할 수 있습니다.
    // 예시: history.push('/login');
    const navigate = useNavigate();
    navigate('/login');

    // 만료된 토큰으로 인한 오류를 던집니다.
    throw new Error('expire refresh-token');
});

export default tokenHttp;
