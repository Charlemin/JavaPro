package com.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

/**
 *
 */
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperTest {
    public static void main(String args[])throws Exception{
        String zkServer = "127.0.0.1:2182";

        ZooKeeper zk = new ZooKeeper(zkServer,6000,new Watcher(){
            //@Override
            public void process(WatchedEvent event) {
            }
        });

        //创建节点
        System.out.println("创建jade节点");
        zk.create("/jade", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/jade/config", "god=/jade/config/god.xml".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/jade/config/god.xml", getXML().getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        //创建子节点
//        System.out.println("\n创建testDir1节点的子节点");
          //zk.create("/jade/config/god.xml", getXML().getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        //zk.create("/testDir1/sub2", "sub2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//
//        //取出子节点列表
        //System.out.println("\n/jade/config的子节点列表为："+zk.getChildren("/jade/config", true));
//
//        取出节点的数据
          System.out.println("\n取出/jade/config/god.xml节点的数据为：\n\n" + new String(zk.getData("/jade/config/god.xml", false, null)));

//        //修改节点数据
          //zk.setData("/jade/config/god.xml", getXML().getBytes(),-1);
         // System.out.println("\n取出/jade/config节点的数据为：\n\n" + new String(zk.getData("/jade/config", false, null)));
//
//        //删除节点
//        System.out.println("\n删除节点/testDir1/sub1");
       // zk.delete("/jade", -1);

       // System.out.println("\ntestDir1的子节点列表为：" + zk.getChildren("/testDir1", true));
    }



    public static String getXML() throws Exception{
        String filePath = "jade-config.xml";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (ZookeeperTest.class.getClassLoader().getResourceAsStream(filePath)));
        String line = "";
        String line_ = "";
        while ((line_ = reader.readLine()) != null) {
            line += line_ + "\n";
        }
        return line;
    }
}

