DESCRIPTION = "The Concurrent Versioning System (cvs) client - Feature Version "
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPL"

SRC_URI = "https://cvs.cvshome.org/files/documents/19/170/cvs-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF = "--with-krb4=no --with-gssapi=no"
