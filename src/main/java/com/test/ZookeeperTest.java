package com.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ZookeeperTest {
    public static void main(String args[]) throws Exception{
        String zkServer = "127.0.0.1:2182";

        ZooKeeper zk = new ZooKeeper(zkServer,6000,new Watcher(){
            //@Override
            public void process(WatchedEvent event) {
            }
        });

//        //创建节点
//        System.out.println("创建jade节点");
        zk.create("/jade", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/jade/config", getConfig().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/jade/config/god_proxy.xml", getXML(false).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/jade/config/push_proxy.xml", getPushProxyXML().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/jade/config/user_behavior_bk.xml", getUserBehavior().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        //创建子节点
//        System.out.println("\n创建testDir1节点的子节点");
          //zk.create("/jade/config/god.xml", getXML().getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        //zk.create("/testDir1/sub2", "sub2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//
//        //取出子节点列表
        //System.out.println("\n/jade/config的子节点列表为："+zk.getChildren("/jade/config", true));
//
//        取出节点的数据
//          System.out.println("\n取出/jade/config/god.xml节点的数据为：\n\n" + new String(zk.getData("/jade/config/god.xml", false, null)));

//        //修改节点数据
          //zk.setData("/jade/config/god_proxy.xml", getXML(false).getBytes(),-1);
         // System.out.println("\n取出/jade/config节点的数据为：\n\n" + new String(zk.getData("/jade/config", false, null)));
//
//        //删除节点
//        System.out.println("\n删除节点/testDir1/sub1");
       //zk.delete("/springboot/db/push.properties", -1);

       // System.out.println("\ntestDir1的子节点列表为：" + zk.getChildren("/testDir1", true));

        //zk.create("/god-data", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         zk.create("/springboot", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         zk.create("/springboot/db", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         zk.create( "/springboot/db/god.properties", getXML(true).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         zk.create("/springboot/db/push.properties", getPush().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

////          zk.create("/spring.boot.zookeeper.config", getXML(true).getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
     System.out.println("\n取出/spring.boot.zookeeper.config.god.test节点的数据为：\n\n" + new String(zk.getData("/jade/config/user_behavior_bk.xml", false, null)));
//         zk.delete("/god-data/configuration/db/push.properties", -1);

    }

    public static String getUserBehavior() throws Exception{
        String filePath = "user_behavior.xml";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (ZookeeperTest.class.getClassLoader().getResourceAsStream(filePath)));
        String line = "";
        String line_ = "";
        while ((line_ = reader.readLine()) != null) {
            line += line_ + "\n";
        }
        return line;
    }

    public static String getConfig() throws Exception{
        String filePath = "config.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (ZookeeperTest.class.getClassLoader().getResourceAsStream(filePath)));
        String line = "";
        String line_ = "";
        while ((line_ = reader.readLine()) != null) {
            line += line_ + "\n";
        }
        return line;
    }

    public static String getPush() throws Exception{
        String filePath = "push.properties";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (ZookeeperTest.class.getClassLoader().getResourceAsStream(filePath)));
        String line = "";
        String line_ = "";
        while ((line_ = reader.readLine()) != null) {
            line += line_ + "\n";
        }
        return line;
    }

    public static String getXML(boolean flag) throws Exception{
        String filePath = "jade-config-god.xml";
        if (flag)
            filePath = "spring.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (ZookeeperTest.class.getClassLoader().getResourceAsStream(filePath)));
        String line = "";
        String line_ = "";
        while ((line_ = reader.readLine()) != null) {
            line += line_ + "\n";
        }
        return line;
    }

    public static String getPushProxyXML() throws Exception{
        String filePath = "jade-config-push.xml";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (ZookeeperTest.class.getClassLoader().getResourceAsStream(filePath)));
        String line = "";
        String line_ = "";
        while ((line_ = reader.readLine()) != null) {
            line += line_ + "\n";
        }
        return line;
    }

    @Test
    public void test(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("sa",25742);
        map.put("sb",null);
        int count = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != null)
                count += entry.getValue();
        }
        System.out.println(count);
        System.out.println(map.get("fdsagf") == null);
    }

}

