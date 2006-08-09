DESCRIPTION = "Small utilities specific to the dreambox dvb receiver (for DVB v3)"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
PV = "1.2"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-dvb-tools-v3-${PV}.tar.gz"

inherit qmake

UTILS = "showiframe"

do_configure_prepend() {
	cd ${S}/
	echo -e "TEMPLATE=subdirs\nSUBDIRS=${UTILS}\n" >dmutils.pro
}

do_install() {
	install -d ${D}/${bindir}/
	for u in ${UTILS}
	do
		install -m 0755 ${S}/${u}/${u} ${D}/${bindir}/
	done
}
