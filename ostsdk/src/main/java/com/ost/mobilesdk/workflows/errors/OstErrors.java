package com.ost.mobilesdk.workflows.errors;

import android.util.Log;

import com.ost.mobilesdk.OstConstants;

public class OstErrors {
    private static String TAG = "OstErrors";

    public static String getMessage(ErrorCode code) {
        switch (code) {
            case INVALID_USER_ID: return "Invalid user Id";
            case INVALID_WORKFLOW_CALLBACK: return "Invalid Workflow Callback. Workflow callback can not be null.";
            case GET_USER_API_FAILED:
                return "Failed to fetch user information";

            case SALT_API_FAILED:
                return "Failed to fetch user salt";

            case TOKEN_API_FAILED:
                return "Failed to fetch token information";

            case CHAIN_API_FAILED:
                return "Failed to fetch block-chain information";

            case RULES_API_FAILED:return "Failed to fetch rule information";

            case GET_DEVICE_API_FAILED: return "Failed to fetch device Information";

            case DEVICE_MANAGER_API_FAILED: return "Failed to fetch device manager information";

            case INVALID_WORKFLOW_PARAMS:
                return "Invalid workflow params";

            case CREATE_DEVICE_FAILED:
                return "Failed to create device.";

            case ACTIVATE_USER_API_FAILED:
                return "Something went wrong while activating user";

            case ACTIVATE_USER_API_POLLING_FAILED:
                return "Something went wrong while activating user";

            case DEVICE_NOT_SETUP:
                return "Device not registered";

            case USER_NOT_ACTIVATED:
                return "User not activated";

            case POLLING_TIMEOUT:
                return "Polling timeout";

            case ADD_DEVICE_API_FAILED:
                return "Add device api failed";

            case BLOCK_NUMBER_API_FAILED:
                return "Block number api failed";

            case EIP712_FAILED:
                return "EIP712 failed";

            case NO_SESSION_FOUND:
                return "No Session found";

            case TRANSACTION_API_FAILED:
                return "Transaction api failed";

            case RULE_NOT_FOUND:
                return "Rule not found";

            case DIFFERENT_ECONOMY:
                return "Token Id is different";

            case USER_NOT_FOUND:
                return "User not found";

            case CURRENT_DEVICE_NOT_FOUND:
                return "Current device for user not found";

            case POLLING_API_FAILED:
                return "Polling api failed";

            case UNKNOWN_ENTITY_TYPE:
                return "Unknown entity type";

            case INVALID_QR_DEVICE_OPERATION_DATA:
                return "Invalid qr device operation data";

            case INVALID_ADD_DEVICE_ADDRESS:
                return "Invalid add device address";

            case INVALID_RECOVER_DEVICE_ADDRESS:return "Invalid device address. This address can not be recovered.";

            case DEVICE_UNAUTHORIZED:
                return "Device unauthorized";

            case DEVICE_ALREADY_AUTHORIZED:
                return "Device already authorized";

            case USER_ALREADY_ACTIVATED:
                return "User already activated";

            case INVALID_MNEMONICS:
                return "Mnemonics are invalid";

            case INVALID_QR_TRANSACTION_DATA:
                return "Invalid qr transaction data";

            case INVALID_USER_PASSPHRASE:
                return "Pin is Invalid";

            case INVALID_NEW_USER_PASSPHRASE:
                return "Pin is Invalid";


            case MAX_PASSPHRASE_VERIFICATION_LIMIT_REACHED:
                return "Max pin ask limit reached";

            case RECOVERY_PASSPHRASE_OWNER_NOT_SET: return "Recovery owner is not set for this user";

            case RECOVERY_KEY_GENERATION_FAILED: return "Failed to generate Recovery key";

            case POST_RESET_RECOVERY_API_FAILED:
                return "Reset Recovery api failed";

            case POST_RECOVER_DEVICE_API_FAILED: return "Recover Device API failed";

            case POST_ABORT_RECOVER_DEVICE_API_FAILED: return "Abort Recover Device API failed";

            case UNCAUGHT_EXCEPTION_HANDELED: return "Uncaught exception handeled";

            case INSUFFICIENT_DATA: return "The device does not have sufficient data to perform this action.";

            case DEPRECATED: return "The method has been deprecated";

            case SESSION_KEY_GENERATION_FAILED: return "Failed to create new session key";

            case FAILED_TO_GENERATE_MESSAGE_HASH: return "Failed to generate message hash needed to complete the action";

            case INVALID_SESSION_ADDRESS: return "Invalid session address";

            case FAILED_TO_SIGN_DATA: return "Failed to sign data.";

            case DEVICE_CAN_NOT_BE_AUTHORIZED: return "Current device can not be authorized. Only devices with status 'Registered' can be authorized.";

            case FAILED_TO_GENERATE_ETH_KEY: return "Failed to generate ethereum key.";

            case INVALID_PASSPHRASE_PREFIX: return "Invalid Passphrase prefix. Passphrase prefix should be atleast " + OstConstants.RECOVERY_PHRASE_PREFIX_MIN_LENGTH + " long";

            case USER_ACTIVATING: return "User is already activating.";

            case USER_PASSPHRASE_VALIDATION_LOCKED: return "Can not validate user passphrase because of too many wrong attempts.";

            case EIP1077_FAILED:
                return "EIP1077 failed";

            case UNKNOWN_RULE_NAME:
                return "Unknown rule name";

            case PRICE_POINTS_API_FAILED:
                return "Price points api failed";

            case WORKFLOW_CANCELLED:return "Workflow cancelled";
            case UNKNOWN_DATA_DEFINITION: return "The QR code does not contain valid data definition";
            //Important Note for P.M.:
            //This is a special case. Do not add return in front of UNKNOWN:
            case UNKNOWN:
            default: {
                Log.e(TAG, "Error message not defined for error code " + code.name());
                return "Unknown error";
            }
        }
    }

