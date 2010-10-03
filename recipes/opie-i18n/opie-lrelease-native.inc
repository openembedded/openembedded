DESCRIPTION = "Opie native i18n tool lrelease"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "uicmoc3-native"
INC_PR = "r1"

S = "${WORKDIR}/opie-lrelease"

inherit native qmake qt3e

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST_append = "LIBS+=-ldl"

do_install() {
        install -d ${D}${bindir}/
        install -m 0755 opie-lrelease ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"
