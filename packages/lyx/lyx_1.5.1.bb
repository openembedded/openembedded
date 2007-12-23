DESCRIPTION = "LyX is an advanced type setting processor - a frontend for LaTeX"
SECTION = "x11/office"
LICENSE = "GPL"
HOMEPAGE = "http://www.lyx.org"
DEPENDS = "boost qt4-x11-free"
RSUGGESTS = "tetex"
RDEPENDS = "python-shell python-textutils"
PR = "r0"

SRC_URI = "http://lyx.cybermirror.org/stable/lyx-${PV}.tar.bz2"

inherit qt4x11 autotools

EXTRA_OECONF = " --with-qt4-dir=${QTDIR} -enable-pch"
EXTRA_QMAKEVARS_POST = "DEFINES+=_LIBC"
PARALLEL_MAKE = ""

do_configure_prepend() {
	echo "NOTE: touching missing files, please report to upstream"
	touch lib/configure.ac lib/doc/LaTeXConfig.lyx lib/textclass.lst
}

export UIC="${OE_QMAKE_UIC}"
export MOC="${OE_QMAKE_MOC}"
export OE_QMAKE_LIBS_X11="-lX11 -lXext"
