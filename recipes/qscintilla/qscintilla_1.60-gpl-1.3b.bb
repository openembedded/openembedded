DESCRIPTION = "Qt/Embedded bindings for the Scintilla source code editor component"
SECTION = "opie/libs"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.mneuroth.de/privat/zaurus/qscintilla-${PV}_zaurus.tar.gz"
S = "${WORKDIR}/qscintilla-1.60-gpl-1.3/qt"

inherit opie

QMAKE_PROFILES = "qscintilla.pro"

do_stage() {
	install -m 0644 qextscintilla*.h ${STAGING_INCDIR}/
	install -m 0644 libqscintilla.a ${STAGING_LIBDIR}/
}

SRC_URI[md5sum] = "44939519d6623596d874b73695176fef"
SRC_URI[sha256sum] = "605ce768faedaebcfcff86c3e720c23a114f63850c4f4e975f83de01171a89e0"
