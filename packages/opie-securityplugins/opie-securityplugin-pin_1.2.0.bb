DESCRIPTION = "PIN plugin for opie-security authentication. \
It implements the same kind of widgets as opie-security package, \
but this implementation can be used along with other authentication \
methods in the Opie Multi-Authentication Framework."
SECTION = "opie/security"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
I18N_FILES = "libmultiauthpinplugin.ts"
RDEPENDS = "opie-security"

APPNAME = "multiauthpinplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/securityplugins/pin \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics "

S = "${WORKDIR}/pin"

inherit opie

# FILES plugins/security/libmultiauthpinplugin.so* pics/security/pinplugin.png
do_install() {
        install -d ${D}${palmtopdir}/pics/security/
        install -m 0644 ${WORKDIR}/pics/security/pinplugin.png ${D}${palmtopdir}/pics/security/
}

