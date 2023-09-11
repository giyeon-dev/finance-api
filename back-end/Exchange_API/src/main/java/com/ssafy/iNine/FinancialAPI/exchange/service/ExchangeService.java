package com.ssafy.iNine.FinancialAPI.exchange.service;

import com.ssafy.iNine.FinancialAPI.exchange.dto.Bank;
import com.ssafy.iNine.FinancialAPI.exchange.dto.ExchangeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeService {
    private static HttpURLConnection connection;
    private static BigDecimal defaultExchangeRate = BigDecimal.valueOf(1300);

    public List<List<ExchangeDto>> getExchangeList() throws IOException {
        List<List<ExchangeDto>> exchangeList = getMyBank();
        return exchangeList;
    }

    private List<List<ExchangeDto>> getMyBank() throws IOException {
        List<List<ExchangeDto>> exchangeList = new ArrayList<>();
//        List<String> codes = Arrays.asList("005", "020", "004", "088", "011", "003", "023");
        List<Bank> banks = Arrays.asList(Bank.values());

        for(int b=0; b<banks.size(); b++) {
            List<ExchangeDto> bankList = new ArrayList<>();
            String URL = "https://www.mibank.me/exchange/bank/index.php?search_code="+ banks.get(b).getCode();
            Document doc = Jsoup.connect(URL).get();
            Elements countryList = doc.select("tbody tr");
    //        System.out.println(countryList);
            for(int i=0; i<countryList.size(); i++) {
                Elements country = countryList.get(i).select("td");
                ExchangeDto exchangeDto = new ExchangeDto();
                exchangeDto.setBank(banks.get(b).getName());
    //            System.out.println(country.get(1).text());
                exchangeDto.setCountry(country.get(1).text());
                if(country.get(2).text().equals("-")) continue;
    //            System.out.println(country.get(2).text());
                exchangeDto.setCashBuyPrice(new BigDecimal(country.get(2).text()));
    //            System.out.println(country.get(3).text());
                exchangeDto.setCashBuyRate(new BigDecimal(country.get(3).text().split("%")[0]));
    //            System.out.println(country.get(4).text());
                exchangeDto.setCashSellPrice(new BigDecimal(country.get(4).text()));
    //            System.out.println(country.get(5).text());
                exchangeDto.setCashSellRate(new BigDecimal(country.get(5).text().split("%")[0]));
                if(!country.get(6).text().equals("-")) {
    //                System.out.println(country.get(6).text());
                    exchangeDto.setTransferPrice(new BigDecimal(country.get(6).text()));
    //                System.out.println(country.get(7).text());
                    exchangeDto.setTransferRate(new BigDecimal(country.get(7).text().split("%")[0]));
                }
    //            System.out.println(country.get(8).text());
                exchangeDto.setPrice(new BigDecimal(country.get(8).text()));
                bankList.add(exchangeDto);
            }
            exchangeList.add(bankList);
        }
        return exchangeList;
    }


    // 한국수출입은행
    public List<ExchangeDto> getExchangeRateList() {
        List<ExchangeDto> result = new ArrayList<>();
        List<String> countryList = new ArrayList<>();

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        JSONParser parser = new JSONParser();

        String authKey = "MyXmV2tF2pkD4jVzw4gUDrSS7HVIPPhY";
        String searchDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String dataType = "AP01";
        BigDecimal exchangeRate = null;

        try {
            // Request URL
            URL url = new URL("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=" + authKey + "&searchdate=" + searchDate + "&data=" + dataType);
            connection = (HttpURLConnection) url.openConnection();

            // Request 초기 세팅
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            // API 호출
            // 실패했을 경우 Connection Close
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else { // 성공했을 경우 환율 정보 추출
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    JSONArray exchangeRateInfoList = (JSONArray) parser.parse(line);
//                    System.out.println(exchangeRateInfoList);
                    for (Object o : exchangeRateInfoList) {
                        JSONObject exchangeRateInfo = (JSONObject) o;
                        ExchangeDto exchangeDto = new ExchangeDto();
                        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
//                        exchangeDto.setRate(new BigDecimal(format.parse(exchangeRateInfo.get("deal_bas_r").toString()).doubleValue()));
//                        exchangeDto.setName(exchangeRateInfo.get("cur_nm").toString());
//                        exchangeDto.setUnit(exchangeRateInfo.get("cur_unit").toString());
//                        exchangeDto.setTts(new BigDecimal(format.parse(exchangeRateInfo.get("tts").toString()).doubleValue()));
//                        exchangeDto.setTtb(new BigDecimal(format.parse(exchangeRateInfo.get("ttb").toString()).doubleValue()));
//                        result.add(exchangeDto);
//                        countryList.add(exchangeDto.getName());
                    }
                }
                reader.close();
            }
            System.out.println(responseContent.toString());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
//        } catch (java.text.ParseException e) {
//            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }

        if (exchangeRate == null) {
            exchangeRate = defaultExchangeRate;
        }

        System.out.println(countryList);
        return result;
    }


}
