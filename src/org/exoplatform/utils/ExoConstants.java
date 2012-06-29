package org.exoplatform.utils;

import com.cyrilmottier.android.greendroid.R;

public class ExoConstants {

  public static final String PLATFORM_EDITION              = "platformEdition";

  public static final String PLATFORM_VERSION              = "platformVersion";

  public static final String IS_MOBILE_COMPLIANT           = "isMobileCompliant";

  public static final String LOGIN_YES                     = "YES";

  public static final String LOGIN_NO                      = "NO";

  public static final String LOGIN_INVALID                 = "INVALID";

  public static final String LOGIN_UNREACHABLE             = "UNREACHABLE";

  public static final String LOGIN_ERROR                   = "ERROR";

  public static final String COMPOSE_TYPE                  = "COMPOSE_TYPE";

  public static final String SETTING_TYPE                  = "SETTING_TYPE";

  public static final String WEB_VIEW_URL                  = "WEB_VIEW_URL";

  public static final String WEB_VIEW_TITLE                = "WEB_VIEW_TITLE";

  public static final String ACTIVITY_DETAIL_EXTRA         = "ACTIVITY_DETAIL_EXTRA";

  public static final int    COMPOSE_POST_TYPE             = 0;

  public static final int    COMPOSE_COMMENT_TYPE          = 1;

  public static final int    NUMBER_OF_ACTIVITY            = 50;

  public static final int    NUMBER_OF_MORE_ACTIVITY       = 20;

  public static final int    NUMBER_OF_LIKES_PARAM         = 50;

  public static final int    NUMBER_OF_COMMENTS_PARAM      = 50;

  public static final int    NUMBER_OF_MORE_COMMENTS_PARAM = 5;

  public static final int    AVATAR_DEFAULT_SIZE           = 130;

  public static final int    TAKE_PICTURE_WITH_CAMERA      = 7;

  public static final int    REQUEST_ADD_PHOTO             = 8;

  public static final String PHOTO_ALBUM_IMAGE_TYPE        = "image/*";                                                   ;

  public static final String HTTP_PROTOCOL                 = "http";

  public static final String HTTPS_PROTOCOL                = "https";

  public static final int    ACTIVITY_PORT                 = 80;

  public static final String ACTIVITY_PORTAL_CONTAINER     = "portal";

  public static final String ACTIVITY_REST_CONTEXT         = "rest";

  public static final String ACTIVITY_REST_VERSION         = "v1-alpha2";

  public static final String ACTIVITY_ORGANIZATION         = "organization";

  public static final int    DEFAULT_AVATAR                = R.drawable.default_avatar;

  public static final String MOBILE_FOLDER                 = "Mobile";

  public static final String ACTIVITY_ID_EXTRA             = "ACTIVITY_ID_EXTRA";

  public static final String SELECTED_IMAGE_EXTRA          = "SELECTED_IMAGE_EXTRA";

  public static final String SELECTED_IMAGE_MODE           = "SELECTED_IMAGE_MODE";

  public static final String SOCIAL_LINKFY_EXTRA           = "SOCIAL_LINKFY_EXTRA";

  public static final String SOCIAL_LIKED_LIST_EXTRA       = "SOCIAL_LIKED_LIST_EXTRA";

  public static final String SOCIAL_SPACE                  = "space";

  public static final String EXO_PREFERENCE                = "exo_preference";

  public static final String EXO_PRF_DOMAIN                = "exo_prf_domain";

  public static final String EXO_PRF_DOMAIN_INDEX          = "exo_prf_domain_index";

  public static final String EXO_PRF_USERNAME              = "exo_prf_username";

  public static final String EXO_PRF_PASSWORD              = "exo_prf_password";

  public static final String EXO_PRF_LANGUAGE              = "exo_prf_language";

  public static final String EXO_PRF_LOCALIZE              = "exo_prf_localize";

  public static final String ENGLISH_LOCALIZATION          = "LocalizeEN";

  public static final String FRENCH_LOCALIZATION           = "LocalizeFR";

  public static final String DOCUMENT_PATH                 = "/rest/private/jcr/repository/collaboration/Users";

  public static final String DOCUMENT_JCR_PATH_REST        = "/rest/private/jcr/repository/collaboration";

  public static final String DOCUMENT_DRIVE_PATH_REST      = "/portal/rest/managedocument/getDrives?driveType=";

  public static final String DOCUMENT_FILE_PATH_REST       = "/portal/rest/managedocument/getFoldersAndFiles?driveName=";

  public static final String DOCUMENT_WORKSPACE_NAME       = "&workspaceName=";

  public static final String DOCUMENT_CURRENT_FOLDER       = "&currentFolder=";

  public static final String DASHBOARD_PATH                = "/rest/private/dashboards";

  public static final String DOMAIN_SUFFIX                 = "/portal/private/intranet";

  public static final String DOMAIN_SUFFIX_VERSION         = "/portal/rest/platform/info";

  public static final String IMAGE_TYPE                    = "image/png";

  public static final String SPECIAL_CHAR_NAME_SET         = "[\\[\\]\\/\\&\\~\\?\\*\\|\\<\\>\\\"\\;\\:\\+\\\\]";

  public static final String SPECIAL_CHAR_URL_SET          = "[\\[\\]\\&\\~\\?\\*\\|\\<\\>\\\"\\;\\+\\\\]";

  public static final int    HOME_AVATAR_BORDER_COLOR      = 0x44444444;

  public static final int    HOME_SOCIAL_MAX_NUMBER        = 10;

}
