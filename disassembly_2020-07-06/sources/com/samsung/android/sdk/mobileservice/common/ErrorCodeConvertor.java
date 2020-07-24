package com.samsung.android.sdk.mobileservice.common;

import com.samsung.android.sdk.mobileservice.common.result.CommonStatusCodes;
import com.samsung.android.sdk.mobileservice.util.SdkLog;
import java.util.HashMap;

public class ErrorCodeConvertor {
    public static final long ACTIVITY_UNAUTHORIZED_CONTENTS = 4000000303L;
    public static final long AGENT_DATABASE_ERROR = 1008;
    public static final long AGENT_DEVICE_ALREADY_AUTHENTICATED = 1003;
    public static final long AGENT_DEVICE_NOT_AUTHENTICATE = 1001;
    public static final long AGENT_DEVICE_PERMISSIONS_DENIED = 1004;
    public static final long AGENT_FILE_IO_ERROR = 1009;
    public static final long AGENT_INTERNAL_ERROR = 1007;
    public static final long AGENT_INVALID_MSISDN = 1011;
    public static final long AGENT_INVALID_PARAMETER = 1006;
    public static final long AGENT_NETWORK_UNAVAILABLE = 1005;
    public static final long AGENT_NOT_ACTIVATED = 1012;
    public static final long AGENT_NOT_USER_OWNER = 1013;
    public static final long AGENT_SERVICE_DISABLED = 1010;
    public static final long AGENT_SIM_STATE_ABSENT = 1002;
    public static final long AGENT_UNKNOWN_ERROR = 1000;
    public static final long AGENT_VOLLEY_CANCELED = 1014;
    public static final long AGENT_VOLLEY_INTERNAL_NETWORK = 1016;
    public static final long AGENT_VOLLEY_NETWORK_TIMEOUT = 1015;
    public static final long AGENT_VOLLEY_PARSING = 1017;
    public static final long AGENT_WIFI_ONLY_MODEL = 1031;
    public static final String AUTH_TOKEN_EXPIRED = "SAC_0402";
    public static final String CALLER_NOT_ACTIVITY = "SAC_0106";
    public static final int CLOUD_BAD_ACCESS_TOKEN = 19008;
    public static final int CLOUD_BAD_ACCESS_TOKEN2 = 19018;
    public static final int CLOUD_BAD_ACCESS_TOKEN3 = 19019;
    public static final int CLOUD_BAD_JSON_FORMAT = 19700;
    public static final int CLOUD_CANNOT_CHANGE_USER_STATUS = 49208;
    public static final int CLOUD_DELETED_USER = 49201;
    public static final int CLOUD_DELETING_USER_DATA = 49702;
    public static final int CLOUD_DEVICE_ID_BAD_FORMAT = 19005;
    public static final int CLOUD_DEVICE_ID_REQUIRED = 19004;
    public static final int CLOUD_FILE_NOT_EXIST = 108305;
    public static final int CLOUD_HEADER_BAD_FORMAT = 102104;
    public static final int CLOUD_HEADER_HASH_INVALID = 69014;
    public static final int CLOUD_HEADER_HASH_REQUIRED = 69013;
    public static final int CLOUD_HEADER_REQUIRED = 102103;
    public static final int CLOUD_INACTIVE_USER_APP_SERVICE = 49206;
    public static final int CLOUD_INTERNAL_SERVER_ERROR = 49500;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_ACCOUNT = 49502;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_CACHE = 49504;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_CASSANDRA = 49511;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_CHATON = 49503;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_GLOBAL = 49514;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_QUOTA = 49501;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_QUOTA_TIMEOUT = 49513;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_REDIS = 49512;
    public static final int CLOUD_INTERNAL_SERVER_ERROR_TIMEOUT = 49505;
    public static final int CLOUD_INVALID_USER = 49202;
    public static final int CLOUD_LOCK_SERVER_FAILED = 99002;
    public static final long CLOUD_OUT_OF_STORAGE = 20003;
    public static final int CLOUD_PARAM_APPID_REQUIRED = 49010;
    public static final int CLOUD_PARAM_APPID_UNSUPPORTED = 49011;
    public static final int CLOUD_PARAM_CA_DEVICE_ID_INVALID = 49136;
    public static final int CLOUD_PARAM_DATA_CLEAR_INVALID = 49163;
    public static final int CLOUD_PARAM_DATA_CLEAR_REQUIRED = 49162;
    public static final int CLOUD_PARAM_DEVICE_INFO_INVALID = 49129;
    public static final int CLOUD_PARAM_DEVICE_INFO_REQUIRED = 49128;
    public static final int CLOUD_PARAM_DEVICE_OS_INVALID = 49131;
    public static final int CLOUD_PARAM_DEVICE_OS_REQUIRED = 49130;
    public static final int CLOUD_PARAM_DEVICE_OS_VER_INVALID = 49135;
    public static final int CLOUD_PARAM_DEVICE_OS_VER_REQUIRED = 49134;
    public static final int CLOUD_PARAM_DEVICE_TYPE_INVALID = 49133;
    public static final int CLOUD_PARAM_DEVICE_TYPE_REQUIRED = 49132;
    public static final int CLOUD_PARAM_GCID_INVALID = 49161;
    public static final int CLOUD_PARAM_GCID_REQUIRED = 49160;
    public static final int CLOUD_PARAM_INVALID = 102107;
    public static final int CLOUD_PARAM_MNC_INVALID = 49151;
    public static final int CLOUD_PARAM_MODEL_INVALID = 49110;
    public static final int CLOUD_PARAM_MODEL_REQUIRED = 49109;
    public static final int CLOUD_PARAM_PHYSICAL_DEVICE_ID_INVALID = 49167;
    public static final int CLOUD_PARAM_PHYSICAL_DEVICE_ID_REQUIRED = 49166;
    public static final int CLOUD_PARAM_PUSH_APPID_INVALID = 49102;
    public static final int CLOUD_PARAM_PUSH_APPID_REQUIRED = 49101;
    public static final int CLOUD_PARAM_PUSH_INFO_INVALID = 49127;
    public static final int CLOUD_PARAM_PUSH_INFO_REQUIRED = 49126;
    public static final int CLOUD_PARAM_PUSH_TOKEN_INVALID = 49104;
    public static final int CLOUD_PARAM_PUSH_TOKEN_REQUIRED = 49103;
    public static final int CLOUD_PARAM_PUSH_TYPE_INVALID = 49106;
    public static final int CLOUD_PARAM_PUSH_TYPE_REQUIRED = 49105;
    public static final int CLOUD_PARAM_REGISTER_INVALID = 49146;
    public static final int CLOUD_PARAM_REGISTER_REQUIRED = 49145;
    public static final int CLOUD_REQUEST_BODY_BAD_FORMAT = 102106;
    public static final int CLOUD_REQUEST_BODY_REQUIRED = 102105;
    public static final int CLOUD_REQUEST_DORMANT_USER = 19012;
    public static final int CLOUD_TEMPORARILY_UNAVAILABLE_MIGRATION = 99001;
    public static final int CLOUD_UID_VALIDATION = 19000;
    public static final int CLOUD_UID_VALIDATION2 = 19001;
    public static final int CLOUD_USER_NOT_EXIST = 49203;
    public static final long COMMON_HEADER_REQUIRED = 4000101021L;
    public static final long COMMON_INTERNAL_SERVER_ERROR = 5000100000L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_CASSANDRA = 5000100003L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_DB = 5000100001L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_MSISDN = 5000100201L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_PROFILE = 5000100203L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_PROFILE_TYPE = 5000100206L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_READ_CALL_PROFILE = 5000100202L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_UNKNOWN = 5000100501L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_USER_INFO = 5000100207L;
    public static final long COMMON_INTERNAL_SERVER_ERROR_WRITE_CALL_PROFILE = 5000100204L;
    public static final long COMMON_INVALID_AUTHORIZATION = 4000100103L;
    public static final long COMMON_INVALID_CONTACT_TOKEN = 4000100105L;
    public static final long COMMON_INVALID_PARAMETER = 4000100000L;
    public static final long COMMON_INVALID_TOKEN_REQUEST = 4000100104L;
    public static final long COMMON_JSON_MAPPING_ERROR = 4000100001L;
    public static final long COMMON_NOT_REGISTERED_USER = 4000100002L;
    public static final long COMMON_NOT_REGISTERED_USER2 = 4000100100L;
    public static final int DEVICE_ALREADY_AUTHENTICATED = 103;
    public static final int DEVICE_NOT_AUTHENTICATE = 100;
    public static final int DEVICE_PERMISSIONS_DENIED = 104;
    public static final String DUPLICATE_REQUEST = "SAC_0501";
    public static final long ERROR_AGENT_TASK_CANCELED = 1019;
    public static final long ERROR_FILE_IS_TOO_LARGE = 108601;
    public static final long ERROR_GROUP_STATUS_CHANGED = 1030;
    public static final long ERROR_INVALID_ACCESSTOKEN = 1021;
    public static final long ERROR_ITEM_IS_DELETED = 1034;
    public static final long ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED = 1023;
    public static final long ERROR_LACK_OF_DEVICE_STORAGE = 1035;
    public static final int ERROR_NETWORK_UNAVAILABLE = 400;
    public static final long ERROR_NOT_ALLOWED_CALLER = 1024;
    public static final long ERROR_QUOTA_IS_EXEED = 1025;
    public static final long ERROR_RESULT_NOT_FOUND = 1043;
    public static final long ERROR_SOCIAL_DISCLAIMER_AGREEMENT_NEEDED = 1039;
    public static final long ERROR_SOCIAL_SERVICE_NOT_AVAILABLE = 1037;
    public static final long ERROR_SOCIAL_SERVICE_TERMINATED = 1038;
    public static final long ERROR_SOCIAL_SERVICE_WITHDRAWAL = 1040;
    public static final long ERROR_SPACE_DELETED_BY_ME = 1028;
    public static final long ERROR_SPACE_DELETED_BY_OTHER = 1027;
    public static final long ERROR_TASK_PAUSED = 1029;
    public static final long FEEDBACK_EMOTION_ALREADY_CANCELED = 120102;
    public static final long FEEDBACK_EMOTION_ALREADY_UPDATED = 120103;
    public static final long FEEDBACK_INVALID_ACTIVITY_ID = 120105;
    public static final long FEEDBACK_INVALID_COMMENT_ID = 120104;
    public static final long FEEDBACK_PERMISSION_DENIED = 120101;
    public static final long GDPR_DELETED_ERROR = 101903;
    public static final long GDPR_PROCESSED_ERROR = 101901;
    public static final long GDPR_RESTRICTED_ERROR = 101902;
    public static final long GROUP_ALREADY_ACCEPTED = 4000701034L;
    public static final long GROUP_BAD_JSON_FORMAT = 4000701041L;
    public static final long GROUP_CANNOT_CHANGE_UNIQUE_GROUP_NAME = 4000701035L;
    public static final long GROUP_EXCEEDS_LIMIT_NUMBER_GROUPS_OR_ALREADY_JOINED_ANOTHER_UNIQUE_GROUP = 4000701031L;
    public static final long GROUP_EXCEEDS_LIMIT_NUMBER_MEMBERS = 4000701032L;
    public static final long GROUP_FAIL_TO_GENERATE_GROUP_ID = 5000701002L;
    public static final long GROUP_GROUP_DATABASE_ERROR = 5000701011L;
    public static final long GROUP_INTERNAL_SERVER_ERROR = 5000701999L;
    public static final long GROUP_INVALID_ACTION_RESPONSE = 4000701023L;
    public static final long GROUP_INVALID_GROUP_ID = 4000701003L;
    public static final long GROUP_INVALID_GROUP_TYPE = 4000701004L;
    public static final long GROUP_INVALID_MEMBER_ID = 4000701005L;
    public static final long GROUP_INVALID_MSISDN_FORMAT = 4000701006L;
    public static final long GROUP_MEMBER_DATABASE_ERROR = 5000701012L;
    public static final long GROUP_PARAMETER_BAD_FORMAT = 4000701002L;
    public static final long GROUP_PARAMETER_REQUIRED = 4000701001L;
    public static final long GROUP_PERMISSION_ERROR = 4000701033L;
    public static final long GROUP_PUSH_REQUEST_FAILED = 5000701001L;
    public static final long GROUP_REQUEST_BODY_BAD_FORMAT = 4000701022L;
    public static final long GROUP_REQUEST_BODY_REQUIRED = 4000701021L;
    public static final long GROUP_REQUIRED_HEADER = 4000701011L;
    public static final long GROUP_RESOURCE_NOT_FOUND = 4000701051L;
    public static final long GROUP_TYPE_MISMATCH = 4000701042L;
    public static final String ID_CHANGED = "AUT_1302";
    public static final String INCORRECT_PASSWORD = "SAC_0207";
    public static final String INCORRECT_USER_AUTH_TOKEN = "AUT_1094";
    public static final String INTERNAL_ERROR = "SAC_0401";
    public static final String INVALID_AUTHORIZATION_IN_HTTP_HEADER = "ACF_0403";
    public static final String INVALID_DEVICE_ID = "SAC_0502";
    public static final String INVALID_PARAMETER = "SAC_0101";
    public static final String INVALID_SIGNATURE = "SAC_0205";
    public static final String IVALID_PASSWORD_LENGTH = "USR_1312";
    public static final String NEED_EMAIL_VALIDATION = "SAC_0108";
    public static final String NETWORK_NOT_AVAILABLE = "SAC_0301";
    public static final String NOT_DISCLAIMER_AGGREMENT = "SAC_0206";
    public static final String NOT_REGISTER_COMPLETED = "SAC_0204";
    public static final String NOT_SIGN_IN = "SAC_0102";
    public static final String PLACE_DUPLICATED = "USR_3240";
    public static final String PLACE_LIMIT_EXCEEDED = "USR_3222";
    public static final String POLICY_INVALID_APP_ID = "4000500012";
    public static final String POLICY_NOT_SUPPORTED_APP_ID = "4000500013";
    public static final String POLICY_NOT_SUPPORTED_APP_VERSION = "4000500016";
    public static final String POLICY_NOT_SUPPORTED_CARRIER = "4000500022";
    public static final String POLICY_NOT_SUPPORTED_COUNTRY = "4000500021";
    public static final String POLICY_NOT_SUPPORTED_DEFAULT_APP_VERSION = "4000500015";
    public static final String PROFILE_ALREADY_UPDATED = "SAC_0601";
    public static final long RESOURCE_NOT_FOUND = 1018;
    public static final String SCLOUD_DELETED_USER = "49201";
    public static final String SCLOUD_INACTIVE_USER_APP_SERVICE = "49206";
    public static final String SCLOUD_INVALID_USER = "49202";
    public static final String SCLOUD_USER_NOT_EXIST = "49203";
    public static final String SCLOUD_USER_STATUS_CHANGE_NOT_PERMITTED = "29208";
    public static final long SHARE_BACKEND_SERVER_ERROR = 112501;
    public static final long SHARE_BAD_REQUEST = 112400;
    public static final long SHARE_DATABASE_ERROR = 112502;
    public static final long SHARE_FEEDBACK_NOT_FOUND = 112407;
    public static final long SHARE_INTERNAL_SERVER_ERROR = 112500;
    public static final long SHARE_ITEM_NOT_FOUND = 112406;
    public static final long SHARE_JSON_FORMAT = 112404;
    public static final long SHARE_REQUEST_PARAMETER_INVALID = 112403;
    public static final long SHARE_REQUEST_PARAMETER_REQUIRED = 112402;
    public static final long SHARE_SPACE_NOT_FOUND = 112405;
    public static final long SHARE_UNAUTHORIZED = 112401;
    public static final int SIM_STATE_ABSENT = 101;
    public static final long SOCIAL_SERVICE_WITHDRAWAL = 102202;
    public static final String SSL_CONNECTION_ERROR = "SAC_0302";
    private static final String TAG = "ErrorCodeConvertor";
    public static final int TEMP_AGENT_DATABASE_ERROR = 1008;
    public static final int TEMP_AGENT_DEVICE_ALREADY_AUTHENTICATED = 1003;
    public static final int TEMP_AGENT_DEVICE_NOT_AUTHENTICATE = 1001;
    public static final int TEMP_AGENT_DEVICE_PERMISSIONS_DENIED = 1004;
    public static final int TEMP_AGENT_FILE_IO_ERROR = 1009;
    public static final int TEMP_AGENT_INTERNAL_ERROR = 1007;
    public static final int TEMP_AGENT_INVALID_MSISDN = 1011;
    public static final int TEMP_AGENT_INVALID_PARAMETER = 1006;
    public static final int TEMP_AGENT_NETWORK_UNAVAILABLE = 1005;
    public static final int TEMP_AGENT_NOT_ACTIVATED = 1012;
    public static final int TEMP_AGENT_NOT_USER_OWNER = 1013;
    public static final int TEMP_AGENT_SERVICE_DISABLED = 1010;
    public static final int TEMP_AGENT_SIM_STATE_ABSENT = 1002;
    public static final int TEMP_AGENT_UNKNOWN_ERROR = 1000;
    public static final int TEMP_AGENT_VOLLEY_CANCELED = 1014;
    public static final int TEMP_AGENT_VOLLEY_INTERNAL_NETWORK = 1016;
    public static final int TEMP_AGENT_VOLLEY_NETWORK_TIMEOUT = 1015;
    public static final int TEMP_AGENT_VOLLEY_PARSING = 1017;
    public static final int TEMP_AGENT_WIFI_ONLY_MODEL = 1031;
    public static final int TEMP_ERROR_SOCIAL_DISCLAIMER_AGREEMENT_NEEDED = 1039;
    public static final int TEMP_ERROR_SOCIAL_SERVICE_NOT_AVAILABLE = 1037;
    public static final int TEMP_ERROR_SOCIAL_SERVICE_TERMINATED = 1038;
    public static final int TEMP_GDPR_DELETED_ERROR = 101903;
    public static final int TEMP_GDPR_PROCESSED_ERROR = 101901;
    public static final int TEMP_GDPR_RESTRICTED_ERROR = 101902;
    public static final int TEMP_HEADER_REQUIRED = 101021;
    public static final int TEMP_INTERNAL_SERVER_ERROR = 5000100;
    public static final int TEMP_INVALID_AUTHORIZATION = 100103;
    public static final int TEMP_INVALID_CONTACT_TOKEN = 100105;
    public static final int TEMP_INVALID_PARAMETER = 100000;
    public static final int TEMP_INVALID_TOKEN_REQUEST = 100104;
    public static final int TEMP_JSON_MAPPING_ERROR = 100001;
    public static final int TEMP_NOT_REGISTERED_USER = 100002;
    public static final int TEMP_NOT_REGISTERED_USER2 = 100100;
    public static final int TEMP_RESOURCE_NOT_FOUND = 1018;
    public static final int TEMP_SOCIAL_SERVICE_WITHDRAWAL = 102202;
    public static final int UNKNOWN_ERROR = -1;
    public static final String UNKNOWN_SERVER_ERROR = "SAC_0303";
    private static HashMap<String, Integer> errorMap = new HashMap<>();
    private static HashMap<Integer, Integer> errorMapInteger = new HashMap<>();
    private static HashMap<Long, Integer> errorMapLong = new HashMap<>();

