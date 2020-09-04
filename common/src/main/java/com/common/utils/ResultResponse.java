package com.common.utils;

import com.common.enums.ResultResponseEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description     定义统一返回信息
 * @Date 2020-08-21 16:10
 * @Author ymm
 * @Version: v1.0
 */
@Data
public class ResultResponse {

    @ApiModelProperty("状态码  200 成功")
    private Integer code;

    @ApiModelProperty("返回结果信息")
    private Object dataMsg;

    public ResultResponse(Integer code,Object dataMsg){
        this.code = code;
        this.dataMsg = dataMsg;
    }
    public ResultResponse(ResultResponseEnum resultEnum, Object dataMsg) {
        this.code = resultEnum.getCode();
        this.dataMsg = dataMsg;
    }

    public ResultResponse(ResultResponseEnum resultResponseEnum) {
        this.code = resultResponseEnum.getCode();
        this.dataMsg = resultResponseEnum.getDesc();
    }
}
