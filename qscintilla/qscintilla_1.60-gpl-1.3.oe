DESCRIPTION = "Qt/Embedded bindings for the Scintilla source code editor component"
SECTION = "opie/libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/qscintilla-${PV}_zaurus.tar.gz"
S = "${WORKDIR}/qscintilla-${PV}/qt"

inherit opie

QMAKE_PROFILES = "qscintilla.pro"

do_stage() {
	install -m 0644 qextscintilla*.h ${STAGING_INCDIR}/
	install -m 0644 libqscintilla.a ${STAGING_LIBDIR}/
}
