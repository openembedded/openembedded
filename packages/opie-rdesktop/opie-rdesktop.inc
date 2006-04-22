DESCRIPTION = "Remote Desktop Protocol (RDP) Client"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "openssl"
I18N_FILES = "ordesktop.ts"
APPNAME = "ordesktop"
APPTYPE = "binary"


S = "${WORKDIR}/opierdesktop"

inherit opie

# FILES bin/ordesktop pics/opierdesktop apps/Applications/opierdesktop.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/opierdesktop/
        install -m 0644 ${WORKDIR}/pics/opierdesktop/*.png ${D}${palmtopdir}/pics/opierdesktop/ 
}
