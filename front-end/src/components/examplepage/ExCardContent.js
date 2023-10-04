import React, { useState, useEffect } from 'react';
import { useSearchParams, useLocation } from 'react-router-dom';
import styles from './ExCardContent.module.css';
import KB1 from '../../assets/img/KB1.PNG';
import KB2 from '../../assets/img/KB2.PNG';
import KB3 from '../../assets/img/KB3.PNG';
import HD1 from '../../assets/img/HD1.PNG';

import basicHttp from '../../api/basicHttp';
import tokenHttp from '../../api/tokenHttp';

const ExCardContent = () => {
    const [searchParams, setSearchParams] = useSearchParams();
    const code = searchParams.get('code');

    const [cardList, setCardList] = useState([]);

    useEffect(() => {
        const getcardContent = async () => {
            try {
                const res = await basicHttp.get(`/oauth/access-token?code=${code}`);
                console.log(res.data);
                const res2 = await basicHttp.get(
                    `https://j9b309.p.ssafy.io/api/cards?orgCode=exampleOrgcode&nextPage=2&limit=10`,
                    {
                        headers: {
                            Authorization: `Bearer ${res.data.access_token}`, // Bearer 토큰 포함
                        },
                    }
                );
                console.log(res2.data);
                setCardList(res2.data.data.cardList);
            } catch (error) {}
        };
        getcardContent();
    }, []);

    // exchangeAllList 배열의 길이가 3보다 크거나 같을 때만 해당 값을 사용
    const exchangeData = cardList.length ? cardList[2] : null;

    return (
        <div className={styles.chartContainer}>
            <div className={styles.chartCard}>
                <div className={styles.chartTitle}>
                    <h1>카드 내역</h1>
                </div>

                <div className={`${styles.chartBox} ${styles.chatBox1}`}>
                    <div className={`${styles.chartNumber} ${styles.chartNumber1}`}>
                        <img src={KB1} alt="03" />
                    </div>
                    <div className={`${styles.chartCover} ${styles.chartCover1}`}></div>
                    {/* <!-- Name --> */}
                    <div className={`${styles.chartName} ${styles.chartName1}`}>
                        <span> {cardList[0].cardName}</span>
                        {/* exchangeData가 null이 아닐 때만 해당 값을 출력 */}
                        {/* {exchangeData && <div className={styles.price}>{exchangeAllList[2].price}</div>} */}
                        <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>카드 번호</div>
                            {exchangeData && <div className={styles.priceContent}>{cardList[0].cardNum}</div>}
                        </div>
                        <div className={styles.separator}></div>
                        {/* <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>현찰 팔 때</div>
                            {exchangeData && (
                                <div className={styles.priceContent}>{exchangeAllList[2].cashSellPrice}</div>
                            )}
                        </div> */}
                    </div>
                    {/* <!-- Button --> */}
                    {/* <div className={styles.link}>
                        <a href="https://www.youtube.com/watch?v=wnJ6LuUFpMo">Listen</a>
                    </div> */}
                </div>

                {/* <!-- Separator --> */}
                <div className={styles.separator}></div>

                <div className={`${styles.chartBox} ${styles.chatBox1}`}>
                    <div className={`${styles.chartNumber} ${styles.chartNumber1}`}>
                        <img src={KB2} alt="03" />
                    </div>
                    <div className={`${styles.chartCover} ${styles.chartCover1}`}></div>
                    {/* <!-- Name --> */}
                    <div className={`${styles.chartName} ${styles.chartName1}`}>
                        <span> {cardList[1].cardName}</span>
                        {/* exchangeData가 null이 아닐 때만 해당 값을 출력 */}
                        {/* {exchangeData && <div className={styles.price}>{exchangeAllList[3].price}</div>} */}
                        <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>카드 번호</div>
                            {exchangeData && <div className={styles.priceContent}>{cardList[1].cardNum}</div>}
                        </div>
                        <div className={styles.separator}></div>
                        {/* <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>현찰 팔 때</div>
                            {exchangeData && (
                                <div className={styles.priceContent}>{exchangeAllList[3].cashSellPrice}</div>
                            )}
                        </div> */}
                    </div>
                    {/* <!-- Button --> */}
                    {/* <div className={styles.link}>
                        <a href="https://www.youtube.com/watch?v=wnJ6LuUFpMo">Listen</a>
                    </div> */}
                </div>

                {/* <!-- Separator --> */}
                <div className={styles.separator}></div>

                <div className={`${styles.chartBox} ${styles.chatBox1}`}>
                    <div className={`${styles.chartNumber} ${styles.chartNumber1}`}>
                        <img src={KB3} alt="03" />
                    </div>
                    <div className={`${styles.chartCover} ${styles.chartCover1}`}></div>
                    {/* <!-- Name --> */}
                    <div className={`${styles.chartName} ${styles.chartName1}`}>
                        <span> {cardList[2].cardName}</span>
                        {/* exchangeData가 null이 아닐 때만 해당 값을 출력 */}
                        {/* {exchangeData && <div className={styles.price}>{exchangeAllList[0].price}</div>} */}
                        <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>카드 번호</div>
                            {exchangeData && <div className={styles.priceContent}>{cardList[2].cardNum}</div>}
                        </div>
                        <div className={styles.separator}></div>
                        {/* <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>현찰 팔 때</div>
                            {exchangeData && (
                                <div className={styles.priceContent}>{exchangeAllList[0].cashSellPrice}</div>
                            )}
                        </div> */}
                    </div>
                    {/* <!-- Button --> */}
                    {/* <div className={styles.link}>
                        <a href="https://www.youtube.com/watch?v=wnJ6LuUFpMo">Listen</a>
                    </div> */}
                </div>

                {/* <!-- Separator --> */}
                <div className={styles.separator}></div>

                <div className={`${styles.chartBox} ${styles.chatBox2}`}>
                    {/* <!-- #02 --> */}
                    {/* <!-- Number--> */}
                    <div className={`${styles.chartNumber} ${styles.chartNumber2}`}>
                        <img src={HD1} alt="03" />
                    </div>
                    {/* <!-- Cover --> */}
                    <div className={`${styles.chartCover} ${styles.chartCover2}`}></div>
                    {/* <!-- Name --> */}
                    <div className={`${styles.chartName} ${styles.chartName2}`}>
                        <span> {cardList[3].cardName}</span>
                        {/* exchangeData가 null이 아닐 때만 해당 값을 출력 */}
                        {/* {exchangeData && <div className={styles.price}>{exchangeAllList[1].price}</div>} */}
                        <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>카드 번호</div>
                            {exchangeData && <div className={styles.priceContent}>{cardList[3].cardNum}</div>}
                        </div>
                        <div className={styles.separator}></div>
                        {/* <div className={styles.priceContainer}>
                            <div className={styles.priceTitle}>현찰 팔 때</div>
                            {exchangeData && (
                                <div className={styles.priceContent}>{exchangeAllList[1].cashSellPrice}</div>
                            )}
                        </div> */}
                    </div>
                    {/* <!-- Button --> */}
                    {/* <div className={styles.link}>
                        <a href="https://www.youtube.com/watch?v=wnJ6LuUFpMo">Listen</a>
                    </div> */}
                </div>
            </div>
        </div>
    );
};

export default ExCardContent;
