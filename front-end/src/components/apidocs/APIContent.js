import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styles from "./APIContent.module.css";
import basicHttp from "../../api/basicHttp";

const APIContent = () => {
  
  const { api_docs_id } = useParams();
  const [apiContent, setApiContent] = useState([]);

  useEffect(() => {
    const getApiDocsData = async (api_docs_id) => {
      try {
        const response = await basicHttp.get(`/docs/api/${api_docs_id}`);
        const responseData = response.data;
        console.log("responseData", responseData.data);
        console.log("api_docs_id", api_docs_id);
  
        if (responseData.data) {
          setApiContent(responseData.data);
        }
      } catch (error) {
        console.log("Error fetching API data", error);
      }
    };
  
    if(api_docs_id) {
      getApiDocsData(api_docs_id);
    } else {
      getApiDocsData("3");
    };
  
    
  }, [api_docs_id]); 

  
  return (
    <div>
      <div className={styles.contentBody}>
        <h3>{apiContent.title}</h3>
      
        <p>기능: {apiContent.content}</p>
        <p>메서드: {apiContent.method}</p>
        <p>호출 경로: {apiContent.content_type}</p>
        <p>호출 결과: {apiContent.return_type}</p>
      </div>
    </div>
  );
};

export default APIContent;
