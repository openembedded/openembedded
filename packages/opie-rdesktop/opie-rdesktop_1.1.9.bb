DESCRIPTION = "Remote Desktop Protocol (RDP) Client"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
I18N_FILES = "ordesktop.ts"
DEPENDS = "openssl"

APPNAME = "ordesktop"
APPTYPE = "binary"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/opierdesktop \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"

S = "${WORKDIR}/opierdesktop"

inherit opie

# FILES bin/ordesktop pics/opierdesktop apps/Applications/opierdesktop.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/opierdesktop/
        install -m 0644 ${WORKDIR}/pics/opierdesktop/*.png ${D}${palmtopdir}/pics/opierdesktop/ 
}
