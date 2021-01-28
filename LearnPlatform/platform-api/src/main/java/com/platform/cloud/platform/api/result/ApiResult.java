package com.platform.cloud.platform.api.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult<T> implements Serializable {

    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 返回的的数据
     */
    private T data;
    /**
     * 错误代码
     */
    private String errorCode;
    /**
     * 错误消息
     */
    private String errorMsg;

    // 静态方法泛型格式，在方法的返回值或者入参的地方，就可以使用"T"这个泛型
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(true, data, "", "");
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult<T>(true, null, "", "");
    }

    public static <T> ApiResult<T> error(String errorCode, String errorMsg) {
        return new ApiResult<T>(false, null, errorCode, errorMsg);
    }


}
