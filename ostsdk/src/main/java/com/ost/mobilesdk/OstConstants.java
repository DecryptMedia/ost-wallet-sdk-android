package com.ost.mobilesdk;

public interface OstConstants {
    String RESPONSE_SUCCESS = "success";
    String RESPONSE_DATA = "data";
    String RESULT_TYPE = "result_type";

    int THREAD_POOL_SIZE = 5;
    String BLOCK_HEIGHT = "block_height";
    String BLOCK_TIME = "block_time";
    String USER_ID = "user_id";
    String TOKEN_ID = "token_id";
    String METHOD = "method";
    String PARAMETERS = "parameters";
    String QR_DATA = "d";
    String QR_DATA_DEFINITION = "dd";
    String QR_DATA_DEFINITION_VERSION = "ddv";
    String QR_DEVICE_ADDRESS = "da";
    String DATA_DEFINITION_TRANSACTION = "TX";
    String DATA_DEFINITION_AUTHORIZE_DEVICE = "AUTHORIZE_DEVICE";
    String DATA_DEFINITION_REVOKE_DEVICE = "RD";
    String QR_RULE_NAME = "rn";
    String QR_TOKEN_HOLDER_ADDRESSES = "ads";
    String QR_AMOUNTS = "ams";
    String QR_TOKEN_ID = "tid";

    String RULE_NAME = "rule_name";
    String TOKEN_HOLDER_ADDRESSES = "token_holder_addresses";
    String AMOUNTS = "amounts";
    String DEVICE_ADDRESS = "device_address";

    int RECOVERY_PHRASE_PREFIX_MIN_LENGTH = 30;
    int RECOVERY_PHRASE_USER_INPUT_MIN_LENGTH = 6;
    long POLLING_WAIT_TIME_IN_SECS = 60 * 2;

    int BUILD_VERSION_CODE = BuildConfig.VERSION_CODE;
    String BUILD_VERSION_NAME = BuildConfig.VERSION_NAME;
    String OST_API_VERSION = "2";
    String USER_AGENT = String.format("ost-sdk-android-%s-%s", OST_API_VERSION, BUILD_VERSION_NAME);
    String CONTENT_TYPE = "application/x-www-form-urlencoded";

    //Todo:: Will come from config
    int OST_BLOCK_GENERATION_TIME = 3;
    int OST_PIN_MAX_RETRY_COUNT = 3;
    String OST_PRICE_POINT_TOKEN_SYMBOL = "OST";
    String OST_PRICE_POINT_CURRENCY_SYMBOL = "OST";
    int OST_REQUEST_TIMEOUT_DURATION = 6; //Seconds
    long OST_SESSION_BUFFER_TIME = 60 * 60;
}