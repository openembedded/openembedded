DESCRIPTION = "Set the system time - utilizing ntpdate, if available."
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RRECOMMENDS = "ntpdate"
PV = "1.1.8+cvs-${CVSDATE}"

APPNAME = "systemtime"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/netsystemtime \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/etc \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/netsystemtime"

inherit opie

# FILES plugins/application/libsystemtime.so* bin/systemtime apps/Settings/systemtime.desktop etc/ntpservers pics/netsystemtime
do_install() {
        install -d ${D}${palmtopdir}/pics/netsystemtime/
        install -d ${D}${palmtopdir}/etc
        install -m 0644 ${WORKDIR}/pics/netsystemtime/*.png ${D}${palmtopdir}/pics/netsystemtime/
				install -m 0644 ${WORKDIR}/etc/ntpservers ${D}${palmtopdir}/etc
}

FILES_opie-systemtime_append = " /etc/ntpservers"
