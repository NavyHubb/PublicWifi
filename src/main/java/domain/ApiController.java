package domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.WifiDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

public class ApiController {
    static final String KEY = "626851614b736a38383955684c4351";
    static int TOTALCNT;

    public static void main(String[] args) throws ParseException {
        AddWifi();
    }

    public static int TotalCnt() throws ParseException {
        URL url = null;
        HttpURLConnection con= null;
        JsonObject result = null;
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int end = 1;
        String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                "json/TbPublicWifiInfo/"+ start + "/"+end+"/";

        try {
            url = new URL(baseUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("Content-type", "application/json");

            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }
            con.disconnect();
        }catch(Exception e) {
            e.printStackTrace();
        }

        result = (JsonObject) new JsonParser().parse(sb.toString());

        StringBuilder out = new StringBuilder();

        JsonObject data = (JsonObject) result.get("TbPublicWifiInfo");
        int totalGet = Integer.parseInt( data.get("list_total_count").toString());

        return totalGet;
    }

    public static int AddWifi() throws ParseException{
        int start = 0;
        int end = 0;
        int total = 0;

        TOTALCNT = TotalCnt();
        int pageEnd = TOTALCNT / 1000;
        int pageEndRemain = TOTALCNT % 1000;

        WifiDao wifiDao = new WifiDao();
        wifiDao.truncateWifiInfo();

        for (int k = 0; k <= pageEnd; k++) {
            start = (int) Math.pow(10, 3) * k + 1;

            if(k == pageEnd){
                end = start + pageEndRemain - 1;
            }
            else{
                end = (int) Math.pow(10, 3) * (k+1) ;
            }

            String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                    "json/TbPublicWifiInfo/";

            baseUrl = baseUrl + start + "/" + end + "/";

            URL url = null;
            HttpURLConnection con= null;
            JsonObject result = null;
            StringBuilder sb = new StringBuilder();


            try {
                url = new URL(baseUrl);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-type", "application/json");
                con.setDoOutput(true);


                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                while(br.ready()) {
                    sb.append(br.readLine());
                }
                con.disconnect();
            }catch(Exception e) {
                e.printStackTrace();
            }

            result = (JsonObject) new JsonParser().parse(sb.toString());

            JsonObject data = (JsonObject) result.get("TbPublicWifiInfo");
            JsonArray array = (JsonArray) data.get("row");

//            List<WifiInfo> wifiInfoList = new ArrayList<>();

            array.forEach(elem -> {
                JsonObject jsonObj = elem.getAsJsonObject();

                WifiInfo wifiInfo = WifiInfo.builder()
                        .adminNumber(parseJsonObjToStr(jsonObj, "X_SWIFI_MGR_NO"))
                        .borough(parseJsonObjToStr(jsonObj, "X_SWIFI_WRDOFC"))
                        .wifiName(parseJsonObjToStr(jsonObj, "X_SWIFI_MAIN_NM"))
                        .roadName(parseJsonObjToStr(jsonObj, "X_SWIFI_ADRES1"))
                        .detailAddress(parseJsonObjToStr(jsonObj, "X_SWIFI_ADRES2"))
                        .installPosition(parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_FLOOR"))
                        .installType(parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_TY"))
                        .installAgency(parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_MBY"))
                        .serviceType(parseJsonObjToStr(jsonObj, "X_SWIFI_SVC_SE"))
                        .netType(parseJsonObjToStr(jsonObj, "X_SWIFI_CMCWR"))
                        .installYear(parseJsonObjToStr(jsonObj, "X_SWIFI_CNSTC_YEAR"))
                        .inOutDoorType(parseJsonObjToStr(jsonObj, "X_SWIFI_INOUT_DOOR"))
                        .wifiConnEnv(parseJsonObjToStr(jsonObj, "X_SWIFI_REMARS3"))
                        .posX(parseJsonObjToStr(jsonObj, "LAT"))
                        .posY(parseJsonObjToStr(jsonObj, "LNT"))
                        .dateTime(parseJsonObjToStr(jsonObj, "WORK_DTTM"))
                        .build();

//                WifiInfo wifiInfo = new WifiInfo(
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_MGR_NO"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_WRDOFC"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_MAIN_NM"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_ADRES1"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_ADRES2"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_FLOOR"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_TY"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_TY"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_INSTL_MBY"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_SVC_SE"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_CMCWR"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_CNSTC_YEAR"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_INOUT_DOOR"),
//                        parseJsonObjToStr(jsonObj, "X_SWIFI_REMARS3"),
//                        parseJsonObjToStr(jsonObj, "LAT"),
//                        parseJsonObjToStr(jsonObj, "LNT"),
//                        parseJsonObjToStr(jsonObj, "WORK_DTTM")
//                        );

                wifiDao.insertWifiInfo(wifiInfo);

//                wifiInfoList.add(wifiInfo);
            });
        }

        return total;
    }

    public static String parseJsonObjToStr(JsonObject jsonObj, String parseUnit) {
        return jsonObj.get(parseUnit).getAsString().replace("\"", "");
    }

    public static String parseJsonObjToStr(JsonObject jsonObj, String parseUnit, Object obj) {
        String parseStr = jsonObj.get(parseUnit).getAsString().replace("\"", "");

        if ((obj instanceof Object && parseStr.equals("")) ||
                (obj instanceof Double && parseStr.equals(""))) {
            return "0";
        }
        return parseStr;
    }
}
