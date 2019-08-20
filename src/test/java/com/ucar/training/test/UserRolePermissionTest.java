package com.ucar.training.test;

import static org.junit.Assert.*;
import com.ucar.training.config.DataConfig;
import com.ucar.training.mapper.RoleMapper;
import com.ucar.training.mapper.UserRolePermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class UserRolePermissionTest {
    @Resource
    private UserRolePermissionMapper mapper;

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void getPermissionTest(){
        assertNotNull(mapper);
        List<String> permissions = mapper.getPermissions("root");
        assertNotNull(permissions);

        for(String permission : permissions){
            System.out.println(permission);
        }
    }

    @Test
    public void getRolesTest(){
        List<String> roles = roleMapper.selectRole();
        assertNotNull(roles);
        for(String role : roles){
            System.out.println(role);
        }
    }
}
