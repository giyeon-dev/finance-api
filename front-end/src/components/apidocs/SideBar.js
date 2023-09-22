import React from "react";

import styles from "./SideBar.module.css";

import { Link, NavLink } from "react-router-dom";

const SideBar = () => {
  return (
    <div className={styles.sidebar}>
      <aside>
        <ul>
          <li>
            <NavLink
              to="/apidock/analyzedata"
              className={({ isActive }) => {
                return isActive ? styles.selected : styles.noSelected;
              }}
            >
              개인 소비 분석
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/apidock/exchange"
              className={({ isActive }) => {
                return isActive ? styles.selected : styles.noSelected;
              }}
            >
              환율 분석
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/apidock/stock"
              className={({ isActive }) => {
                return isActive ? styles.selected : styles.noSelected;
              }}
            >
              투자 자산
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/apidock/financialdata"
              className={({ isActive }) => {
                return isActive ? styles.selected : styles.noSelected;
              }}
            >
              금융 더미 데이터
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/apidock/smishing"
              className={({ isActive }) => {
                return isActive ? styles.selected : styles.noSelected;
              }}
            >
              문자 사기 방지
            </NavLink>
          </li>
        </ul>
      </aside>
    </div>
  );
};

export default SideBar;
