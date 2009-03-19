DESCRIPTION = "Bootchart is a tool for performance analysis and visualization of the GNU/Linux boot process."
LICENSE = "GPLv2"
HOMEPAGE = "http://www.bootchart.org/"
PR = "r1"

#this only installs the loggers, you will need to run the renderers on your workstation
#boot with 'init=/sbin/bootchartd' and do '/sbin/bootchartd stop' to end the logging

#needed for a real /bin/sh and /bin/sleep
DEPENDS = "bash coreutils acct"
RDEPENDS = "bash coreutils acct"

#this is a plain shell script
PACKAGE_ARCH = "all"

SRC_URI = "${SOURCEFORGE_MIRROR}/bootchart/bootchart-${PV}.tar.bz2\
           file://handheld.patch;patch=1"


do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc
	install -d ${D}/bootchart
	install -m 755 ${S}/script/bootchartd ${D}/sbin
	install -m 644 ${S}/script/bootchartd.conf ${D}/etc
}

