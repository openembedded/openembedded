DESCRIPTION = "The Concurrent Versioning System (cvs) client - Feature Version "
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPL"

SRC_URI = "http://musthave.sunbase.org/progs/ccvs/cvs-${PV}/cvs-${PV}.tar.bz2 \
	   file://m4.patch;patch=1"

inherit autotools gettext

EXTRA_OECONF = "--with-krb4=no --with-gssapi=no"

SRC_URI[md5sum] = "41396dfe38c3c9f80de98ea53e6d55aa"
SRC_URI[sha256sum] = "00383a2c79ea0956b2d4adb772895648ea774f46186d3e19a2f263c73a846963"
