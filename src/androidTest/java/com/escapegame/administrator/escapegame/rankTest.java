package com.escapegame.administrator.escapegame;
import junit.framework.TestCase;
/**
 * Created by Administrator on 2016/5/13 0013.
 */
public class rankTest extends TestCase {
    rank r=new rank(0,null,0,null);

    public void testSetQuestion() throws Exception {
        assertNotNull("The rank is empty",r.getNo());
    }

    public void testGetCorrectAns() throws Exception {

    }
}
