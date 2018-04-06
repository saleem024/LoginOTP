package com.techkshetrainfo.loginotp.Restapi;

import com.techkshetrainfo.loginotp.Models.CategoryResponse;
import com.techkshetrainfo.loginotp.Models.ComplaintDetailResponse;
import com.techkshetrainfo.loginotp.Models.ComplaintListResponse;
import com.techkshetrainfo.loginotp.Models.OptResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Navdeep on 12/5/2016.
 */

public interface GetApi {

    @GET("Signup/get_cate")
    Call<CategoryResponse> getCategory();

    /*@FormUrlEncoded
    @POST("/retrofit/index.php/Signup/")
    Call<Detail> LoginUser(@Field("email") String email, @Field("password") String password);
    @POST("/api/{email}/{password}")
    Call<Detail> LoginUser(@Path("email") String email, @Path("password") String password);*/

    @FormUrlEncoded
    @POST("Signup/get_Sub_cate")
    Call<CategoryResponse> get_Sub_cate(@Field("category_id") String id);

    @FormUrlEncoded
    @POST("Signup/get_otp")
    Call<OptResponse> getopt(@Field("phone_no") String phone_no);

    @FormUrlEncoded
    @POST("Signup/upload")
    Call<OptResponse> uploadFile(@Field("user_email") String email,
                                 @Field("description") String description,
                                 @Field("name") String name,
                                 @Field("location") String location,
                                 @Field("contact_no") String contact_no,
                                 @Field("category_id") String category_id,
                                 @Field("sub_category_id") String sub_category_id);

 @Multipart
    @POST("Signup/upload_photo")
    Call<OptResponse> upload_photo(
         @Part("complaint_auto_id") RequestBody complaint_auto_id,
         @Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("Signup/get_complaint_list")
    Call<ComplaintListResponse> getComplaintList(@Field("phone_no") String phone_no);

    @FormUrlEncoded
    @POST("Signup/get_complaint_detail")
    Call<ComplaintDetailResponse> getComplaintdetail(@Field("complaint_id") String complaint_id);
}
