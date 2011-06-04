DESCRIPTION = "Qt-based class wrapper of libetpan"
SECTION = "opie/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libetpan"

S = "${WORKDIR}/libmailwrapper"

inherit opie

do_install() {
    oe_libinstall -so libmailwrapper ${D}${libdir}
    install -d ${D}${includedir}/libmailwrapper/
    install -m 0664 ${S}/maildefines.h ${D}${includedir}/libmailwrapper/
    install -m 0664 ${S}/settings.h ${D}${includedir}/libmailwrapper/
    install -m 0664 ${S}/statusmail.h ${D}${includedir}/libmailwrapper/
    install -m 0664 ${S}/abstractmail.h ${D}${includedir}/libmailwrapper/
    install -m 0664 ${S}/mailtypes.h ${D}${includedir}/libmailwrapper/
}
