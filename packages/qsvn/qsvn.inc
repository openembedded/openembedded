DESCRIPTION = "QSvn is a graphical Subversion client for Linux, UNIX, Mac OS X and Windows. \
It is written in C++ using the Qt4 toolkit from Trolltech."
HOMEPAGE = "http://ar.oszine.de/projects/qsvn/"
AUTHOR = "Andreas Richter, Rajko Albrecht"
LICENSE = "GPL"
SECTION = "network"
DEPENDS = "apr-util subversion"
PR = "r0"

def vars_from_file(filename):
    import os
    return os.path.splitext(os.path.basename(filename))[0]

FN := "${@vars_from_file(bb.data.getVar('FILE',d))}"

SRC_URI = "http://download2.berlios.de/${FN}/${FN}-${PV}-src.tar.gz \
        file://build.patch;patch=1"
S = "${WORKDIR}/${FN}-${PV}"

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/subversion-1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 bin/qsvn ${D}${bindir}/${PN}
}
