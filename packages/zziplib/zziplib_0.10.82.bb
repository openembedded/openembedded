DESCRIPTION = "Support library for dealing with zip files"
SECTION = "libs"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/zziplib/zziplib-${PV}.tar.bz2"
LICENSE = "LGPL MPL"
inherit autotools pkgconfig

do_stage() {
	oe_libinstall -a -so -C zzip libzzip ${STAGING_LIBDIR}
	oe_libinstall -a -so -C zzipwrap libzzipwrap ${STAGING_LIBDIR}
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 ${S}/bins/zziplib.m4 ${STAGING_DATADIR}/aclocal/
	for h in zzip.h zzipformat.h zzipwrap.h zziplib.h zzip-io.h; do
		install -m 0644 ${S}/zziplib/$h ${STAGING_INCDIR}/
	done
	install -d ${STAGING_INCDIR}/zzip
	for h in lib.h format.h _msvc.h conf.h file.h stdint.h zzip.h _config.h plugin.h; do
		install -m 0644 ${S}/zzip/$h ${STAGING_INCDIR}/zzip/
	done
}
