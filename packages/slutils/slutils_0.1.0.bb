DESCRIPTION = "Console utilities for certain hardware aspects of Sharp Linux based Zaurii"
DESCRIPTION_slfb = "A command-line utility to turn on/off the FrameBuffer on Linux 2.4-based Zaurii"
DESCRIPTION_slbl = "A command-line utility to control the BackLight on Linux 2.4-based Zaurii"
DESCRIPTION_sltime = "A ustility to save and restore the time on Sharp Linux based Zaurii"
SECTION = "console/utils"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r4"

inherit qmake update-rc.d

SRC_URI = "file://sltime.sh"

INITSCRIPT_NAME = "sltime"
INITSCRIPT_PARAMS = "defaults 5"

export UTILS = "sltime slbl slfb"

do_fetch() {
	for u in ${UTILS}
	do
		install -d ${S}/$u
		cp -dfR `ls -dp ${FILESDIR}/$u/*|grep -v SCCS` ${S}/$u/
	done
}

do_configure_prepend() {
	cd ${S}/
        echo -e "TEMPLATE=subdirs\nSUBDIRS=${UTILS}\n" >slutils.pro
}

do_install() {
        install -d ${D}${sbindir}
	for u in ${UTILS}
	do
		install -m 0755 ${S}/${u}/${u} ${D}${sbindir}/
	done
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/sltime.sh ${D}${sysconfdir}/init.d/sltime
}

PACKAGES =+ "slbl slfb"
FILES_slbl = "${sbindir}/slbl"
FILES_slfb = "${sbindir}/slfb"

