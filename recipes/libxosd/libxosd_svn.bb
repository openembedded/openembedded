DESCRIPTION = "A library for displaying a TV-like on-screen display in X."
SECTION = "libs/x11"
DEPENDS = "virtual/libx11 libxext"
LICENSE = "LGPL"
SRCREV = "627"
PV = "2.2.15+svnr${SRCPV}"
PR = "r6"

SRC_URI = "svn://libxosd.svn.sourceforge.net/svnroot/libxosd/source;module=current;proto=https \
           file://autofoo.patch \
           file://use-sane-default-font.patch \
           file://fix_duplicate_xosd_is_onscreen.patch \
           "

S = "${WORKDIR}/current"

inherit autotools binconfig

PACKAGES =+ "${PN}-examples-dbg ${PN}-examples"
FILES_${PN}-examples = "${bindir}/osd_cat"
FILES_${PN}-examples-dbg += "${bindir}/.debug/"
FILES_${PN}-dev += "${bindir}/xosd-config"
FILES_${PN} = "${libdir}/libxosd.so.*"
