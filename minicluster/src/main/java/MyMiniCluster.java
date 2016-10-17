import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseTestingUtility;
import org.apache.hadoop.hbase.MiniHBaseCluster;
import org.apache.hadoop.hbase.zookeeper.MiniZooKeeperCluster;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.hdfs.MiniDFSNNTopology;
import org.apache.hadoop.mapred.MiniMRCluster;
import org.apache.hadoop.mapreduce.v2.MiniMRYarnCluster;

/**
 * Created by allen on 2016/10/17.
 */
public class MyMiniCluster {
    public static void main(String[] args) throws Exception {
        HBaseTestingUtility hbtu = new HBaseTestingUtility();
        Configuration conf = hbtu.getConfiguration();
        conf.set("test.hbase.zookeeper.property.clientPort", "2181");
        MiniHBaseCluster hBaseCluster = hbtu.startMiniCluster();
        MiniDFSCluster dfsCluster = hbtu.getDFSCluster();
        MiniMRCluster mrCluster = hbtu.startMiniMapReduceCluster();
        MiniZooKeeperCluster zkCluster = hbtu.getZkCluster();

        System.out.println("hmaster info server port is : " + hBaseCluster.getMaster().getInfoServer().getPort());
        System.out.println("namenode ipc url is : " + dfsCluster.getURI().toString());
        System.out.println("namenode http url is : " + dfsCluster.getHttpUri(0));
        System.out.println("zk is : " + zkCluster.getClientPort());


    }
}
