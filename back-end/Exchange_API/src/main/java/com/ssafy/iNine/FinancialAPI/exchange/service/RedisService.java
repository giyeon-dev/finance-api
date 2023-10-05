package com.ssafy.iNine.FinancialAPI.exchange.service;

import com.ssafy.iNine.FinancialAPI.entity.Exchange;
import com.ssafy.iNine.FinancialAPI.exchange.dto.Bank;
import com.ssafy.iNine.FinancialAPI.exchange.dto.BankDto;
import com.ssafy.iNine.FinancialAPI.exchange.dto.ExchangeDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
//@Service
//@RequiredArgsConstructor
public class RedisService {
//    private final ExchangeRedisRepository exchangeRedisRepository;
//
//    public void saveExchange(List<ExchangeRedis> exchangeList) {
//        // 모두 지우기 추가
//        exchangeRedisRepository.deleteAll();
//        for(ExchangeRedis exchangeRedis: exchangeList) {
//            exchangeRedisRepository.save(exchangeRedis);
//        }
//    }

//    public List<ExchangeRedis> getExchange() {
//        List<ExchangeRedis> exchangeRedisList = (List<ExchangeRedis>) exchangeRedisRepository.findAll();
//
//        return exchangeRedisList;
//    }

//    public Map<String, Object> getRadisExchangeList() {
//        Map<String, Object> map = new HashMap<>();
//
//        List<Bank> bankList = Arrays.asList(Bank.values());
//        List<BankDto> banks = new ArrayList<>();
//        for(Bank bank: bankList) {
//            banks.add(BankDto.of(bank));
//        }
//        map.put("bank", banks);
//
//        System.out.println("radis 환율 가져오기");
//        long startTime = System.currentTimeMillis();
//        List<ExchangeRedis> exchangeList = (List<ExchangeRedis>) exchangeRedisRepository.findAll();
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - startTime));
//        map.put("list", exchangeList);
//        return map;
//    }

//    public void saveRadisExchange() throws IOException {
//        System.out.println("redis 환율 업데이트");
//        long startTime = System.currentTimeMillis();
//        exchangeRepository.deleteAll();
//        List<Bank> banks = Arrays.asList(Bank.values());
//
//        for(int b=0; b<banks.size(); b++) {
//            List<ExchangeDto> bankList = new ArrayList<>();
//            String URL = "https://www.mibank.me/exchange/bank/index.php?search_code="+ banks.get(b).getCode();
//            Document doc = Jsoup.connect(URL).get();
//            Elements countryList = doc.select("tbody tr");
//            for(int i=0; i<countryList.size(); i++) {
//                Elements country = countryList.get(i).select("td");
//                ExchangeRedis exchange = new ExchangeRedis();
//                exchange.setBank(banks.get(b).getName());
//                exchange.setCountry(country.get(1).text());
//                if(!country.get(2).text().equals("-")) {
//                    exchange.setCashBuyPrice(new BigDecimal(country.get(2).text()));
//                    exchange.setCashBuyRate(new BigDecimal(country.get(3).text().split("%")[0]));
//                }
//                if(!country.get(4).text().equals("-")) {
//                    exchange.setCashSellPrice(new BigDecimal(country.get(4).text()));
//                    exchange.setCashSellRate(new BigDecimal(country.get(5).text().split("%")[0]));
//                }
//                if(!country.get(6).text().equals("-")) {
//                    exchange.setTransferPrice(new BigDecimal(country.get(6).text()));
//                    exchange.setTransferRate(new BigDecimal(country.get(7).text().split("%")[0]));
//                }
//                exchange.setPrice(new BigDecimal(country.get(8).text()));
//                exchangeRedisRepository.save(exchange);
//            }
//        }
//
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - startTime));
//    }

    //template
//    public void radisInsertExchange() throws IOException {
//        List<Bank> banks = Arrays.asList(Bank.values());
//
//        System.out.println("radis 환율 업데이트");
//        long startTime = System.currentTimeMillis();
//
//        int cnt = 0;
//        for(int b=0; b<banks.size(); b++) {
//            List<ExchangeDto> bankList = new ArrayList<>();
//            String URL = "https://www.mibank.me/exchange/bank/index.php?search_code="+ banks.get(b).getCode();
//            Document doc = Jsoup.connect(URL).get();
//            Elements countryList = doc.select("tbody tr");
//            for(int i=0; i<countryList.size(); i++) {
//                Elements country = countryList.get(i).select("td");
//                Exchange exchange = new Exchange();
//                exchange.setBank(banks.get(b).getName());
//                exchange.setCountry(country.get(1).text());
//                if(!country.get(2).text().equals("-")) {
//                    exchange.setCashBuyPrice(new BigDecimal(country.get(2).text()));
//                    exchange.setCashBuyRate(new BigDecimal(country.get(3).text().split("%")[0]));
//                }
//                if(!country.get(4).text().equals("-")) {
//                    exchange.setCashSellPrice(new BigDecimal(country.get(4).text()));
//                    exchange.setCashSellRate(new BigDecimal(country.get(5).text().split("%")[0]));
//                }
//                if(!country.get(6).text().equals("-")) {
//                    exchange.setTransferPrice(new BigDecimal(country.get(6).text()));
//                    exchange.setTransferRate(new BigDecimal(country.get(7).text().split("%")[0]));
//                }
//                exchange.setPrice(new BigDecimal(country.get(8).text()));
//                redisTemplate.opsForValue().set(String.valueOf(++cnt), exchange);
//            }
//        }
//        numExchange = cnt;
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - startTime));
//    }
//
//    public Map<String, Object> radisGetExchangeList() {
//        Map<String, Object> map = new HashMap<>();
//
//        List<Bank> bankList = Arrays.asList(Bank.values());
//        List<BankDto> banks = new ArrayList<>();
//        for(Bank bank: bankList) {
//            banks.add(BankDto.of(bank));
//        }
//        map.put("bank", banks);
//
//        System.out.println("radis 환율 가져오기");
//        long startTime = System.currentTimeMillis();
//        Set<String> keys = redisTemplate.keys("exchange:*"); // 특정 패턴에 맞는 모든 키 가져오기
//        List<Exchange> exchangeList = new ArrayList<>();
//        for(int i=0; i<numExchange; i++) exchangeList.add((Exchange) redisTemplate.opsForValue().get(String.valueOf(i)));
//        long endTime = System.currentTimeMillis();
//        System.out.println((endTime - startTime));
//        map.put("list", exchangeList);
//        return map;
//    }
}
