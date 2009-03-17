DESCRIPTION = "PIN plugin for opie-security authentication. \
It implements the same kind of widgets as opie-security package, \
but this implementation can be used along with other authentication \
methods in the Opie Multi-Authentication Framework."
APPNAME = "multiauthpinplugin"

include opie-securityplugin.inc

S = "${WORKDIR}/pin"

do_install() {
        install -d ${D}${palmtopdir}/pics/security/
        install -m 0644 ${WORKDIR}/pics/security/pinplugin.png ${D}${palmtopdir}/pics/security/
}

