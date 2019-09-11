package com.zeal.zealsay.service.auth;

import org.springframework.stereotype.Service;

/**
* github登录.
*
* @author  zeal
* @date 2019/9/11 21:51
*/
@Service(value = "GITHUB")
public class OauthGithubLogin extends AbstractOauthLogin{

    @Override
    protected String getRedirectUrl() {
        return null;
    }
}
