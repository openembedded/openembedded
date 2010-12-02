require bug-app.inc

DESCRIPTION = "This library provides graphing utilities for use on the BUG. \
Data can be specified discretely or as a stream (such as the VonHippel's ADC or serial port input)\
Currently there is a scrolling line graph, a horizontal bar graph, a vertical bar graph and a vertical histogram. Any combination can be on screen at the same time. \
Note: It requires the SWT library application and display provider to work.\
The current version is extremely rough. "
HOMEPAGE = "http://buglabs.net/applications/BUGGraph"

DEPENDS += "service-tracker com.buglabs.bug.module.lcd com.buglabs.app.swtdisplayprovider com.buglabs.app.libswt com.buglabs.common com.buglabs.osgi "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/911"

APIVERSION = ""

BROKEN = "1"
