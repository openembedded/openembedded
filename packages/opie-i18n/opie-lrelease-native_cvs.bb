DESCRIPTION = "Opie native i18n tool lrelease"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Holger Freyther <zecke@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "uicmoc3-native"
PV = "1.2.0+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/development/translation/opie-lrelease \
           ${HANDHELDS_CVS};module=opie/development/translation/shared"

S = "${WORKDIR}/opie-lrelease"

inherit native qmake

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST_append = "LIBS+=-ldl"

do_stage() {
	install -m 0755 opie-lrelease ${STAGING_BINDIR}/
}
