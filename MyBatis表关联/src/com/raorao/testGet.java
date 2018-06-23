package com.raorao;

import org.apache.ibatis.session.SqlSession;

public class testGet {

	public void testGetClass1(){
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * me.gacl.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getClass��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "com.raorao.classMapper.getClass";//ӳ��sql�ı�ʶ�ַ���
		//ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
		Classes clazz = sqlSession.selectOne(statement,1);//��ѯclass����idΪ1�ļ�¼
		//ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(clazz);//��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
	}

	public void testGetClass2(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * me.gacl.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getClass2��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "com.raorao.classMapper.getClass2";//ӳ��sql�ı�ʶ�ַ���
		//ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
		Classes clazz = sqlSession.selectOne(statement,1);//��ѯclass����idΪ1�ļ�¼
		//ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(clazz);//��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
	}
	

    public void testGetClass3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getClass3��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.raorao.classMapper.getClass3";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
        Classes clazz = sqlSession.selectOne(statement,1);//��ѯclass����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        //��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1], students=[Student [id=1, name=student_A], Student [id=2, name=student_B], Student [id=3, name=student_C]]]
        System.out.println(clazz);
    }
    

    public void testGetClass4(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getClass4��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        String statement = "com.raorao.classMapper.getClass4";//ӳ��sql�ı�ʶ�ַ���
        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
        Classes clazz = sqlSession.selectOne(statement,1);//��ѯclass����idΪ1�ļ�¼
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        //��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1], students=[Student [id=1, name=student_A], Student [id=2, name=student_B], Student [id=3, name=student_C]]]
        System.out.println(clazz);
    }
}
