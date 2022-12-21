package com.position.reptile;

import java.util.HashMap;
import java.util.Map;

public class HttpClientData {
    public static void main(String[] args) throws Exception {
        //设置请求头
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", "__lg_stoken__=790210b9ee987aaf7332a9b02dcb4740cf8ffbf149aa6c12fdfe00a62ee7adb6df2547bc863054c31af730a3307d9a514b0bb85dc103ab3d3da964eece2e81390f6d2451bac7; WEBTJ-ID=20221221122932-18532f19b13391-0b0e55f0c52f2-26021151-2073600-18532f19b147b3; JSESSIONID=ABAAABAABAGABFA48C6434C99A6B3600EE737F91D54ED92; sajssdk_2015_cross_new_user=1; sensorsdata2015session=%7B%7D; _ga=GA1.2.1727842264.1671597008; _gid=GA1.2.184533433.1671597008; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1671597008; user_trace_token=20221221123007-8e0ec226-622c-4aa7-8140-eb79de5df7d2; LGUID=20221221123007-12ad3d25-718f-41f9-9cd7-f8c8171d3951; gate_login_token=dce45c0ea3cb8ef6f75c77c236e216e2118d9096328d4abb2df4250e0a99875d; _putrc=563FED06E76708F4123F89F2B170EADC; login=true; unick=tcx; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=0; privacyPolicyPopup=false; RECOMMEND_TIP=true; __SAFETY_CLOSE_TIME__25583544=1; index_location_city=%E5%85%A8%E5%9B%BD; TG-TRACK-CODE=index_search; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1671605682; LGRID=20221221145451-71d371c5-ae9e-453b-8699-28f0bad91a13; X_HTTP_TOKEN=269c5e608455b712308506176100cbe866eb3eb92b; amp_adc4c4=Rfb7RvWkLefYRTEwkLc2v9...1gkppp055.1gkpqhre4.0.0.0; amp_d915a9=QjXITtQUUZdog1HQ_T2E70...1gkppp0bi.1gkpqhrki.0.0.0; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2225583544%22%2C%22first_id%22%3A%2218532f19ca998f-03282e337dfee-26021151-2073600-18532f19caadbf%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%22108.0.0.0%22%7D%2C%22%24device_id%22%3A%2218532f19ca998f-03282e337dfee-26021151-2073600-18532f19caadbf%22%7D");
//                "user_trace_token=20211203100902-065b27a1-3801-444e-9ae2-42af0d6377aa; _ga=GA1.2.1216667019.1638497342; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1638497342; LGUID=20211203100902-6bb30a0c-3e0c-4334-baa3-a74ff7c33b23; _gid=GA1.2.2074537390.1638497363; sajssdk_2015_cross_new_user=1; gate_login_token=ddecac03b377a9fc072384865d851f4b802094e671db14c3fb3ef70f8e13e605; LG_LOGIN_USER_ID=6a2d4de2532b029b8e15427d658310c6519cb3d6fd6979073d630640ed46332d; LG_HAS_LOGIN=1; _putrc=1C05C0C858762C23123F89F2B170EADC; JSESSIONID=ABAAAECABFAACEA5386F8973D2D2DAD90CD126BB4CD01D6; login=true; unick=%E7%94%A8%E6%88%B77389; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=0; privacyPolicyPopup=false; index_location_city=%E5%85%A8%E5%9B%BD; WEBTJ-ID=2021123%E4%B8%8A%E5%8D%8810:10:33101033-17d7e0eb79840d-03ee8bdad924c4-5771031-1327104-17d7e0eb7998a1; RECOMMEND_TIP=true; __SAFETY_CLOSE_TIME__19467224=1; sensorsdata2015session=%7B%7D; TG-TRACK-CODE=index_search; X_HTTP_TOKEN=faf94b15d0151260096315836132f454ff4efb81c1; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1638513691; LGRID=20211203144140-c88f3890-0bc1-4e52-8a3a-2be63e9d5058; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2219467224%22%2C%22%24device_id%22%3A%2217d7e0da2a746e-0e7e4e7f5aea5b-5771031-1327104-17d7e0da2a8407%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%2289.0.4389.90%22%7D%2C%22first_id%22%3A%2217d7e0da2a746e-0e7e4e7f5aea5b-5771031-1327104-17d7e0da2a8407%22%7D");
        headers.put("Connection", "keep-alive");
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en-GB;q=0.8,en;q=0.7");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " + "AppleWebKit/537.36 (KHTML, like Gecko) " + "Chrome/75.0.3770.142 Safari/537.36");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Referer", "https://www.lagou.com/wn/jobs?cl=false&fromSearch=true&kd=%E5%A4%A7%E6%95%B0%E6%8D%AE");
        headers.put("Origin", "https://www.lagou.com");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("X-Anit-Forge-Token", "None");
        headers.put("Cache-Control", "no-cache");
        headers.put("X-Anit-Forge-Code", "0");
        headers.put("Host", "www.lagou.com");
        //设置请求参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd", "大数据");
        params.put("city", "全国");
        for (int i = 1; i < 31; i++) {
            params.put("pn", String.valueOf(i));
            HttpClientResp result = HttpClientUtils.doPost("https://www.lagou.com/jobs/v2/positionAjax.json?" + "needAddtionalResult=false&first=true&px=default", headers, params);
            System.out.println(result.toString());
            HttpClientHdfsUtils.createFileBySysTime("hdfs://hadoop:8020", "page" + i, result.toString());
            Thread.sleep(1 * 500);

        }
    }
}
