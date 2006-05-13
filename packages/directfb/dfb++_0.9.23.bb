DESCRIPTION = "A C++ Wrapper for the directfb framebuffer library."
HOMEPAGE = "http://directfb.org"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "directfb"
LICENSE = "LGPL"

# needs a g++4 patch
BROKEN = "1"

SRC_URI = "http://www.directfb.org/downloads/Extras/DFB++-${PV}.tar.gz"
S = "${WORKDIR}/DFB++-${PV}"

inherit autotools pkgconfig

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