    static {
        errorMap.put(INVALID_PARAMETER, 101);
        errorMap.put(NOT_SIGN_IN, 10);
        errorMap.put(CALLER_NOT_ACTIVITY, 102);
        errorMap.put(NEED_EMAIL_VALIDATION, 13);
        errorMap.put(NOT_REGISTER_COMPLETED, 1000);
        errorMap.put(INVALID_SIGNATURE, 17);
        errorMap.put(NOT_DISCLAIMER_AGGREMENT, 1004);
        errorMap.put(INCORRECT_PASSWORD, 1005);
        errorMap.put(NETWORK_NOT_AVAILABLE, 103);
        errorMap.put(SSL_CONNECTION_ERROR, 103);
        errorMap.put(UNKNOWN_SERVER_ERROR, -4);
        errorMap.put(INTERNAL_ERROR, -4);
        errorMap.put(AUTH_TOKEN_EXPIRED, 14);
        errorMap.put(DUPLICATE_REQUEST, 104);
        errorMap.put(INVALID_DEVICE_ID, 101);
        errorMap.put(INCORRECT_USER_AUTH_TOKEN, 14);
        errorMap.put(ID_CHANGED, 1008);
        errorMap.put(IVALID_PASSWORD_LENGTH, 1005);
        errorMap.put(PLACE_LIMIT_EXCEEDED, 2000);
        errorMap.put(PLACE_DUPLICATED, 2001);
        errorMap.put(SCLOUD_DELETED_USER, 102);
        errorMap.put(SCLOUD_INVALID_USER, 102);
        errorMap.put(SCLOUD_USER_NOT_EXIST, 102);
        errorMap.put(SCLOUD_INACTIVE_USER_APP_SERVICE, 102);
        errorMap.put(SCLOUD_USER_STATUS_CHANGE_NOT_PERMITTED, 102);
        errorMap.put(POLICY_INVALID_APP_ID, 101);
        errorMap.put(POLICY_NOT_SUPPORTED_APP_ID, 101);
        errorMap.put(POLICY_NOT_SUPPORTED_DEFAULT_APP_VERSION, 200);
        errorMap.put(POLICY_NOT_SUPPORTED_APP_VERSION, 200);
        errorMap.put(POLICY_NOT_SUPPORTED_COUNTRY, Integer.valueOf(CommonStatusCodes.NOT_SUPPORTED_COUNTRY));
        errorMap.put(POLICY_NOT_SUPPORTED_CARRIER, Integer.valueOf(CommonStatusCodes.NOT_SUPPORTED_CARRIER));
        errorMap.put(PROFILE_ALREADY_UPDATED, 2002);
        errorMap.put(INVALID_AUTHORIZATION_IN_HTTP_HEADER, 105);
        errorMapInteger.put(-1, -2);
        errorMapInteger.put(100, 11);
        errorMapInteger.put(101, 16);
        errorMapInteger.put(103, 12);
        errorMapInteger.put(104, 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_UID_VALIDATION), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_UID_VALIDATION2), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_DEVICE_ID_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_DEVICE_ID_BAD_FORMAT), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_BAD_ACCESS_TOKEN), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_BAD_ACCESS_TOKEN2), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_BAD_ACCESS_TOKEN3), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_REQUEST_DORMANT_USER), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_BAD_JSON_FORMAT), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_DELETING_USER_DATA), 102);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_APPID_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_APPID_UNSUPPORTED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_APPID_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_APPID_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_TOKEN_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_TOKEN_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_TYPE_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_TYPE_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_MODEL_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_MODEL_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_INFO_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PUSH_INFO_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_INFO_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_INFO_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_OS_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_OS_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_TYPE_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_TYPE_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_OS_VER_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DEVICE_OS_VER_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_CA_DEVICE_ID_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_REGISTER_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_REGISTER_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_MNC_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_GCID_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_GCID_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DATA_CLEAR_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_DATA_CLEAR_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PHYSICAL_DEVICE_ID_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_PHYSICAL_DEVICE_ID_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_HEADER_HASH_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_HEADER_HASH_INVALID), 101);
        errorMapInteger.put(Integer.valueOf(CLOUD_DELETED_USER), 105);
        errorMapInteger.put(Integer.valueOf(CLOUD_INVALID_USER), 105);
        errorMapInteger.put(Integer.valueOf(CLOUD_USER_NOT_EXIST), 105);
        errorMapInteger.put(Integer.valueOf(CLOUD_INACTIVE_USER_APP_SERVICE), 105);
        errorMapInteger.put(Integer.valueOf(CLOUD_CANNOT_CHANGE_USER_STATUS), 105);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_QUOTA), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_ACCOUNT), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_CHATON), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_CACHE), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_TIMEOUT), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_CASSANDRA), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_REDIS), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_QUOTA_TIMEOUT), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_INTERNAL_SERVER_ERROR_GLOBAL), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_TEMPORARILY_UNAVAILABLE_MIGRATION), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_LOCK_SERVER_FAILED), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_HEADER_REQUIRED), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_HEADER_BAD_FORMAT), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_REQUEST_BODY_REQUIRED), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_REQUEST_BODY_BAD_FORMAT), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_PARAM_INVALID), -4);
        errorMapInteger.put(Integer.valueOf(CLOUD_FILE_NOT_EXIST), 107);
        errorMapInteger.put(Integer.valueOf(TEMP_INVALID_PARAMETER), 101);
        errorMapInteger.put(Integer.valueOf(TEMP_JSON_MAPPING_ERROR), 101);
        errorMapInteger.put(Integer.valueOf(TEMP_NOT_REGISTERED_USER), 105);
        errorMapInteger.put(Integer.valueOf(TEMP_NOT_REGISTERED_USER2), 105);
        errorMapInteger.put(Integer.valueOf(TEMP_INVALID_AUTHORIZATION), 105);
        errorMapInteger.put(Integer.valueOf(TEMP_INVALID_TOKEN_REQUEST), 102);
        errorMapInteger.put(Integer.valueOf(TEMP_INVALID_CONTACT_TOKEN), 102);
        errorMapInteger.put(Integer.valueOf(TEMP_HEADER_REQUIRED), 101);
        errorMapInteger.put(Integer.valueOf(TEMP_INTERNAL_SERVER_ERROR), -4);
        errorMapInteger.put(1000, -2);
        errorMapInteger.put(1001, 11);
        errorMapInteger.put(1002, 16);
        errorMapInteger.put(1003, 12);
        errorMapInteger.put(1004, 102);
        errorMapInteger.put(1005, 103);
        errorMapInteger.put(1006, 101);
        errorMapInteger.put(1007, 301);
        errorMapInteger.put(1008, 301);
        errorMapInteger.put(1009, 301);
        errorMapInteger.put(1010, 6);
        errorMapInteger.put(1011, 105);
        errorMapInteger.put(1012, 7);
        errorMapInteger.put(1013, 105);
        errorMapInteger.put(1014, 106);
        errorMapInteger.put(1015, 103);
        errorMapInteger.put(1016, 103);
        errorMapInteger.put(1017, 101);
        errorMapInteger.put(1018, 107);
        errorMapInteger.put(400, 103);
        errorMapInteger.put(Integer.valueOf(TEMP_AGENT_WIFI_ONLY_MODEL), 18);
        errorMapInteger.put(Integer.valueOf(TEMP_GDPR_PROCESSED_ERROR), 112);
        errorMapInteger.put(Integer.valueOf(TEMP_GDPR_RESTRICTED_ERROR), 112);
        errorMapInteger.put(Integer.valueOf(TEMP_GDPR_DELETED_ERROR), 112);
        errorMapInteger.put(Integer.valueOf(TEMP_SOCIAL_SERVICE_WITHDRAWAL), 122);
        errorMapInteger.put(Integer.valueOf(TEMP_ERROR_SOCIAL_SERVICE_NOT_AVAILABLE), 121);
        errorMapInteger.put(Integer.valueOf(TEMP_ERROR_SOCIAL_SERVICE_TERMINATED), 121);
        errorMapInteger.put(Integer.valueOf(TEMP_ERROR_SOCIAL_DISCLAIMER_AGREEMENT_NEEDED), 120);
        errorMapLong.put(-1L, -2);
        errorMapLong.put(100L, 11);
        errorMapLong.put(101L, 16);
        errorMapLong.put(103L, 12);
        errorMapLong.put(104L, 102);
        errorMapLong.put(19000L, 102);
        errorMapLong.put(19001L, 102);
        errorMapLong.put(19004L, 101);
        errorMapLong.put(19005L, 101);
        errorMapLong.put(19008L, 102);
        errorMapLong.put(19018L, 102);
        errorMapLong.put(19019L, 102);
        errorMapLong.put(19012L, 102);
        errorMapLong.put(19700L, 101);
        errorMapLong.put(49702L, 102);
        errorMapLong.put(49010L, 101);
        errorMapLong.put(49011L, 101);
        errorMapLong.put(49101L, 101);
        errorMapLong.put(49102L, 101);
        errorMapLong.put(49103L, 101);
        errorMapLong.put(49104L, 101);
        errorMapLong.put(49105L, 101);
        errorMapLong.put(49106L, 101);
        errorMapLong.put(49109L, 101);
        errorMapLong.put(49110L, 101);
        errorMapLong.put(49126L, 101);
        errorMapLong.put(49127L, 101);
        errorMapLong.put(49128L, 101);
        errorMapLong.put(49129L, 101);
        errorMapLong.put(49130L, 101);
        errorMapLong.put(49131L, 101);
        errorMapLong.put(49132L, 101);
        errorMapLong.put(49133L, 101);
        errorMapLong.put(49134L, 101);
        errorMapLong.put(49135L, 101);
        errorMapLong.put(49136L, 101);
        errorMapLong.put(49145L, 101);
        errorMapLong.put(49146L, 101);
        errorMapLong.put(49151L, 101);
        errorMapLong.put(49160L, 101);
        errorMapLong.put(49161L, 101);
        errorMapLong.put(49162L, 101);
        errorMapLong.put(49163L, 101);
        errorMapLong.put(49166L, 101);
        errorMapLong.put(49167L, 101);
        errorMapLong.put(69013L, 101);
        errorMapLong.put(69014L, 101);
        errorMapLong.put(49201L, 105);
        errorMapLong.put(49202L, 105);
        errorMapLong.put(49203L, 105);
        errorMapLong.put(49206L, 105);
        errorMapLong.put(49208L, 105);
        errorMapLong.put(49500L, -4);
        errorMapLong.put(49501L, -4);
        errorMapLong.put(49502L, -4);
        errorMapLong.put(49503L, -4);
        errorMapLong.put(49504L, -4);
        errorMapLong.put(49505L, -4);
        errorMapLong.put(49511L, -4);
        errorMapLong.put(49512L, -4);
        errorMapLong.put(49513L, -4);
        errorMapLong.put(49514L, -4);
        errorMapLong.put(99001L, -4);
        errorMapLong.put(99002L, -4);
        errorMapLong.put(102103L, -4);
        errorMapLong.put(102104L, -4);
        errorMapLong.put(102105L, -4);
        errorMapLong.put(102106L, -4);
        errorMapLong.put(102107L, -4);
        errorMapLong.put(108305L, 107);
        errorMapLong.put(100000L, 101);
        errorMapLong.put(100001L, 101);
        errorMapLong.put(100002L, 105);
        errorMapLong.put(100100L, 105);
        errorMapLong.put(100103L, 105);
        errorMapLong.put(100104L, 102);
        errorMapLong.put(100105L, 102);
        errorMapLong.put(101021L, 101);
        errorMapLong.put(5000100L, -4);
        errorMapLong.put(Long.valueOf(CLOUD_OUT_OF_STORAGE), 109);
        errorMapLong.put(Long.valueOf(COMMON_INVALID_PARAMETER), 101);
        errorMapLong.put(Long.valueOf(COMMON_JSON_MAPPING_ERROR), 101);
        errorMapLong.put(Long.valueOf(COMMON_NOT_REGISTERED_USER), 105);
        errorMapLong.put(Long.valueOf(COMMON_NOT_REGISTERED_USER2), 105);
        errorMapLong.put(Long.valueOf(COMMON_INVALID_AUTHORIZATION), 105);
        errorMapLong.put(Long.valueOf(COMMON_INVALID_TOKEN_REQUEST), 102);
        errorMapLong.put(Long.valueOf(COMMON_INVALID_CONTACT_TOKEN), 102);
        errorMapLong.put(Long.valueOf(COMMON_HEADER_REQUIRED), 101);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_DB), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_CASSANDRA), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_MSISDN), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_READ_CALL_PROFILE), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_PROFILE), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_WRITE_CALL_PROFILE), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_PROFILE_TYPE), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_USER_INFO), -4);
        errorMapLong.put(Long.valueOf(COMMON_INTERNAL_SERVER_ERROR_UNKNOWN), -4);
        errorMapLong.put(1000L, -2);
        errorMapLong.put(Long.valueOf(AGENT_DEVICE_NOT_AUTHENTICATE), 11);
        errorMapLong.put(Long.valueOf(AGENT_SIM_STATE_ABSENT), 16);
        errorMapLong.put(Long.valueOf(AGENT_DEVICE_ALREADY_AUTHENTICATED), 12);
        errorMapLong.put(Long.valueOf(AGENT_DEVICE_PERMISSIONS_DENIED), 102);
        errorMapLong.put(Long.valueOf(AGENT_NETWORK_UNAVAILABLE), 103);
        errorMapLong.put(Long.valueOf(AGENT_INVALID_PARAMETER), 101);
        errorMapLong.put(Long.valueOf(AGENT_INTERNAL_ERROR), 301);
        errorMapLong.put(Long.valueOf(AGENT_DATABASE_ERROR), 301);
        errorMapLong.put(Long.valueOf(AGENT_FILE_IO_ERROR), 301);
        errorMapLong.put(Long.valueOf(AGENT_SERVICE_DISABLED), 6);
        errorMapLong.put(Long.valueOf(AGENT_INVALID_MSISDN), 105);
        errorMapLong.put(Long.valueOf(AGENT_NOT_ACTIVATED), 7);
        errorMapLong.put(Long.valueOf(AGENT_NOT_USER_OWNER), -5);
        errorMapLong.put(Long.valueOf(AGENT_VOLLEY_CANCELED), 106);
        errorMapLong.put(Long.valueOf(AGENT_VOLLEY_NETWORK_TIMEOUT), 103);
        errorMapLong.put(Long.valueOf(AGENT_VOLLEY_INTERNAL_NETWORK), 103);
        errorMapLong.put(Long.valueOf(AGENT_VOLLEY_PARSING), 101);
        errorMapLong.put(Long.valueOf(RESOURCE_NOT_FOUND), 107);
        errorMapLong.put(Long.valueOf(ERROR_AGENT_TASK_CANCELED), 106);
        errorMapLong.put(Long.valueOf(ERROR_INVALID_ACCESSTOKEN), 14);
        errorMapLong.put(Long.valueOf(ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED), 108);
        errorMapLong.put(1024L, -6);
        errorMapLong.put(Long.valueOf(ERROR_QUOTA_IS_EXEED), 109);
        errorMapLong.put(Long.valueOf(ERROR_SPACE_DELETED_BY_OTHER), 107);
        errorMapLong.put(Long.valueOf(ERROR_SPACE_DELETED_BY_ME), 107);
        errorMapLong.put(Long.valueOf(ERROR_TASK_PAUSED), 111);
        errorMapLong.put(Long.valueOf(ERROR_GROUP_STATUS_CHANGED), 110);
        errorMapLong.put(Long.valueOf(AGENT_WIFI_ONLY_MODEL), 18);
        errorMapLong.put(Long.valueOf(ERROR_FILE_IS_TOO_LARGE), 113);
        errorMapLong.put(Long.valueOf(ERROR_ITEM_IS_DELETED), 114);
        errorMapLong.put(Long.valueOf(ERROR_LACK_OF_DEVICE_STORAGE), Integer.valueOf(CommonStatusCodes.DEVICE_OUT_OF_STORAGE));
        errorMapLong.put(Long.valueOf(SHARE_BAD_REQUEST), 101);
        errorMapLong.put(Long.valueOf(SHARE_UNAUTHORIZED), 101);
        errorMapLong.put(Long.valueOf(SHARE_REQUEST_PARAMETER_REQUIRED), 101);
        errorMapLong.put(Long.valueOf(SHARE_REQUEST_PARAMETER_INVALID), 101);
        errorMapLong.put(Long.valueOf(SHARE_JSON_FORMAT), 101);
        errorMapLong.put(Long.valueOf(SHARE_SPACE_NOT_FOUND), 101);
        errorMapLong.put(Long.valueOf(SHARE_ITEM_NOT_FOUND), 101);
        errorMapLong.put(Long.valueOf(SHARE_FEEDBACK_NOT_FOUND), 101);
        errorMapLong.put(Long.valueOf(SHARE_INTERNAL_SERVER_ERROR), -4);
        errorMapLong.put(Long.valueOf(SHARE_BACKEND_SERVER_ERROR), -4);
        errorMapLong.put(Long.valueOf(SHARE_DATABASE_ERROR), -4);
        errorMapLong.put(Long.valueOf(GDPR_PROCESSED_ERROR), 112);
        errorMapLong.put(Long.valueOf(GDPR_RESTRICTED_ERROR), 112);
        errorMapLong.put(Long.valueOf(GDPR_DELETED_ERROR), 112);
        errorMapLong.put(Long.valueOf(SOCIAL_SERVICE_WITHDRAWAL), 122);
        errorMapLong.put(Long.valueOf(GROUP_PARAMETER_REQUIRED), 101);
        errorMapLong.put(Long.valueOf(GROUP_PARAMETER_BAD_FORMAT), 101);
        errorMapLong.put(Long.valueOf(GROUP_INVALID_GROUP_ID), 101);
        errorMapLong.put(Long.valueOf(GROUP_INVALID_GROUP_TYPE), 101);
        errorMapLong.put(Long.valueOf(GROUP_INVALID_MEMBER_ID), 101);
        errorMapLong.put(Long.valueOf(GROUP_INVALID_MSISDN_FORMAT), 101);
        errorMapLong.put(Long.valueOf(GROUP_REQUIRED_HEADER), 101);
        errorMapLong.put(Long.valueOf(GROUP_REQUEST_BODY_REQUIRED), 101);
        errorMapLong.put(Long.valueOf(GROUP_REQUEST_BODY_BAD_FORMAT), 101);
        errorMapLong.put(Long.valueOf(GROUP_INVALID_ACTION_RESPONSE), 101);
        errorMapLong.put(Long.valueOf(GROUP_EXCEEDS_LIMIT_NUMBER_GROUPS_OR_ALREADY_JOINED_ANOTHER_UNIQUE_GROUP), 101);
        errorMapLong.put(Long.valueOf(GROUP_EXCEEDS_LIMIT_NUMBER_MEMBERS), 101);
        errorMapLong.put(Long.valueOf(GROUP_PERMISSION_ERROR), 101);
        errorMapLong.put(Long.valueOf(GROUP_ALREADY_ACCEPTED), 115);
        errorMapLong.put(Long.valueOf(GROUP_CANNOT_CHANGE_UNIQUE_GROUP_NAME), 101);
        errorMapLong.put(Long.valueOf(GROUP_BAD_JSON_FORMAT), 101);
        errorMapLong.put(Long.valueOf(GROUP_TYPE_MISMATCH), 101);
        errorMapLong.put(Long.valueOf(GROUP_RESOURCE_NOT_FOUND), 101);
        errorMapLong.put(Long.valueOf(GROUP_PUSH_REQUEST_FAILED), -4);
        errorMapLong.put(Long.valueOf(GROUP_FAIL_TO_GENERATE_GROUP_ID), -4);
        errorMapLong.put(Long.valueOf(GROUP_GROUP_DATABASE_ERROR), -4);
        errorMapLong.put(Long.valueOf(GROUP_MEMBER_DATABASE_ERROR), -4);
        errorMapLong.put(Long.valueOf(GROUP_INTERNAL_SERVER_ERROR), -4);
        errorMapLong.put(Long.valueOf(ACTIVITY_UNAUTHORIZED_CONTENTS), 119);
        errorMapLong.put(Long.valueOf(FEEDBACK_PERMISSION_DENIED), 119);
        errorMapLong.put(Long.valueOf(FEEDBACK_EMOTION_ALREADY_CANCELED), 118);
        errorMapLong.put(Long.valueOf(FEEDBACK_EMOTION_ALREADY_UPDATED), 118);
        errorMapLong.put(Long.valueOf(FEEDBACK_INVALID_COMMENT_ID), 116);
        errorMapLong.put(Long.valueOf(FEEDBACK_INVALID_ACTIVITY_ID), 117);
        errorMapLong.put(Long.valueOf(ERROR_SOCIAL_SERVICE_NOT_AVAILABLE), 121);
        errorMapLong.put(Long.valueOf(ERROR_SOCIAL_SERVICE_TERMINATED), 121);
        errorMapLong.put(Long.valueOf(ERROR_SOCIAL_DISCLAIMER_AGREEMENT_NEEDED), 120);
        errorMapLong.put(Long.valueOf(ERROR_SOCIAL_SERVICE_WITHDRAWAL), 122);
        errorMapLong.put(Long.valueOf(ERROR_RESULT_NOT_FOUND), 400);
    }

    private ErrorCodeConvertor() {
    }

    public static int convertErrorcode(String str) {
        int i = -2;
        if (errorMap.containsKey(str)) {
            i = errorMap.get(str).intValue();
        } else if (str.length() == 8 || str.length() == 10) {
            try {
                int parseInt = Integer.parseInt(str.substring(0, 3));
                if (parseInt >= 400 && parseInt < 500) {
                    i = 100;
                } else if (parseInt >= 500) {
                    i = -4;
                }
            } catch (NumberFormatException unused) {
            }
        }
        SdkLog.d(TAG, "convertErrorcode : code = [" + str + "], ret = [" + i + "]");
        return i;
    }

    public static int convertErrorcode(int i) {
        int i2 = -2;
        if (errorMapInteger.containsKey(Integer.valueOf(i))) {
            i2 = errorMapInteger.get(Integer.valueOf(i)).intValue();
        } else {
            String num = Integer.toString(i);
            if (num.length() == 8 || num.length() == 10) {
                try {
                    int parseInt = Integer.parseInt(Integer.toString(i).substring(0, 3));
                    if (parseInt >= 400 && parseInt < 500) {
                        i2 = 100;
                    } else if (parseInt >= 500) {
                        i2 = -4;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        SdkLog.d(TAG, "convertErrorcode : code = [" + i + "], ret = [" + i2 + "]");
        return i2;
    }

    public static int convertErrorcode(long j) {
        int i = -2;
        if (errorMapLong.containsKey(Long.valueOf(j))) {
            i = errorMapLong.get(Long.valueOf(j)).intValue();
        } else {
            String l = Long.toString(j);
            if (l.length() == 8 || l.length() == 10) {
                try {
                    int parseInt = Integer.parseInt(l.substring(0, 3));
                    if (parseInt >= 400 && parseInt < 500) {
                        i = 100;
                    } else if (parseInt >= 500) {
                        i = -4;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        SdkLog.d(TAG, "convertErrorcode : code = [" + j + "], ret = [" + i + "]");
        return i;
    }
}
