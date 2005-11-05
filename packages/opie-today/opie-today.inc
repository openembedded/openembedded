DESCRIPTION = "Today screen application"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "today"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libtoday.so* bin/today apps/1Pim/today.desktop pics/today/* 
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

