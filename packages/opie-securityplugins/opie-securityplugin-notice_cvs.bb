DESCRIPTION = "Notice plugin for opie-security authentication. \
It allows you to display, for example, a notice from your legal departement."
SECTION = "opie/security"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
I18N_FILES = "libmultiauthnoticeplugin.ts"
RDEPENDS = "opie-security"
PV = "1.2.0+cvs-${CVSDATE}"
APPNAME = "multiauthnoticeplugin"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/securityplugins/notice \
           ${HANDHELDS_CVS};module=opie/pics "

S = "${WORKDIR}/notice"

inherit opie

# FILES plugins/security/libmultiauthnoticeplugin.so* pics/security/noticeplugin.png pics/security/noticeplugin_small.png
do_install() {
        install -d ${D}${palmtopdir}/pics/security/
        install -m 0644 ${WORKDIR}/pics/security/noticeplugin*.png ${D}${palmtopdir}/pics/security/
}

