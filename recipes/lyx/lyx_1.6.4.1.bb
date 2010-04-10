DESCRIPTION = "LyX is an advanced type setting processor - a frontend for LaTeX"
SECTION = "x11/office"
LICENSE = "GPL"
HOMEPAGE = "http://www.lyx.org"
DEPENDS = "qt4-x11-free"
RSUGGESTS = "tetex"
RDEPENDS = "python-shell python-textutils"

SRC_URI = "\
  ftp://ftp.lyx.org/pub/lyx/stable/1.6.x/lyx-${PV}.tar.bz2 \
  file://no-session-manager.patch;patch=1 \
  file://qt4tools-detect.diff;patch=1 \
"

inherit qt4x11 autotools

EXTRA_OECONF = "\
  --with-qt4-dir=${QTDIR} \
  --enable-threads=posix \
"

do_configure_prepend() {
	rm -f ${S}/config/libtool.m4
}

EXTRA_QMAKEVARS_POST = "DEFINES+=_LIBC"
PARALLEL_MAKE = ""


SRC_URI[md5sum] = "c1a0da5aee3b7e1a2f74e8018805c7b1"
SRC_URI[sha256sum] = "56f3120f814de0fc55866d92b08b2513ad0d0532fc6675aeaf36154eb73c403b"
