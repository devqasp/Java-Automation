package br.com.selenium.java.automation.main;

import br.com.selenium.java.automation.sysinfo.SystemInfo;

public class MainClass {

	public static void showSysInfo() {
		SystemInfo sysInfo = new SystemInfo();
		System.out.println(sysInfo.getCpu());
		System.out.println(sysInfo.getOsName());
		System.out.println(sysInfo.getOsVersion());
		System.out.println(sysInfo.getRuntimeName());
		System.out.println(sysInfo.getVmName());
		System.out.println(sysInfo.getVmVendor());
		System.out.println(sysInfo.getVmVersion());
		System.out.println(sysInfo.getFreeMemory());
		System.out.println(sysInfo.getFreeMemoryKB());
		System.out.println(sysInfo.getTotalMemory());
		System.out.println(sysInfo.getTotalMemoryKB());
	}

	public static void main(String[] args) {
		showSysInfo();
	}
}