DESCRIPTION = "File Alteration Monitor"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL"

SRC_URI = "ftp://oss.sgi.com/projects/fam/download/stable/fam-${PV}.tar.gz \
	   file://rpcsvc.patch;patch=1"

inherit autotools 

CPPFLAGS_append = " -DNDEBUG"

do_stage() {
	oe_libinstall -so -a -C libfam libfam ${STAGING_LIBDIR}/
	install -m 0644 ${S}/include/fam.h ${STAGING_INCDIR}/
}

