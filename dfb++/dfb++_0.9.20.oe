DESCRIPTION = "A C++ Wrapper for the directfb framebuffer library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "directfb"

LICENSE = "LGPL"

SRC_URI = "http://www.directfb.org/download/DirectFB/DFB++-${PV}.tar.gz"
S = "${WORKDIR}/DFB++-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = ""

do_stage() {
        oe_runmake -C include 'libdir=/lib' 'includedir=/include/dfb++' \
                          'oldincludedir=/include' 'datadir=/share' \
                          'DESTDIR=${STAGING_LIBDIR}/..' \
                          install-dfbppincludeHEADERS
        oe_runmake -C dfb++ 'libdir=/lib' 'includedir=/include/dfb++' \
                          'oldincludedir=/include' 'datadir=/share' \
              'DESTDIR=${STAGING_LIBDIR}/..' \
              install-libLTLIBRARIES
}


do_install() {
        oe_runmake 'DESTDIR=${D}' install
}
