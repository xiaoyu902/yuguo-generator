package com.yuguo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.val;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        for (int i = -27; i <= 0; i++) {
            getData(i);
        }
    }

    private static void getData(int num){

        Random r = new Random();
        // 随机生成10-20条
        int n = r.nextInt(10) + 10; // 随机10-20
        a:for (int i = 0; i < n; i++) {
            // 修改日期
            DateTime time = DateUtil.offsetDay(new Date(), num);
            // 自定义流水号
            String orderNo = "IN" + DateUtil.format(time, "yyyyMMddHHmmSSsss")  + RandomUtil.randomNumbers(4);
            String orderNo2 = "123060123135000000000000000" + RandomUtil.randomNumbers(3);

            // 设置金额
            String money = r.nextInt(1000) + ".00";
            // 随机改变金额正负
            int number = r.nextInt(16);
            if(number > 9 && number < 11){
                money = "-" + money;
            }
            // 设置姓名 日期 时间 备注
            String name = "测试";
            String date = DateUtil.format(time, "yyyy-MM-dd"); // 从2.1开始
            String dateTime = time.toString();
            String remark = "机构与商户账单共有";

            // 随机获取类型
            String[] tradeTypes = {"mix", "wx", "zfb"};
            String[] business = {"1", "3", "4"};
            String results = "0";
            int s = r.nextInt(2);
            // 共有账单、长短款
            if(number > 12){
                remark = "商户账单多出一笔消费";
                results = "1";
            }
            String mch = "INSERT INTO `bill_mchbills` VALUES ('100001', '10000007458551', '"+tradeTypes[s]+"', "+money+", 0.00, 2000.00, '"+orderNo+"', '"+orderNo2+"', '00000000', NULL, 0, NULL, '"+dateTime+"', '"+date+"', "+results+", NULL, NULL, NULL, NULL, NULL, '"+remark+"');";
            if(number > 12){
                System.out.println(mch);
                break a;
            }
            if(number < 4) {
                remark = "机构账单多出一笔消费";
                results = "-1";
            }
            String org = "INSERT INTO `bill_orgbills` VALUES ('100001', '" + tradeTypes[s] + "', '" + business[s] + "', " + money + ", '" + orderNo + "', '00000000', NULL, 0, '" + name + "', '1646042', '13710430969', NULL, NULL, '" + dateTime + "', '" + date + "', "+results+", 0, '" + remark + "');";
            if(number < 4) {
                System.out.println(org);
                break a;
            }
            System.out.println(mch);
            System.out.println(org);
        }
    }
}