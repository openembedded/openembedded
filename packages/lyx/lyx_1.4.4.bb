DESCRIPTION = "LyX is an advanced type setting processor - a frontend for LaTeX"
SECTION = "x11/office"
LICENSE = "GPL"
HOMEPAGE = "http://www.lyx.org"
DEPENDS = "boost"
RRECOMMENDS = "tetex"
PR = "r0"

# we're checking out from svn because the tarball doesn't contain the necessary stuff to run autoreconf
SRC_URI = "svn://svn.lyx.org/lyx/lyx-devel/tags;module=lyx-1_4_4;rev=17185"
S = "${WORKDIR}/lyx-1_4_4"

inherit qt3x11 autotools

EXTRA_OECONF = "--with-frontend=qt --with-qt-dir=${QTDIR}"
PARALLEL_MAKE = ""

do_configure_prepend() {
	echo "NOTE: touching missing files, please report to upstream"
	touch lib/configure.ac lib/doc/LaTeXConfig.lyx lib/textclass.lst
}

export UIC="${OE_QMAKE_UIC}"
export MOC="${OE_QMAKE_MOC}"
