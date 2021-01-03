package com.test.spring;

import com.test.base.tcl.huaxing;

public class Test {
    public static void main(String[] args) {
        try {
            huaxing.doPost("https://ebus.csot.tcl.com/uploadByPair1", "ccw", "d3fb24ff-ac99-4bf6-a2d3-e28ead1457ed", "C:\\Users\\hongyuan.tong\\Desktop\\ZipFile_20201023094353306\\1100717351.pdf", "pdf", "1100717351");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//
//    var url = 'https://ebus.csot.tcl.com/csotfastfile-web/file/uploadByPair1';
//    var appId = 'ccw';
//    var token = 'd3fb24ff-ac99-4bf6-a2d3-e28ead1457ed';