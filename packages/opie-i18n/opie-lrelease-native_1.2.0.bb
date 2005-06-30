DESCRIPTION = "Opie native i18n tool lrelease"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Holger Freyther <zecke@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "uicmoc3-native"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/development/translation/opie-lrelease \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/development/translation/shared"

S = "${WORKDIR}/opie-lrelease"

inherit native qmake

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST_append = "LIBS+=-ldl"

do_stage() {
	install -m 0755 opie-lrelease ${STAGING_BINDIR}/
}
