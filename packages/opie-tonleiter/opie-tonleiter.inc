DESCRIPTION = "Music scales for string instruments"
SECTION = "opie/multimedia"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "tonleiter"


S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

