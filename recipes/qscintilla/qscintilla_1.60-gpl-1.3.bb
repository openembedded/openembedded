DESCRIPTION = "Qt/Embedded bindings for the Scintilla source code editor component"
SECTION = "opie/libs"
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

SRC_URI[md5sum] = "3823bdfc40af13adcfd5f44e6dae5cf0"
SRC_URI[sha256sum] = "5df3def9192f704c52ee3ddcf4388a2977f237be1663353a97d836b69cc4f811"
