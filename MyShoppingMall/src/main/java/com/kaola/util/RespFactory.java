package com.kaola.util;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 15:04 2018/1/31
 *@Modified By:
 */

public final class RespFactory {
    private RespFactory(){}
    public static <T> GeneralResponse<T> buildFail(String message)
    {
        return new GeneralResponse<T>().setCode(GeneralResponse.Code.FAIL).setMessage(message);
    }
    public static <T> GeneralResponse<T> buildSuc(T value)
    {
        return new GeneralResponse<T>().setValue(value);
    }
}
