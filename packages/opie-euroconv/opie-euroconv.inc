DESCRIPTION = "Euroconv"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "euroconv"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libeuroconv.so* bin/euroconv pics/euroconv/* apps/Applications/euroconv.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

