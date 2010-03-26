require tzdata.inc

SRC_URI = "http://ftp.uni-erlangen.de/pub/Linux/MIRROR.gentoo/distfiles/tzdata${PV}.tar.gz;name=tar \
	file://russia-2010.diff;patch=1"
SRC_URI[tar.md5sum] = "4a0e2a3594210fafc5c55b5247018618"
SRC_URI[tar.sha256sum] = "823361e38da3f79a34c0adb835b1b6d2ae640937e3f7a7f4a2181500eeff0e94"
PR = "${INC_PR}.1"