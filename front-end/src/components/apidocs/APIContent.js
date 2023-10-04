import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styles from "./APIContent.module.css";
import basicHttp from "../../api/basicHttp";


const APIContent = () => {
  const { api_docs_id } = useParams();
  const [apiContent, setApiContent] = useState([]);
  const [apiData, setApiData] = useState([]);

  useEffect(() => {
    const getApiDocsData = async (api_docs_id) => {
      try {
        const response = await basicHttp.get(`/docs/api/${api_docs_id}`);
        const responseData = response.data;
        console.log("responseData", responseData.data);
        console.log("api_docs_id", api_docs_id);

        if (responseData.data) {
          setApiContent(responseData.data);
          setApiData(responseData.data.api_data);
          console.log(responseData.data.api_data);
        }
      } catch (error) {
        console.log("Error fetching API data", error);
      }
    };

    if (api_docs_id) {
      getApiDocsData(api_docs_id);
    } else {
      getApiDocsData("3");
    }
  }, [api_docs_id]);

  const isRequestTrueData = apiData.filter(
    (dataItem) => dataItem.is_request === true
  );
  const isRequestFalseData = apiData.filter(
    (dataItem) => dataItem.is_request === false
  );

  console.log(apiContent.return_example);

  return (
    <div>
      <div className={styles.contentBody}>
        <h3>{apiContent.title}</h3>

        <table className={styles.firstTable}>
          <thead>
            <tr>
              <th></th>
              <th>설명</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>기능</td>
              <td>{apiContent.content}</td>
            </tr>
            <tr>
              <td>메서드</td>
              <td>{apiContent.method}</td>
            </tr>
            <tr>
              <td>호출 경로</td>
              <td>{apiContent.endpoint}</td>
            </tr>
            <tr>
              <td>응답 예시</td>
              <td>{apiContent.return_type}</td>
            </tr>
          </tbody>
        </table>

        {/* <p>기능: {apiContent.content}</p>
        <p>메서드: {apiContent.method}</p>
        <p>호출 경로: {apiContent.endpoint}</p>
        <p>호출 결과: {apiContent.return_type}</p> */}
        <p>응답 예시</p>
        <pre id="json" className={styles.code}>{apiContent.return_example}</pre>

        <h4>요청 메세지 명세</h4>
        <table className={styles.apiDataTable}>
          <thead>
            <tr>
              <th>항목명</th>
              <th> 필수 </th>
              <th>타입</th>
              <th>설명</th>
            </tr>
          </thead>
          <tbody>
            {isRequestTrueData.map((dataItem, index) => (
              <tr key={index}>
                <td>{dataItem.title}</td>
                <td>{dataItem.is_essential ? " Y " : " N "}</td>
                <td>{dataItem.type}</td>
                <td>{dataItem.detail}</td>
              </tr>
            ))}
          </tbody>
        </table>

        <h4>응답 메세지 명세</h4>
        <table className={styles.apiDataTable}>
          <thead>
            <tr>
              <th>항목명</th>
              <th>필수</th>
              <th>타입</th>
              <th>설명</th>
            </tr>
          </thead>
          <tbody>
            {isRequestFalseData.map((dataItem, index) => (
              <tr key={index}>
                <td>{dataItem.title}</td>
                <td>{dataItem.is_essential ? " Y " : " N "}</td>
                <td>{dataItem.type}</td>
                <td>{dataItem.detail}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default APIContent;
