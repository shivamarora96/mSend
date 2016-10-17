package com.example.shivamarora.msend;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by ShivamArora on 12-07-2016.
 */
public interface ApiInterface {
//==  https://webaroo-send-message-v1.p.mashape.com/sendMessage

    @Headers({"X-Mashape-Key: Xkf2j1Zj1KmshFnvJUBXnmsbpLnTp1uNXf3jsnjtbsm0Wu5ATA"})

    @GET("/sendMessage")                    //?message=<required>&phone=<required>

    Call<ApiResponse> getResponse(@Query("message") String message  , @Query("phone") Number phone);

}
