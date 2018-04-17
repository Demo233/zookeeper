package com.edu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


/**
 * 完成zookeeper对节点的增删改查操作
 */

public class ZkDemo1 {

    private static ZooKeeper zk = null;

    private static String connectionString = "192.168.1.119:2181,192.168.1.120:2181,192.168.1.121:2181,192.168.1.122:2181";

    private static int sessionTimeout = 2000;

    @Before
    public void init(){

        try {
            zk = new ZooKeeper(connectionString, sessionTimeout, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getType() + watchedEvent.getPath());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void create(){

        try {
            String path = zk.create("/xxx","hello zookeeper!".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete(){

        try{
            zk.delete("/xxx",-1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void get(){

        try{
            List<String> children = zk.getChildren("/", false);
            for (int i = 0; i < children.size(); i++) {
                System.out.println(children.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void set(){

        try{
            Stat stat = zk.setData("/xxx", "modify node".getBytes(), -1);
            System.out.println(stat);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}