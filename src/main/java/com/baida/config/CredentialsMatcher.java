//package com.baida.config;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//
//
///**
// * 这个类进行秘密的校验
// * @author ShiQing_Chen
// * @date 2018/11/29 18:02
// */
//
//public class CredentialsMatcher extends SimpleCredentialsMatcher {
//
//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken token,
//                                      AuthenticationInfo info) {
//        UsernamePasswordToken utoken = (UsernamePasswordToken)token;
//        //获得用户输入的密码
//        String inPassword = new String(utoken.getPassword());
//        //获得数据库中的密码
//        String dbPassword = (String)info.getCredentials();
//        //进行密码的比对
//        return this.equals(inPassword, dbPassword);
//    }
//
//}
