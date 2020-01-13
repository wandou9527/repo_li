package com.wandou.constant;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liming
 * @date 2018/9/20 16:57
 * @description
 * @modify
 */

@Slf4j
//@PropertySource(value = {"classpath:application.properties"}, encoding = CommonConst.UTF_8)
@Configuration
public class NameConst {

//    《天龙八部》人物（共有169人）
//    刀白凤 丁春秋 马夫人 马五德 于光豪 巴天石 不平道人
//    邓百川 风波恶 甘宝宝 公冶乾 木婉清 少林老僧 太皇太后 天狼子
//    天山童姥 王语嫣 乌老大 无崖子 云岛主 云中鹤 止清 白世镜
//    包不同 本参 本观 本相 本因 出尘子 冯阿三 古笃诚
//    过彦之 兰剑 平婆婆 石清露 石嫂 司空玄 司马林 玄慈
//    玄寂 玄苦 玄难 玄生 玄痛 叶二娘 左子穆 华赫艮
//    李春来 李傀儡 李秋水 刘竹庄 朴者和尚 祁六三 乔峰 全冠清
//    阮星竹 西夏宫女 许卓诚 朱丹臣 竹剑 阿碧 阿洪 阿胜
//    阿朱 阿紫 波罗星 陈孤雁 何望海 鸠摩智 来福儿 孟师叔
//    努儿海 宋长老 苏星河 苏辙 完颜阿古打 吴长风 吴光胜 吴领军
//    辛双清 严妈妈 余婆婆 岳老三 张全祥 单伯山 单季山 单叔山
//    单小山 单正 段延庆 段誉 段正淳 段正明 范禹 范百龄
//    范骅 苟读 和里布 耶律洪基 耶律莫哥 耶律涅鲁古 耶律重元 易大彪
//    郁光标 卓不凡 宗赞王子 哈大霸 姜师叔 枯荣长老 梦姑 神山上人
//    神音 狮鼻子 室里 项长老 姚伯当 幽草 赵钱孙 赵洵
//    哲罗星 钟灵 钟万仇 高升泰 龚光杰 贾老者 康广陵 秦红棉
//    容子矩 桑土公 唐光雄 奚长老 徐长老 诸保昆 崔百泉 崔绿华
//    符敏仪 黄眉和尚 菊剑 聋哑婆婆 梅剑 萧远山 虚竹 游骥
//    游驹 游坦之 程青霜 傅思归 葛光佩 缘根 智光大师 鲍千灵
//    褚万里 瑞婆婆 端木元 赫连铁树 黎夫人 慕容博 慕容复 谭公
//    谭婆 谭青 摘星子 慧方 慧观 慧净 慧真 穆贵妃
//    薛慕华

    //金庸武侠人物
    public static final List<String> jinSwordsmans = Arrays.asList("无崖子", "云中鹤", "出尘子", "乔峰", "苏星河", "段誉",
            "段正淳", "秦红棉", "萧远山", "虚竹", "摘星子", "梦姑", "奚长老", "奚长老", "慧净", "慧净", "刀白凤", "丁春秋",
            "马夫人", "马五德", "于光豪", "巴天石", "不平道人", "邓百川", "风波恶", "甘宝宝", "公冶乾", "木婉清", "少林老僧",
            "太皇太后", "天狼子", "天山童姥", "王语嫣");

    @Value("#{'${mouse.jinSwordsmans}'.split('%2c')}")
    private List<String> configJinSwordsmans;

    private List<String> jinSwordsmans2 = new ArrayList<>(200);

    private int decodedFlag = 0;
    private AtomicInteger decodeFlagAtomic = new AtomicInteger(0);


    public static List shuffleList(List list) {
        Collections.shuffle(list);
        return list;
    }

    public static String getRandomJinSwordsman() {
        return jinSwordsmans.get(RandomUtils.nextInt(0, jinSwordsmans.size() - 1));
    }

    public String getDynamicRandomJinSwordsman() throws UnsupportedEncodingException {
//        decodeList(null);
        log.info("随机一个武侠人物, 总数: {}", jinSwordsmans2.size());
        return jinSwordsmans2.get(RandomUtils.nextInt(0, jinSwordsmans2.size() - 1));
    }

    public void decodeList(List<String> strList) {
        if (decodeFlagAtomic.incrementAndGet() > 1) {
            return;
        }
        decodedFlag = 1;

        log.info("decodeList");
        for (String string : configJinSwordsmans) {
            try {
                string = URLDecoder.decode(string, CommonConst.UTF_8);
                jinSwordsmans2.add(string);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
