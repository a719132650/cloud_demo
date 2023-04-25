package org.example.common.enums;

/**
 * @author
 */
public enum Dict {
    SERVICE_USER("sys-user","用户模块"),
    SERVICE_GATEWAY("sys-gateway","网关模块"),
    SERVICE_COMMON("sys-common","通用模块"),
    SERVICE_DEMO("sys-service","业务服务示例");



    private String value;
    private String desc;

    Dict(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
