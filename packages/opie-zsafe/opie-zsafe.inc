DESCRIPTION = "Password manager program for Opie."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "zsafe"


S = "${WORKDIR}/${APPNAME}"

inherit opie

QMAKE_PROFILES = "zsafe.pro"

# FILES bin/zsafe apps/Applications/zsafe.desktop pics/zsafe/zsafe.png
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

