DESCRIPTION = "Blueping plugin for opie-security authentication. \
This is a bluetooth-based authentication plugin (you need \
to have another Bluetooth device around to use it)."
SECTION = "opie/security"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
I18N_FILES = "libmultiauthbluepingplugin.ts"
RDEPENDS = "opie-security bluez-utils"

APPNAME = "multiauthbluepingplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/securityplugins/blueping \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics "

S = "${WORKDIR}/blueping"

inherit opie

# FILES plugins/security/libmultiauthbluepingplugin.so* pics/security/bluepingplugin.png root/etc/suspend-scripts/S50bluetooth
do_install() {
        install -d ${D}${palmtopdir}/pics/security/
        install -m 0644 ${WORKDIR}/pics/security/bluepingplugin.png ${D}${palmtopdir}/pics/security/
}

