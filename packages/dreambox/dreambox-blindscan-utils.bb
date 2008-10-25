DESCRIPTION = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
PV = "1.0"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-${MACHINE}-1.0.tar.bz2"

PV_dm500plus = "1.1"
SRC_URI_dm500plus = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-${MACHINE}-1.1.tar.bz2"

PV_dm600pvr = "1.2"
SRC_URI_dm600pvr = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-${MACHINE}-1.2.tar.bz2"

S = "${WORKDIR}/blindscan-utils"

do_install() {
	install -d ${D}/${bindir}/
	for i in `find ${S} -type f -maxdepth 1`; do 
		install -m 0755 $i ${D}/${bindir}/;
	done;
}
