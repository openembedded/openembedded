DESCRIPTION = "Dummy plugin for opie-security authentication. \
This is a very simple authentication plugin (you just have \
to press a button basically), for demonstration purpose."
APPNAME = "multiauthdummyplugin"

include opie-securityplugin.inc

S = "${WORKDIR}/dummy"

do_install() {
        install -d ${D}${palmtopdir}/pics/security
        install -m 0644 ${WORKDIR}/pics/security/dummyplugin.png ${D}${palmtopdir}/pics/security/
}

