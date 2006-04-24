DESCRIPTION = "Bootchart is a tool for performance analysis and visualization of the GNU/Linux boot process."
LICENSE = "GPLv2"
HOMEPAGE = "http://www.bootchart.org/"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"


#this only installs the loggers, you will need to run the renderers on your workstation 
#boot with 'init=/sbin/bootchartd' and do '/sbin/bootchartd stop' to end the logging

#needed for a real /bin/sh and /bin/sleep
DEPENDS = "bash coreutils"
RDEPENDS = "bash coreutils"

#this is a plain shell script
PACKAGE_ARCH = "all"

SRC_URI = "file://bootchart \
	   file://bootchartd \
	   file://bootchartd.conf"

 		
do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc
	install -m 755 ${WORKDIR}/bootchart ${D}/sbin
	install -m 755 ${WORKDIR}/bootchartd ${D}/sbin
	install -m 644 ${WORKDIR}/bootchart ${D}/etc
}

