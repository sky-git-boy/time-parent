package com.sky.config;

/**
 * 支付宝配置类
 * @author sky
 * @create 2021-12-28 21:23
 */
public class AlipayConfig {

    //应用的ID，申请时的APPID
    public static String app_id = "2021000117690695";

    //SHA256withRsa 对应支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxSh4exiNcyC4ulypi8Sruvd0q5nmyaOoC29SnKPCNlFHzMHUAb4SFSFw3k9w8v72FemzmL34iy+ZXD+18x3r0b33lXCOlKvEZxrs7TrCj3bQ1yyL3tBhcAGw7tI/C3EpqIfGVv7WoPwG/vLY7huulrpPrq2biwcxklrRb1KU0jOBXEPjAx1hlDT0gf0x+/gMqEw9itF9h559TSHIneGacmPgwsXm2xgPDLxu3ZmsDTnpATWl7R013W78Wv25HOaMDpV1ROQBOq8WgFCm7Fv6WQWd+MHPsJJM+kbNFcMw3pqvODBE5nfgdvAVa7NdQOBNuQP6ywjXYf3IHhTPYn08nQIDAQAB";

    //签名方式
    public static String sign_type = "RSA2";

    //字码编码格式
    public static String charset = "utf-8";

    //回调地址
    public static String notifyUrl="http://139.198.122.18/member/pay/callback";
}
