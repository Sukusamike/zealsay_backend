package com.zeal.zealsay;

import com.zeal.zealsay.service.EmailService;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JasyptEncryptorTest extends ZealsayApplicationTests{

  @Autowired
  EmailService emailService;

  @Test
  public void testEncrypt() throws Exception {
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword("jinjinyike");
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setProviderName("SunJCE");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);
    String plainText = "7a47188564c74cea621918344b83c3d2b185dcc5";
    String encryptedText = encryptor.encrypt(plainText);
    System.out.println(encryptedText);
    Assert.assertNotNull(encryptedText);
  }

  @Test
  public void testDe() throws Exception {
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword("password");
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setProviderName("SunJCE");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);
    String encryptedText = "Ftw+Zk1K1TlGOwNsKDbYiQ==";
    String plainText = encryptor.decrypt(encryptedText);
    Assert.assertEquals("test",plainText);
  }

  @Test
  public void testSendEmail() throws Exception {
    //发送简单邮件
//    emailService.sendSimpleMail("zhangleifor@163.com","标题","内容");
    //发送html邮件
    String content = "<html>\n" +
        "    \n" +
        "<head>\n" +
        "<base target=\"_blank\" />\n" +
        "<style type=\"text/css\">\n" +
        "::-webkit-scrollbar{ display: none; }\n" +
        "</style>\n" +
        "<style id=\"cloudAttachStyle\" type=\"text/css\">\n" +
        "#divNeteaseBigAttach, #divNeteaseBigAttach_bak{display:none;}\n" +
        "</style>\n" +
        "<style id=\"blockquoteStyle\" type=\"text/css\">blockquote{display:none;}</style>\n" +
        "</head>\n" +
        "<body tabindex=\"0\" role=\"listitem\">\n" +
        "\n" +
        "\n" +
        "\n" +
        "<div id=\"content\">\n" +
        "\n" +
        "<table style=\"-webkit-font-smoothing: antialiased;font-family:'microsoft yahei', 'Helvetica Neue', sans-serif, SimHei;padding:30px;margin: 25px auto; background:#fff; border-radius:5px; box-sizing: border-box;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" align=\"center\">\n" +
        "    <tbody>\n" +
        "    <tr style=\"text-align: center\">\n" +
        "        <td style=\"color:#000\">\n" +
        "            <img width=\"180px\" height=\"120px\" src=\"https://pan.zealsay.com/logo.png\" alt=\"Coding.net\">\n" +
        "                    </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"height: 33px;padding: 10px 20px 10px 20px;font-size: 24px;color: #212e40;\">\n" +
        "            Hi zeal，\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"font-size: 20px;  padding: 10px 20px;color: #212e40;font-weight: normal;\">\n" +
        "           您已注册成功。\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"font-size: 14px;color: #212e40;  padding: 10px 20px;\">\n" +
        "            以下是您的登录信息：\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td valign=\"left\" style=\"font-size: 36px;color: #323A45;\">\n" +
        "            <div style=\"background: #F2F2F7;border-radius: 2px;margin: 10px 20px;\">\n" +
        "                <div style=\"font-size: 14px;line-height: 14px; padding: 20px 20px 10px 20px;\">\n" +
        "                    用户名称：jinjinyike\n" +
        "                </div>\n" +
        "                <div style=\"font-size: 14px;line-height: 14px; padding: 10px 20px 20px 20px;\">\n" +
        "                    登录账户：<A data-auto-link=1 href=\"mailto:zhangleifor@163.com\">jinjinyike@163.com</A>            </div>\n" +
        "            </div>\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td valign=\"middle\" style=\"font-size: 12px;height: 17px;padding: 15px 20px;\">\n" +
        "           欢迎您的加入！这都能找到我们，看来我们很有缘分哟(≥﹏ ≤) 赶紧点击下面链接去激活您的账号，跟我们一起愉快的玩耍吧！\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"height: 50px;color: white;\" valign=\"middle\">\n" +
        "            <div style=\"padding:10px 20px;border-radius:5px;background: rgb(64, 69, 77);margin-left:20px;margin-right:20px\">\n" +
        "                <a style=\"word-break:break-all;line-height:23px;color:white;font-size:15px;text-decoration:none;\" href=\"https://zealsay.coding.net/app/detect?link=https%3A%2F%2Fzealsay.coding.net%2Fsignup%2Factivate%3Femail%3Dzhangleifor%40163.com%26key%3Db8a0012cf2be1eaf372bb83f1ab6f5d47542fcb2\">\n" +
        "                    https://blog.zealsay.com/app/detect?link=https%3A%2F%2Fzealsay.coding.net%2Fsignup%2Factivate%3Femail%3Dzhangleifor%40163.com%26key%3Db8a0012cf2be1eaf372bb83f1ab6f5d47542fcb2\n" +
        "                </a>\n" +
        "            </div>\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"padding: 20px 20px 20px 20px;font-size: 12px;\">\n" +
        "            <p style=\"margin: 8px 0;\">如果点击以上链接无效，请尝试将链接复制到浏览器地址栏访问。</p>\n" +
        "            <p style=\"margin: 8px 0;\">假如您没有进行注册操作，请忽略此邮件，不要点击上面链接。</p>\n" +
        "            <p style=\"margin: 8px 0;\">若您有任何疑问，请随时联系我们：<a style=\"color:#5098E8;text-decoration:none\" href=\"admin@zealsay.com\">admin@zealsay.com</a></p>\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"font-size: 14px; color: #323A45; padding: 20px 0;\">\n" +
        "            zeal\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"padding-top: 30px;\">\n" +
        "            <hr style=\"border:none;border-top:1px solid #ccc;\">\n" +
        "        </td>\n" +
        "    </tr>\n" +
        "    <tr>\n" +
        "        <td style=\"color:#76808E;font-size: 12px;\">\n" +
        "            <div style=\"text-align: center; line-height: 24px;\">\n" +
        "                Copyright © 2019 zealsay\n" +
        "            </div>\n" +
        "                        \n" +
        "                </div>\n" +
        "                    </td>\n" +
        "    </tr>\n" +
        "    </tbody>\n" +
        "</table>\n" +
        " \n" +
        "\n" +
        "</div>\n" +
        "\n" +
        "<script>var _c=document.getElementById('content');_c.innerHTML=(_c.innerHTML||'').replace(/(href|formAction|onclick|javascript)/ig, '__$1').replace(/<\\/?marquee>/ig,'');</script>\n" +
        "<style type=\"text/css\">\n" +
        "body{font-size:14px;font-family:arial,verdana,sans-serif;line-height:1.666;padding:0;margin:0;overflow:auto;white-space:normal;word-wrap:break-word;min-height:100px}\n" +
        "td, input, button, select, body{font-family:Helvetica, 'Microsoft Yahei', verdana}\n" +
        "pre {white-space:pre-wrap;white-space:-moz-pre-wrap;white-space:-pre-wrap;white-space:-o-pre-wrap;word-wrap:break-word;width:95%}\n" +
        "th,td{font-family:arial,verdana,sans-serif;line-height:1.666}\n" +
        "img{ border:0}\n" +
        "header,footer,section,aside,article,nav,hgroup,figure,figcaption{display:block}\n" +
        "blockquote{margin-right:0px}\n" +
        "</style>\n" +
        "\n" +
        "\n" +
        "\n" +
        "<style id=\"netease_mail_footer_style\" type=\"text/css\">#netease_mail_footer{display:none;}</style>\n" +
        "\n" +
        "\n" +
        "<style id=\"ntes_link_color\" type=\"text/css\">a,td a{color:#064977}</style>\n" +
        "\n" +
        "</body>\n" +
        "</html>";
    emailService.sendHtmlMail("zhangleifor@163.com","账号注册激活邮件",content);
//    //发送附件邮件示例
//    emailService.sendAttachmentsMail("117***86@qq.com","给你的",content,"C:\\Users\\Administrator\\Pictures\\999.jpg");
//
//    //发送图片邮件示例
//    String resId ="id001";
//    String content = "<html>\n" +
//        "<body><h2>html邮件内容</h2><br><img src=\'cid:"+resId+"\'></img></body>" +
//        "</html>";
//    //发图片邮件
//    emailService.sendInlinResourceMail("ai*****2@126.com","标题",
//        content,"C:\\Users\\Administrator\\Pictures\\\\999.jpg",resId);
  }
}
