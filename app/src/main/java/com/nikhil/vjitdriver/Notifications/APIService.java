package com.nikhil.vjitdriver.Notifications;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAo_Udrq4:APA91bEOms7-_UVFDyVfPQ_XTo2Z6Ec-q2xgdMlpyIL1w6B8u2t2eqGFplZvlyhAnCH0lqr-MOPhR24zz1fgOXhfcHb4ubuZcxFfK1mpZcLGoPuGyH7Ik13Wq2A3guscyzuQVq-mGMrd"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
