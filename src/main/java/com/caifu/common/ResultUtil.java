package com.caifu.common;

/**
 * @Auther: Lyf
 * @Date: 2020/7/2 13:30
 * @Description:
 */
public class ResultUtil {

    public static Result success(String type,Object object){
        Result result = new Result();
        if("data".equals(type)) {
            result.setCode(ResultEnum.GETDATASUCCESS.getCode());
            result.setMsg(ResultEnum.GETDATASUCCESS.getMsg());
        }else{
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMsg(ResultEnum.SUCCESS.getMsg());
        }
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result getDataSuccess(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.GETDATASUCCESS.getCode());
        result.setMsg(ResultEnum.GETDATASUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(String type){
        if("data".equals(type)){
            return getDataSuccess(null);
        }else {
            return success();
        }
    }

    public static Result success(Integer code,String msg,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result success(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
