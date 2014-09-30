package com.quanken.repository

import com.github.miemiedev.mybatis.paginator.domain.PageBounds
import com.quanken.entity.User
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Select

@MyBatisRepository
public interface UserDao {

    public User get(Long id);

    @Select("""<script>
            select * from FP_USER_BASIC_INFO ubi where
                <if test="deptCode != null and deptCode != ''">
                     branch_id = #{deptCode} and
                </if>
            create_date &lt; \${createDate}
        </script>""")
    @ResultMap(value = "userResult")
    public List<User> queryByDeptCode(@Param("deptCode") String deptCode,
                                      @Param("createDate") Date createDate,
                                      PageBounds pageBounds);

    public List<Map<String, Object>> search(Map params ,PageBounds pageBounds);

    public List<Map<String, Object>> find(PageBounds pageBounds);
;
}
