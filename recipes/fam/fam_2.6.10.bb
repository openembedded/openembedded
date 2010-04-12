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


SRC_URI[md5sum] = "1c5a2ea659680bdd1e238d7828a857a7"
SRC_URI[sha256sum] = "885ced3480aef3cee519a459a572e31cd2fd5e24bcd35b1d0c8833361699026e"
