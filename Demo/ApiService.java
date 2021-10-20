package com.ash.cep.api;




import com.ash.cep.bean.BankCardListBean;
import com.ash.cep.bean.BusinessStatusBean;
import com.ash.cep.bean.ConfirmBean;
import com.ash.cep.bean.ExamBean;
import com.ash.cep.bean.GPSConfigBean;
import com.ash.cep.bean.HomeApplyBean;
import com.ash.cep.bean.HomeBean;
import com.ash.cep.bean.HomeConfigBean;
import com.ash.cep.bean.LoginBean;
import com.ash.cep.bean.MineUserBean;
import com.ash.cep.bean.RepayBean;
import com.ash.cep.bean.RepayChannelListBean;
import com.ash.cep.bean.SendSmsBean;
import com.ash.cep.bean.SpreadBean;
import com.ash.cep.bean.TradeOrderDetailBean;
import com.ash.cep.bean.TradeRecordsListBean;
import com.ash.cep.bean.UserDetailBean;
import com.ash.cep.network.HttpResponse;
import com.ash.cep.network.interceptor.Base64RequestEncryptInterceptor;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Cash Cepat
 * com.ash.cep
 */

public interface ApiService {

    /**
     * 发送验证码
     *
     * @param mobile
     * @param type (voice/text)
     * @return
     */
    @POST("0X30rhbtuKb")
    @FormUrlEncoded
    Flowable<HttpResponse<SendSmsBean>> sendVerifiyCode(@Field("mobile") String mobile, @Field("type") String type);

    /**
     * Firebase推送同步注册token
     *
     * @param registryToken
     * @return
     */
    @POST("6rr9tGsM17lNB8vQUc")
    @FormUrlEncoded
    Flowable<HttpResponse<Boolean>> registryTokenInfo(@Field("registryToken") String registryToken);


    /**
     * 通讯录保存
     *
     * @param contactsList
     * @return
     */
    @POST("esJ2oE3OiuyrdIsiWrzDpSIh")
    @FormUrlEncoded
    Flowable<HttpResponse<Boolean>> saveContactsList(@Field("contactsList") String contactsList);


    /**
     * 登录
     *
     * @param phone
     * @param code
     * @return
     */
    @POST("nprYUGKaLi")
    @FormUrlEncoded
    Flowable<HttpResponse<LoginBean>> login(@Field("phone") String phone, @Field("code") String code);

    /**
     * 工具首页V3
     * @return
     * api/v3/common/tool
     *
     */
    @GET("N47qywDmwcr8")
    Flowable<HttpResponse<ExamBean>> tool();

    /**
     * Config查询config/one
     * @return
     * /api/v3/common/config/one
     *
     */
    @GET("TrnAg268UANvk6l6jTP4OE40")
    Flowable<HttpResponse<GPSConfigBean>> getGpsConfig(@Query("configKey") String configKey);

    /**
     * Config查询config/one
     * @return
     * /api/v3/common/config/one
     *cNonPfDRRkwV
     */
    @GET("TrnAg268UANvk6l6jTP4OE40")
    Flowable<HttpResponse<HomeConfigBean>> getHomeConfig(@Query("configKey") String configKey);

    /**
     * 首页
     *
     * @return
     */
    @GET("WD5kPYDYezTFYuAZ")
    Flowable<HttpResponse<HomeBean>> home();


    /**
     * 检查是否需要tips
     */
    @POST("wmA8EnzzarNLyoHNfbH")
    Flowable<HttpResponse<Boolean>> checkTips();

    /**
     * 借款申请
     *
     * @return
     */
    @POST("LtK5f5hDEaakNtWsK")
    @FormUrlEncoded
    Flowable<HttpResponse<HomeApplyBean>> homeApply(@Field("cardNo") String cardNo);


    /**
     * 查询用户认证详情
     *
     * @return
     */
    @POST("GaeK0eHQqa")
    Flowable<HttpResponse<UserDetailBean>> queryUserDetail();


    /**
     * 用户基本信息认证
     *
     * @return
     */
    @POST("BtORIdQLxNQ4B")
    @Headers({"Content-type:application/json;charset=UTF-8"})
    Flowable<HttpResponse<BusinessStatusBean>> identitycheck(@Body RequestBody body);


    /**
     * 身份证信息认证
     *
     * @return
     */
    @POST("8hIw4Pf6dK9y5oJ0dzD1EUD")
    @Headers({Base64RequestEncryptInterceptor.ContentEncodedHeaderName+": true"})
    @FormUrlEncoded
    Flowable<HttpResponse<BusinessStatusBean>> ocrCheck(@Field("idCardPositiveImg") String idCardPositiveImg);


    /**
     * 身份证信息确认
     *
     * @return
     */
    @POST("a3I129uJ5")
    @FormUrlEncoded
    Flowable<HttpResponse<Boolean>> ocrConfirm(@Field("idNo") String idNo, @Field("userName") String userName);


