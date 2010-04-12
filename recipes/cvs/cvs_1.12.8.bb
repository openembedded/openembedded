DESCRIPTION = "The Concurrent Versioning System (cvs) client - Feature Version "
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPL"

SRC_URI = "http://musthave.sunbase.org/progs/ccvs/Old/cvs-${PV}/cvs-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF = "--with-krb4=no --with-gssapi=no"

SRC_URI[md5sum] = "d320e4429755019e5058e726de753472"
SRC_URI[sha256sum] = "52783a5b8bd195b1fa50453dfd5949e23a787d0db56f6acd3bbd92aad0f486fe"
