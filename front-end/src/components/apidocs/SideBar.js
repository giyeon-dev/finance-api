import React, { useEffect, useState } from "react";
import styles from "./SideBar.module.css";
import { NavLink } from "react-router-dom";
import basicHttp from "../../api/basicHttp";

const SideBar = () => {
  const [tabsData, setTabsData] = useState([]);


  useEffect(() => {
    const getApiDocsList = async () => {
      try {
        const response = await basicHttp.get("/docs/api");
        const responseData = response.data;
        console.log("responseData", responseData);

        if (responseData.data) {
          const groupedTabs = [
            {
              title: "금융 더미 데이터",
              url: "/apidock/3",
              subTabs: responseData.data.slice(0, 2),
              
            },
            {
              title: "환율 정보",
              url: "/apidock/5",
              subTabs: responseData.data.slice(2, 10),
            },
            {
              title: "투자 자산 분석",
              url: "/apidock/13",
              subTabs: responseData.data.slice(10, 16),
            },
            {
              title: "소비 내역 분석",
              url: "/apidock/19",
              subTabs: responseData.data.slice(16, 17),
            },
          ];
          setTabsData(groupedTabs);
        }
      } catch (error) {
        console.log("Error fetching API data", error);
      }
    };

    

    getApiDocsList();
  }, []);

  return (
    <div className={styles.sidebar}>
      <aside>
        <ul>
          {tabsData.map((group) => (
            <li key={group.title}>
              <h3>
                <NavLink to={group.url}>{group.title}</NavLink>
              </h3>
              <ul>
                {group.subTabs.map((tab) => (
                  <li key={tab.api_docs_id}>
                    <NavLink
                      to={`/apidock/${tab.api_docs_id}`}
                      className={({ isActive }) => {
                        return isActive ? styles.selected : styles.noSelected;
                      }}
                    >
                      {tab.title}
                    </NavLink>
                  </li>
                ))}
              </ul>
            </li>
          ))}
        </ul>
      </aside>
    </div>

    
  );
};

export default SideBar;
