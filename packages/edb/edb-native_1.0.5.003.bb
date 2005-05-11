DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
LICENSE = "BSD"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
SECTION = "e/libs"
PRIORITY = "optional"
include edb_${PV}.bb
inherit native
DEPENDS = "zlib-native"

do_stage () {
  install -m 0755 tools/.libs/edb_ed ${STAGING_BINDIR}
  oe_libinstall -C src libedb ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/Edb.h ${STAGING_INCDIR}/
}
