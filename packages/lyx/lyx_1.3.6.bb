DESCRIPTION = "LyX is an advanced type setting processor - a frontend for LaTeX"
SECTION = "x11/office"
LICENSE = "GPL"
HOMEPAGE = "http://www.lyx.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "boost qt3x11"
RRECOMMENDS = "tetex"
PR = "r1"

SRC_URI = "ftp://ftp.lyx.org/pub/lyx/stable/lyx-${PV}.tar.bz2"

inherit autotools qt3x11

EXTRA_OECONF = "--with-frontend=qt --with-qt-dir=${QTDIR}"

export UIC="${OE_QMAKE_UIC}"
export MOC="${OE_QMAKE_MOC}"

do_configure() {
	oe_runconf
}

do_install_append() {
	for i in noweb2lyx lyx reLyX
	do
		ln -sf ./${TARGET_PREFIX}$i ${D}/${bindir}/$i
	done
}

