DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "zlib"
LICENSE = "BSD"
PR = "r0"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack
  
SRC_URI = "http://enlightenment.freedesktop.org/files/edb-${PV}.tar.gz"
S = "${WORKDIR}/edb-${PV}"
  
inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--disable-gtk \
		--disable-ncurses"

do_stage () {
  oe_libinstall -C src libedb ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/Edb.h ${STAGING_INCDIR}/
}

FILES_${PN} = "${libdir}/libedb*.so*"
FILES_${PN}-dev += "${bindir} ${libdir}/pkgconfig"

