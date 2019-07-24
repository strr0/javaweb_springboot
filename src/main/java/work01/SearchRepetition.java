package work01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.*;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/19 下午2:17
 * @since 1.0
 */
public class SearchRepetition {



    private static final Logger LOGGER = LoggerFactory.getLogger(SearchRepetition.class);


    @Test
    public void testHello(){

    }


    public static void main(String[] args){

        String old ="ucar:carlog,mmc:carlog,ucar:BigDataSearch,ucar:UCARCDMSASYNC,ucar:UCARDE,ucar:UCARINCINV,ucar:UCARMKTWAP,ucar:billsystem,ucar:carintercenter,ucar:cartemplepart,ucar:cartp,ucar:cdms,ucar:cdmsdataprocessor,ucar:cdmsos,ucar:cdse,ucar:daemonSystem,ucar:dmeta,ucar:dreport,ucar:gestk,ucar:gpsidc2aws,ucar:growth-metaq-prod,ucar:hbasemanager,ucar:mgcube,ucar:mlss,ucar:mqcloud,ucar:musk,ucar:ozono,ucar:poseidon,ucar:prism,ucar:sddladmin,ucar:taxationsystem,ucar:tcarmapi,ucar:tcarorder,ucar:tcarorderos,ucar:ufklog,ucar:ufkmail,ucar:zkcloud,ucaradmin,ucaradpos,ucaragent,ucaralarminfo,ucaranticheat,ucarbackdoor,ucarbalance,ucarbidataserv,ucarbigdata,ucarbigstore,ucarcallcenter,ucarclbs,ucarcodriver,ucarcrm,ucarcrmnotify,ucarcrmsupport,ucardapi,ucardapiapp,ucardapic2c,ucardatacalcu,ucardataserv,ucardispatch,ucardispatchos,ucardmonitor,ucardriverappeal,ucaresproxy,ucarfeedback,ucarfinance,ucarincadmin,ucarinccrm,ucarincpms,ucarindicator,ucarinteract,ucarintrdriver,ucarintrdriveros,ucarintrdriversurvey,ucarlbsservice,ucarmapi,ucarmisc,ucarmktapi,ucarmktmis,ucarnetim,ucaroam,ucaropenapi,ucarordmsg,ucarpapi,ucarprice,ucarpriceAct,ucarpushservice,ucarqueue,ucarrtcp,ucarsharpmp,ucarsharpweb,ucarsmsplatform,ucartechplatunion,ucartemplepart,ucartp,ucarudfs,ucarvehicle,ucarweb,mmc4swap,mmc:UCVRMS,mmc:carintercenter,mmc:daemonSystem,mmc:vamAdmin,mmc:vamvins,mmcact,mmcapiproxy,mmcdapi,mmceapi,mmclog,mmcmapi,mmcmapiproxy,mmcoam,mmctapi,mmctemplepart,mmcwap,mmcweb,uc4s,uc4sadmin,ucadmin,ucasms,ucbi,uccms,uccrm,ucdp,uces,ucfin,uclcwa,ucmams,ucoms,ucvms,ucwapi,Polestardevice,polestar:carlog,polestaradmin,polestaralarmdistribute,polestaralarmmanager,polestaralarmtask,polestarapi,polestarcontainer,polestardatastore,polestarjstorm,polestarmsp,polestarreport,polestartablesync,polestartask,polestarweb,zuche:CARBAM,zuche:CARDEPR,zuche:CARFOMS,zuche:CARMAPI,zuche:CARMISC,zuche:CARMKTMIS,zuche:CARMKTWAP,zuche:CAROPTAPI,zuche:CARPeccancy,zuche:CARUC,zuche:CARVMSPeccancy,zuche:CARWAP,zuche:CARWCMS,zuche:CARWDM,zuche:CARWEPM,zuche:CARWLM,zuche:CARWLOM,zuche:CARWMM,zuche:CARWSOM,zuche:caradmin,zuche:caralarm,zuche:carapihertz,zuche:carcrm,zuche:carcsms,zuche:cardatadict,zuche:carfi,zuche:carhertz,zuche:carintercenter,zuche:carinventory,zuche:carjstorm,zuche:carlos,zuche:carlrms,zuche:carmapiproxy,zuche:carnapi,zuche:caroam,zuche:caroperation,zuche:carorderquery,zuche:caross,zuche:carpay,zuche:carpayment,zuche:carprice,zuche:carresources,zuche:carrule,zuche:carsrms,zuche:cartp,zuche:carvcs,zuche:carvehicleapi,zuche:carvms,zuche:carvmscore,zuche:carvmsicrm,zuche:daemonSystem,zuche:scarinventory,zuche:scarorder,zuche:scarprice,ycc:carintercenter,ycc:daemonSystem,ycc:yccevaluate,ycc:yccmapiproxy,ycc:yccom,ycc:yccresourceapi,yccadmin,yccbaseapi,ycccrm,ycccrmapi,yccfi,yccinspect,yccinspectapi,ycclog,yccmams,yccmt,yccmtmapi,yccmtsapi,yccnotice,yccnotify,yccoam,yccpapi,yccpeccancy,yccpeccancyapi,yccrap,yccrapapi,yccvins,yccvinsapi,fcar:carintercenter,fcar:daemonSystem,fcar:fundsource,fcaradmin,fcarantifraud,fcarasset,fcarcallcenter,fcarcollection,fcarcreditcollect,fcarcrm,fcareapi,fcarfi,fcarloan,fcarloanconsumer,fcarmapi,fcarnotify,fcarpapi,fcarpartner,fcarproduct,fcarrepay,fcarufaceid,fcarwap,ucar:carmreport,ucar:escloud,ucar:monitor-alarm,zuche:carlog,cat";

        String xin ="ucarintrdriver" +
                ",ampadmin" +
                ",ampsample" +
                ",ampvms" +
                ",api" +
                ",apisessionproxy" +
                ",assetsystem" +
                ",BigDataSearch" +
                ",billsystem" +
                ",caraaps" +
                ",caradmin" +
                ",carapihertz" +
                ",carbam" +
                ",carbi" +
                ",carcrawlsearch" +
                ",carcrm" +
                ",carcsms" +
                ",CARDaemonSystem" +
                ",cardapi" +
                ",cardatadict" +
                ",cardepr" +
                ",cardispatch" +
                ",carfi" +
                ",carfoms" +
                ",carhertz" +
                ",carintercenter" +
                ",carinventory" +
                ",carlog" +
                ",carlos" +
                ",carlrms" +
                ",carmapi" +
                ",carmisc" +
                ",carmktmis" +
                ",carmockserver" +
                ",carmockservertest1" +
                ",carmreport" +
                ",carnapi" +
                ",carobd" +
                ",caroperation" +
                ",carorderquery" +
                ",caross" +
                ",carpay" +
                ",carpayment" +
                ",carpeccancy" +
                ",carprice" +
                ",carpushservice" +
                ",carresources" +
                ",carrule" +
                ",carsrms" +
                ",cartest" +
                ",cartp" +
                ",caruc" +
                ",carvcs" +
                ",carvms" +
                ",carvmscore" +
                ",carvmsicrm" +
                ",carvmspeccancy" +
                ",carwap" +
                ",carwdm" +
                ",carwlm" +
                ",carwmm" +
                ",certmng" +
                ",channel" +
                ",creditcollect" +
                ",cronTrigger" +
                ",evpadmin" +
                ",evpchargebus" +
                ",evpchargecar" +
                ",evpchargeservice" +
                ",evpchargestar" +
                ",evpchargeteld" +
                ",fcaradmin" +
                ",fcarantifraud" +
                ",fcarasset" +
                ",fcarbigdata" +
                ",fcarcallcenter" +
                ",fcarcollection" +
                ",fcarcreditcollect" +
                ",fcarcrm" +
                ",fcarfi" +
                ",fcargpsalarm" +
                ",fcarinfo" +
                ",fcarloan" +
                ",fcarloandealer" +
                ",fcarloanes" +
                ",fcarmapi" +
                ",fcarnotify" +
                ",fcarpartner" +
                ",fcarproduct" +
                ",fcarrepay" +
                ",fcarsales" +
                ",fcarufaceid" +
                ",frameworktest" +
                ",gatekeeper" +
                ",gpsalarm" +
                ",gpsweb" +
                ",grayanalysis" +
                ",growthtools" +
                ",hbasemanager" +
                ",hbaseproxy" +
                ",hdfs-proxy" +
                ",hello" +
                ",lbs" +
                ",lbsser" +
                ",materialmgr" +
                ",mlss" +
                ",mmcactms" +
                ",mmcbigdata" +
                ",mmcdapi" +
                ",mmcdfds" +
                ",mmceapi" +
                ",mmclog" +
                ",mmcmapiproxy" +
                ",mmctapi" +
                ",mmcweb" +
                ",mock" +
                ",monitor-alarm" +
                ",mqcloud" +
                ",musk" +
                ",newdispatch" +
                ",polestaralarmmanager" +
                ",polestaralarmtask" +
                ",polestarapi" +
                ",polestarmsp" +
                ",polestarreport" +
                ",polestartask" +
                ",prism" +
                ",remoteServer" +
                ",remoteTest" +
                ",scarinventory" +
                ",scarorder" +
                ",scarprice" +
                ",sharpbm" +
                ",sharprouting" +
                ",sparkcube" +
                ",supergw" +
                ",supergwadmin" +
                ",tcardatas" +
                ",tcardataserv" +
                ",tcardataservcal " +
                ",tcardispatch" +
                ",tcarinteract" +
                ",tcarintrdriver" +
                ",tcarlbs" +
                ",tcarorder" +
                ",tcarorderos" +
                ",trianee" +
                ",uc4sadmin" +
                ",ucadmin" +
                ",ucaprice" +
                ",ucarabs" +
                ",ucarabsmapi" +
                ",ucaradmin" +
                ",ucaradpos" +
                ",ucaragent" +
                ",ucaralarminfo" +
                ",ucaranticheat" +
                ",ucarapimonitor" +
                ",ucarappcount" +
                ",ucarassistantos" +
                ",ucarbalance" +
                ",ucarbidataserv" +
                ",ucarbigdata" +
                ",ucarbigstore" +
                ",ucarcallcenter" +
                ",ucarcdms" +
                ",ucarcdmsasync" +
                ",ucarcdmsdataprocessor" +
                ",ucarcdmsos" +
                ",ucarclbs" +
                ",ucarcodriver" +
                ",ucarcrm" +
                ",ucarcrmnotify" +
                ",ucarcrmsupport" +
                ",ucardatacalcu" +
                ",ucardataserv" +
                ",ucardataservcal" +
                ",ucarde" +
                ",ucardep" +
                ",ucardispatch" +
                ",ucardispatchos" +
                ",ucardriverappeal" +
                ",ucardrivercheck" +
                ",ucardynprice" +
                ",ucardynpricecity" +
                ",ucardynpricepingproxy" +
                ",ucaredataserv" +
                ",ucaredu" +
                ",ucaresproxy" +
                ",ucarfeedback" +
                ",ucarfeos" +
                ",ucarfi" +
                ",ucargeofence" +
                ",ucarhdfsproxy" +
                ",ucarincadmin" +
                ",ucarinccrm" +
                ",ucarincinv" +
                ",ucarincpms" +
                ",ucarinteract" +
                ",ucarintrdriver" +
                ",ucarintrdriversurvey" +
                ",ucarlbsbase" +
                ",ucarlbsorderdistribution" +
                ",ucarlbssearch" +
                ",ucarlbsservice" +
                ",ucarlbssseo" +
                ",ucarmapi" +
                ",ucarmapiproxy" +
                ",ucarmisc" +
                ",ucarmktmis" +
                ",ucarmodelmatch" +
                ",ucarmros" +
                ",ucarnetim" +
                ",ucarnetport" +
                ",ucaroam" +
                ",ucarobd" +
                ",ucarobdprocess" +
                ",ucarpartner" +
                ",ucarpathcalculate" +
                ",ucarprice" +
                ",ucarpriceact" +
                ",ucarqueue" +
                ",ucarrulesweb" +
                ",ucarsharpbm" +
                ",ucarsharpmp" +
                ",ucarsharprouting" +
                ",ucarsharpweb" +
                ",ucarsmsplatform" +
                ",ucartechplatunion" +
                ",ucartemple" +
                ",ucartrace" +
                ",ucarudfs" +
                ",ucarvehicle" +
                ",ucarvehiclerental" +
                ",ucarweather" +
                ",ucarweb" +
                ",ucar_weather" +
                ",ucasms" +
                ",ucbi" +
                ",uccms" +
                ",uccrm" +
                ",ucdp" +
                ",uces" +
                ",ucfin" +
                ",uclcwa" +
                ",ucmams" +
                ",ucmapi" +
                ",ucoms" +
                ",ucproc" +
                ",ucvms" +
                ",ucvrms" +
                ",ucwapi" +
                ",ulearnsystem" +
                ",upms" +
                ",vamadmin" +
                ",vamvins" +
                ",vamvms" +
                ",weixinapi" +
                ",yccadmin" +
                ",ycccrm" +
                ",yccevaluate" +
                ",yccfi" +
                ",yccinspect" +
                ",ycclog" +
                ",yccmams" +
                ",yccmt" +
                ",yccnotice" +
                ",yccnotify" +
                ",yccoam" +
                ",yccom" +
                ",yccpeccancy" +
                ",yccrap" +
                ",ycctemplate" +
                ",yccvins" +
                ",zkdoctor";
/*

        String[] oldBuffer = old.toLowerCase().split(",");
        String[] xinBuffer = xin.toLowerCase().split(",");

        //对old进行去":"以及去除重复
        List<String> oldlist = new ArrayList<String>();
        for(String s : oldBuffer){
            int index = s.indexOf(":");
            if(index != -1){
                s = s.substring(index + 1);
            }
            if(!oldlist.contains(s)){
                oldlist.add(s);
            }
        }

        //比较old与xin中的相同项
        List<String> list = new ArrayList<String>();
        for(String s1 : oldlist){
            for(String s2 : xinBuffer){
                if(s1.compareTo(s2) == 0){
                    list.add(s1);
                }
            }
        }
        //排序
        Collections.sort(list);
        for(String s : list){
            System.out.println(s);
        }
        System.out.println(list.size());

*/

        Set<String> l1 = new HashSet<String>();
        Set<String> l2 = new HashSet<String>();
        Set<String> l3 = new HashSet<String>();

        String[] s1 = old.toLowerCase().split(",");
        String[] s2 = xin.toLowerCase().split(",");

        for(String s : s1){
            String[] qq = s.split(":");
            if(qq.length == 1)
                l1.add(qq[0]);
            else
                l1.add(qq[1]);
        }
        for(String s : s2){
            l2.add(s);
        }

        for(String ss : l2){
            if(l1.contains(ss)){
                l3.add(ss);
                System.out.println(ss);
            }
        }
        System.out.println(l3.size());


        //写入文件a.txt
        try{
            File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "a.txt");
            FileOutputStream out = new FileOutputStream(file);
            for(String s : l3){
                out.write(s.getBytes());
                out.write("\r\n".getBytes());
            }
            out.close();
            System.out.println("write successfully");
        }
        catch (FileNotFoundException f){
            System.out.println("file is not found.");
        }
        catch (IOException i){
            System.out.println("catch IOException.");
        }

    }
}
