package com.wh.test.zookeeper.test.t001;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**zk伪集群配置
 * https://blog.csdn.net/tanyujing/article/details/8504481
 */
public class Zookeeper {
    private static CountDownLatch countDownLatch=new CountDownLatch(1);

    //虚拟机的ip：conf中配置的clientPort作为url
    private final static String zk_url="192.168.95.130:3181,192.168.95.130:3182,192.168.95.130:3183";

    private final static int time_out=5000;

    public static void main(String[] arges) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, InterruptedException {
       // Object clsszz =  Class.forName("com.wh.test.zookeeper.test.t001.Zookeeper").newInstance();
        //初始化zk
        ZooKeeper zooKeeper=new ZooKeeper(zk_url, time_out, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                Event.EventType type = watchedEvent.getType();
                if(Event.KeeperState.SyncConnected==state){
                    if(Event.EventType.None==type){
                        //调用此方法测计数减一
                        countDownLatch.countDown();
                    }
                }
            }
        });
        //阻碍当前线程进行,除非计数归零
        countDownLatch.await();
        try {
            //创建持久化节点
            zooKeeper.create("/gang","你好".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //获取节点数据
            byte[] data = zooKeeper.getData("/gang", false, null);
            System.out.println("获取："+new String(data));

            //修改节点数据
            zooKeeper.setData("/gang","吕金刚".getBytes(),0);
            byte[] data1 = zooKeeper.getData("/gang", false, null);
            System.out.println("修改后"+new String(data1));

            //删除节点数据
            zooKeeper.delete("/gang",-1);
            //验证节点是否存在
            Stat exists1 = zooKeeper.exists("/gang", false);
            System.out.println("删除后是否存在："+exists1);

            //创建临时节点 异步创建
            zooKeeper.create("/jingang", "临时节点".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new AsyncCallback.StringCallback() {
                @Override
                public void processResult(int i, String s, Object o, String s1) {
                    System.out.println(o);
                    System.out.println(i);
                    System.out.println(s1);
                    System.out.println(s);
                }
            },"a");
            //获取临时节点数据
            byte[] jingangs = zooKeeper.getData("/jingang", false, null);
            System.out.println("获取临时节点："+new String(jingangs));

            //验证节点是否存在
            Stat exists = zooKeeper.exists("/jingang", false);
            System.out.println("是否存在临时节点："+exists);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zooKeeper.close();
    }

}
