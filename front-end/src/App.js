import './App.css';
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";

// 메인페이지
import Home from "./components/main/Home";
// 회원가입
import Signup from './components/signup/Signup';
// 로그인
import Login from './components/login/Login';
// 마이페이지
import Mypage from './components/mypage/Mypage'
// 서비스 소개
import ServiceInfo from './components/serviceinfo/ServiceInfo';
import APIDocs from './components/apidocs/APIDocs';
// API문서

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<Signup />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/mypage" element={<Mypage />}></Route>
        <Route path="/serviceinfo" element={<ServiceInfo />}></Route>
        <Route path="/apidock" element={<APIDocs />}></Route>
      </Routes>
    </div>
  );
}

export default App;
