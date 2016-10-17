package com.example.shivamarora.msend;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ShivamArora on 12-07-2016.
 */
public class ApiResponse {

    String status ;

    @SerializedName("data")
    Data data ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}



class Data {

    String code ;
    String message ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}