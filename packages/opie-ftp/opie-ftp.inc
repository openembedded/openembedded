DESCRIPTION = "Opie-Ftp"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopiecore2 opie-ftplib"
APPNAME = "opieftp"
I18N_FILES = "opieftp.ts"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libopieftp.so* bin/opieftp pics/opieftp apps/Applications/opieftp.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

