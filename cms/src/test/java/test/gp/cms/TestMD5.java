package test.gp.cms;

import cn.hutool.crypto.SecureUtil;
import org.junit.Test;

public class TestMD5 {
    @Test
    public void md5() {
        String username = "785424809@qq.com";
        String password = "123";
        System.out.println(SecureUtil.md5(username + password));
    }
}