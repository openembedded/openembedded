DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "zlib"
PV = "1.0.5"
PR = "1"
LICENSE = "BSD"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack
  
#SRC_URI = "file://./"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/edb"
S = "${WORKDIR}/edb"
  
inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--disable-gtk \
		--disable-ncurses"

do_stage () {
  oe_libinstall -C src libedb ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/Edb.h ${STAGING_INCDIR}/
}

FILES_${PN} = "${libdir}/libedb*.so*"
FILES_${PN}-dev += "${bindir} ${libdir}/pkgconfig"

