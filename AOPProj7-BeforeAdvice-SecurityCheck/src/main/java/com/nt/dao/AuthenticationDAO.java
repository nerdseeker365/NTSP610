package com.nt.dao;

import com.nt.bo.UserInfoBO;

public interface AuthenticationDAO {
      public   int   authenticate(UserInfoBO bo);
}
