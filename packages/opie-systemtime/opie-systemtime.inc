DESCRIPTION = "Set the system time - utilizing ntpdate, if available."
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RRECOMMENDS = "ntpdate"

APPNAME = "systemtime"


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
