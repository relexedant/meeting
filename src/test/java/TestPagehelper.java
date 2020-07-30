import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.meeting.dao.IEmpDao;
import com.gxc.meeting.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestPagehelper {

    @Test
    public void test1() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis1.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        System.out.println(sqlSessionFactory);




        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        PageInfo<Employee> pageInfo = new PageInfo<Employee>();



        IEmpDao mapper = sqlSession.getMapper(IEmpDao.class);
        // 批量填充数据
        for (int i = 20; i < 60; i++) {
            mapper.doReg(new Employee("empname"+i,"username"+i,"110","username"+i+"@qq.com","1",13,"1","1"));
        }
        for (int i = 0; i < 2; i++) {

            PageHelper.startPage(i,5);
            List<Employee> all = mapper.getAll();
            pageInfo.setList(all);

//            if(pageInfo.getList().)
pageInfo.getList();
            Page page = (Page) (pageInfo.getList());
            pageInfo.setTotal(page.getTotal());

            System.out.println(pageInfo);
            System.out.println("******************************************************");
        }




    }


//    SqlSession sqlSession
}
