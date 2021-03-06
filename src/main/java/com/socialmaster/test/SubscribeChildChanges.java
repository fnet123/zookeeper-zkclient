package com.socialmaster.test;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Created by liuxiaojun on 2016/8/22.
 */
public class SubscribeChildChanges {
    private static class ZkChildListener implements IZkChildListener{

        public void handleChildChange(String parentPath,
                                      List<String> currentChilds) throws Exception {
            // TODO Auto-generated method stub

            System.out.println(parentPath);
            System.out.println(currentChilds.toString());

        }


    }

    public static void main(String[] args) throws InterruptedException {
        ZkClient zc = new ZkClient("192.168.1.105:2181",10000,10000,new SerializableSerializer());
        System.out.println("conneted ok!");

        zc.subscribeChildChanges("/jike20", new ZkChildListener());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
