DESCRIPTION = "The Concurrent Versioning System (cvs) client - Feature Version "
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPL"

SRC_URI = "http://musthave.sunbase.org/progs/ccvs/cvs-${PV}/cvs-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF = "--with-krb4=no --with-gssapi=no"
