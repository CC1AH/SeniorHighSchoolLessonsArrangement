package com.example.myapplication.Settings;

import java.text.DateFormat;
import java.util.Date;

//单例设计模式 运行时设计模式
public class RightInformation {
        private String Developers;
        private String testingPlatforms;
        private Date upDate;
        private static RightInformation rif;
        private RightInformation(){
            Developers = "CC1AH liang636600";
            testingPlatforms = "Nox-9.1 Honor-Mate-V10";
        }
        public static RightInformation getRightInformation(){
            if(rif == null){
                rif = new RightInformation();
            }
            return rif;
        }
        public String getInformation(){
            String output = "本项目的开发人员包括："+ Developers +
                            "\n本项目的测试平台有" + testingPlatforms;
            return output;
        }
    }
