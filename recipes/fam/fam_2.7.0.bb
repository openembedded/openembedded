DESCRIPTION = "File Alteration Monitor"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL"

SRC_URI = "ftp://oss.sgi.com/projects/fam/download/stable/fam-${PV}.tar.gz \
	   file://compile-fix.patch;patch=1"

inherit autotools

CPPFLAGS_append = " -DNDEBUG"

do_stage() {
	oe_libinstall -so -a -C lib libfam ${STAGING_LIBDIR}/
	install -m 0644 ${S}/include/fam.h ${STAGING_INCDIR}/
}


SRC_URI[md5sum] = "1bf3ae6c0c58d3201afc97c6a4834e39"
SRC_URI[sha256sum] = "1e0aa136693a3e9f4b43ebd71e7bd934cea31817a4a6cba2edc7aac353b8a93f"
