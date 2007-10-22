DESCRIPTION = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
PV = "1.0"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-${MACHINE}-1.0.tar.bz2"
SRC_URI_dm600pvr = "http://sources.dreamboxupdate.com/download/opendreambox/dreambox-blindscan-utils-${MACHINE}-1.1.tar.bz2"
PR_dm600pvr = "r1"

S = "${WORKDIR}/blindscan-utils"

do_install() {
	install -d ${D}/${bindir}/
	for i in `find ${S} -type f -maxdepth 1`; do 
		install -m 0755 $i ${D}/${bindir}/;
	done;
}
