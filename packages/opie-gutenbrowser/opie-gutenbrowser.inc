DESCRIPTION = "Etext reader for the Project Gutenberg."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-ftplib"
APPNAME = "gutenbrowser"


S = "${WORKDIR}/opie-gutenbrowser"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/etc/gutenbrowser/
	install -m 0644 ${WORKDIR}/etc/gutenbrowser/ftpList ${WORKDIR}/etc/gutenbrowser/GUTINDEX.ALL ${D}${palmtopdir}/etc/gutenbrowser/
}
