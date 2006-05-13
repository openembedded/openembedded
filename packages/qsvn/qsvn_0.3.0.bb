DESCRIPTION = "QSvn is a graphical Subversion client for Linux, UNIX, Mac OS X and Windows. \
It is written in C++ using the Qt4 toolkit from Trolltech."
HOMEPAGE = "http://ar.oszine.de/projects/qsvn/"
AUTHOR = "Andreas Richter, Rajko Albrecht"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SECTION = "network"
DEPENDS = "apr-util subversion"
PR = "r0"

SRC_URI = "http://download2.berlios.de/qsvn/qsvn-${PV}-src.tar.gz"

inherit qmake qt4x11

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/subversion-1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 bin/qsvn ${D}${bindir}
}
