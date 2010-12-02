require bug-osgi.inc
PR = "${INC_PR}.2+svnr${SRCREV}"
DEPENDS += "com.buglabs.common com.buglabs.bug.module com.buglabs.bug.module.lcd com.buglabs.bug.base" 
JAVAC_OPTIONS="-source 1.6"
