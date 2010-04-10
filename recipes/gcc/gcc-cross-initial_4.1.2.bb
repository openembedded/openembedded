require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

EXTRA_OECONF += "--disable-libmudflap \
		--disable-libssp"

SRC_URI[md5sum] = "a4a3eb15c96030906d8494959eeda23c"
SRC_URI[sha256sum] = "cfc0efbcc6fcde0d416a32dfb246c9df022515a312683fac412578c4fd09a9bc"