    public enum ErrorCode {
        INVALID_USER_ID,
        INVALID_WORKFLOW_CALLBACK,
        GET_USER_API_FAILED,
        TOKEN_API_FAILED,
        GET_DEVICE_API_FAILED,
        CHAIN_API_FAILED,
        SALT_API_FAILED,
        DEVICE_MANAGER_API_FAILED,
        RULES_API_FAILED,

        INVALID_WORKFLOW_PARAMS,
        CREATE_DEVICE_FAILED,
        ACTIVATE_USER_API_FAILED,
        ACTIVATE_USER_API_POLLING_FAILED,

        DEVICE_NOT_SETUP,

        USER_NOT_ACTIVATED,
        POLLING_TIMEOUT,
        BLOCK_NUMBER_API_FAILED,
        ADD_DEVICE_API_FAILED,
        EIP712_FAILED,
        NO_SESSION_FOUND,
        TRANSACTION_API_FAILED,
        RULE_NOT_FOUND,
        DIFFERENT_ECONOMY,
        USER_NOT_FOUND,
        CURRENT_DEVICE_NOT_FOUND,
        POLLING_API_FAILED,
        UNKNOWN_ENTITY_TYPE,
        INVALID_QR_DEVICE_OPERATION_DATA,
        INVALID_ADD_DEVICE_ADDRESS,
        INVALID_RECOVER_DEVICE_ADDRESS,
        DEVICE_UNAUTHORIZED,
        DEVICE_ALREADY_AUTHORIZED,
        DEVICE_CAN_NOT_BE_AUTHORIZED,
        USER_ACTIVATING,
        USER_ALREADY_ACTIVATED,
        INVALID_MNEMONICS,
        INVALID_QR_TRANSACTION_DATA,
        EIP1077_FAILED,
        PRICE_POINTS_API_FAILED,
        UNKNOWN_RULE_NAME,
        UNKNOWN_DATA_DEFINITION,

        //SESSION KEY
        SESSION_KEY_GENERATION_FAILED,

        //RECOVERY KEY
        RECOVERY_PASSPHRASE_OWNER_NOT_SET,
        INVALID_USER_PASSPHRASE,
        USER_PASSPHRASE_VALIDATION_LOCKED,
        INVALID_NEW_USER_PASSPHRASE,
        INVALID_PASSPHRASE_PREFIX,

        MAX_PASSPHRASE_VERIFICATION_LIMIT_REACHED,
        RECOVERY_KEY_GENERATION_FAILED,
        POST_RESET_RECOVERY_API_FAILED,
        POST_RECOVER_DEVICE_API_FAILED,
        POST_ABORT_RECOVER_DEVICE_API_FAILED,

        //Key-Managers
        INSUFFICIENT_DATA,
        FAILED_TO_GENERATE_MESSAGE_HASH,
        INVALID_SESSION_ADDRESS,
        FAILED_TO_SIGN_DATA,

        //Generic
        UNKNOWN,
        WORKFLOW_CANCELLED,
        UNCAUGHT_EXCEPTION_HANDELED,
        DEPRECATED,
        FAILED_TO_GENERATE_ETH_KEY
    }
}
