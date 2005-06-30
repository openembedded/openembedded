DESCRIPTION = "Opie native i18n tool lupdate"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Holger Freyther <zecke@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "uicmoc3-native"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/development/translation/opie-lupdate \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/development/translation/shared"

S = "${WORKDIR}/opie-lupdate"

inherit native qmake

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST_append = "LIBS+=-ldl "
EXTRA_QMAKEVARS_POST_append = "CONFIG-=thread "

do_stage() {
	install -m 0755 opie-lupdate ${STAGING_BINDIR}/
}
