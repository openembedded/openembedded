DESCRIPTION = "Music scales for string instruments"
SECTION = "opie/multimedia"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "tonleiter"
APPTYPE = "binary"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/multimedia/tonleiter \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES bin/tonleiter pics/tonleiter apps/Applications/tonleiter.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

