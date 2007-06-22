DESCRIPTION = "LyX is an advanced type setting processor - a frontend for LaTeX"
SECTION = "x11/office"
LICENSE = "GPL"
HOMEPAGE = "http://www.lyx.org"
DEPENDS = "boost qt4-x11-free"
RRECOMMENDS = "tetex"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

# we're checking out from svn because the tarball doesn't contain the necessary stuff to run autoreconf
SRC_URI = "svn://svn.lyx.org/lyx/lyx-devel/tags;module=lyx_1_5_0rc1;rev=18613"
S = "${WORKDIR}/lyx_1_5_0rc1"

inherit autotools qt4x11

EXTRA_OECONF = " --with-qt4-dir=${QTDIR} -enable-pch"
PARALLEL_MAKE = ""

do_configure_prepend() {
	echo "NOTE: touching missing files, please report to upstream"
	touch lib/configure.ac lib/doc/LaTeXConfig.lyx lib/textclass.lst
}

export UIC="${OE_QMAKE_UIC}"
export MOC="${OE_QMAKE_MOC}"
