SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "A simple set of utilities for reading, writing, and \
manipulating files in an ext2/ext3 filesystem."
DEPENDS = "e2fsprogs"
SRC_URI = "http://www.pobox.com/~sheff/sw/e2tools/e2tools-${PV}.tar.gz \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/e2tools-${PV}"

inherit autotools

SRC_URI[md5sum] = "1829b2b261e0e0d07566066769b5b28b"
SRC_URI[sha256sum] = "4e3c8e17786ccc03fc9fb4145724edf332bb50e1b3c91b6f33e0e3a54861949b"
