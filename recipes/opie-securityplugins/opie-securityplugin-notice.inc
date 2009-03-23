DESCRIPTION = "Notice plugin for opie-security authentication. \
It allows you to display, for example, a notice from your legal departement."
APPNAME = "multiauthnoticeplugin"

include opie-securityplugin.inc

S = "${WORKDIR}/notice"

do_install() {
        install -d ${D}${palmtopdir}/pics/security/
        install -m 0644 ${WORKDIR}/pics/security/noticeplugin*.png ${D}${palmtopdir}/pics/security/
}

