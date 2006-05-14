DESCRIPTION = "LyX is an advanced type setting processor - a frontend for LaTeX"
SECTION = "x11/office"
LICENSE = "GPL"
HOMEPAGE = "http://www.lyx.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "boost"
RRECOMMENDS = "tetex"
PR = "r1"

# we're checking out from svn because the tarball doesn't contain the necessary stuff to run autoreconf
SRC_URI = "svn://svn.lyx.org/lyx/lyx-devel/tags;module=lyx-1_4_1;rev=13847"
S = "${WORKDIR}/lyx-1_4_1"

inherit autotools qt3x11

EXTRA_OECONF = "--with-frontend=qt --with-qt-dir=${QTDIR}"
PARALLEL_MAKE = ""

do_configure_prepend() {
	echo "NOTE: touching missing files, please report to upstream"
	touch lib/configure.ac lib/doc/LaTeXConfig.lyx lib/textclass.lst
}

export UIC="${OE_QMAKE_UIC}"
export MOC="${OE_QMAKE_MOC}"