    /**
     * 人脸信息认证
     *
     * @return
     */
    @POST("2obr6gyJHRm5lWafoGA29M")
    @Multipart
    Flowable<HttpResponse<BusinessStatusBean>> faceCompare(@Part List<MultipartBody.Part> partLis);


    /**
     * 获取license
     *
     * @return
     */
    @GET("YCDUmfPbP8FRFzVO2sZ")
    Flowable<HttpResponse<String>> license();

    /**
     * 获取活体识别结果
     *
     * @return
     */
    @POST("7lJyKdrBeUjDqQ")
    @FormUrlEncoded
    Flowable<HttpResponse<String>> detection(@Field("livenessId") String livenessId);


    /**
     * 银行列表
     *
     * @return
     */
    @GET("oe2zM8k3c8")
    Flowable<HttpResponse<BankCardListBean>> bindCardList();

    /**
     * 绑卡认证
     *"name": "TINO BAGUS KURNIAWAN",     userName
     *"accountNumber": "12345678901",       cardNumber
     *"bankCode": "SUMSEL_BABEL",           bankcode
     *"thirdChannelCode": "T001",           thirdChannelCode
     *"code": "10088",                      code
     * @return
     */
    @POST("i0K56b0jUIwU")
    @FormUrlEncoded
    Flowable<HttpResponse<BusinessStatusBean>> bindCard(@Field("name") String name,
                                                            @Field("accountNumber") String accountNumber,
                                                            @Field("bankCode") String bankCode,
                                                            @Field("thirdChannelCode") String thirdChannelCode,
                                                            @Field("code") String code);


    /**
     * Banner查询
     *
     * @return
     */
    @GET("PLb6Em5xZ")
    Flowable<HttpResponse<List<HomeBean.CashBannerRespsDTO>>> banner(@Query("bannerType") String bannerType);


    /**
     * 用户信息
     *
     * @return
     */
    @POST("keWiDU6T5iulF6f6zV8s813z")
    Flowable<HttpResponse<MineUserBean>> queryCashUser();


    /**
     * 借款记录
     *
     * @return
     */
    @POST("jZgbFrvIfeN6dohNnqM")
    @FormUrlEncoded
    Flowable<HttpResponse<TradeRecordsListBean>> loadOrderRecord(@Field("applyStatus") String applyStatus);


    /**
     * 借款确认
     * @return
     */
    @POST("PE7w2MfBu8WZi7")
    @FormUrlEncoded
    Flowable<HttpResponse<ConfirmBean>> confirm(@Field("cardNo") String cardNo, @Field("productCodes") String productCodes);

    /**
     * 还款渠道
     *
     * @return
     */
    @GET("yMrSxWwo24dY")
    Flowable<HttpResponse<RepayChannelListBean>> repayChannels(@Query("repayPlanId") String repayPlanId);

    /**
     * 还款请求
     *
     * @return
     */
    @POST("KVy5e9Lg")
    @FormUrlEncoded
    Flowable<HttpResponse<RepayBean>> repay(@Field("repayPlanId") String repayPlanId, @Field("repayChannel") String repayChannel);


    /**
     * 展期试算
     *
     * @return
     */
    @POST("DuKpQOQa6HWGwg0gJWstg")
    @FormUrlEncoded
    Flowable<HttpResponse<SpreadBean>> trial(@Field("repayPlanId") String repayPlanId);


    /**
     * 展期还款
     *
     * @return
     */
    @POST("fFojmMgLUww")
    @FormUrlEncoded
    Flowable<HttpResponse<RepayBean>> extensionRepay(@Field("repayPlanId") String repayPlanId, @Field("repayChannel") String repayChannel);

    /**
     * 借款详情
     *
     * @return
     */
    @POST("VaiSIN5rqroS0rT")
    @FormUrlEncoded
    Flowable<HttpResponse<TradeOrderDetailBean>> loanOrderDetail(@Field("applyId") String applyId);


    /**
     * Config查询
     * configType=customer 查询客服界面的信息
     *
     * @return
     */
    @GET("IirUpNSxX")
    Flowable<HttpResponse<List<GPSConfigBean>>> config(@Query("configType") String configType);


    /**
     * 退出登录
     *
     * @return
     */
    @GET("dpkQtA517oRbXTnU")
    Flowable<HttpResponse<Object>> loginOut(@Query("version") String version);


    /**
     * Adjust
     *
     * @return
     */
    @POST("xte2gpB4GJNUVT")
    @FormUrlEncoded
    Flowable<HttpResponse<Object>> loadAdjust(@Field("adId") String adId, @Field("trackerName") String trackerName, @Field("gps_adid") String gps_adid);


    /**
     * 设备信息保存
     *
     * @return
     */
    @POST("6lxJ2tQYWWK2GWlnqS")
    @Headers({"Content-type:application/json;charset=UTF-8"})
    Flowable<HttpResponse<Boolean>> deviceInfo(@Body RequestBody body);


    /**
     * APP保存
     *
     * @return
     */
    @POST("LaI79ZtmyNodjStOBup")
    @FormUrlEncoded
    Flowable<HttpResponse<Boolean>> appList(@Field("appList") String appList);
}
