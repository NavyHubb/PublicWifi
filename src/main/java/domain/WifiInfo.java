package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class WifiInfo {

    private String distance; // 거리
    private String adminNumber; // 관리 번호
    private String borough; // 자치구
    private String wifiName; // wifi 네임
    private String roadName; // 도로명 주소
    private String detailAddress; // 상세 주소
    private String installPosition; // 설치 위치
    private String installType; // 설치 유형
    private String installAgency; // 설치 기관
    private String serviceType; // 서비스구분
    private String netType; // 망종류
    private String installYear; // 설치년도
    private String inOutDoorType; // 실내외구분
    private String wifiConnEnv; // wifi 접속 환경
    private String posX; // x좌표
    private String posY; // y좌표
    private String dateTime; // 작업일자


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getInstallPosition() {
        return installPosition;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getInstallType() {
        return installType;
    }

    public void setInstallType(String installType) {
        this.installType = installType;
    }

    public String getInstallAgency() {
        return installAgency;
    }

    public void setInstallAgency(String installAgency) {
        this.installAgency = installAgency;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getInstallYear() {
        return installYear;
    }

    public void setInstallYear(String installYear) {
        this.installYear = installYear;
    }

    public String getInOutDoorType() {
        return inOutDoorType;
    }

    public void setInOutDoorType(String inOutDoorType) {
        this.inOutDoorType = inOutDoorType;
    }

    public String getWifiConnEnv() {
        return wifiConnEnv;
    }

    public void setWifiConnEnv(String wifiConnEnv) {
        this.wifiConnEnv = wifiConnEnv;
    }

    public String getPosX() {
        return posX;
    }

    public void setPosX(String posX) {
        this.posX = posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setPosY(String posY) {
        this.posY = posY;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}