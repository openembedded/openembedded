SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "A simple set of utilities for reading, writing, and \
manipulating files in an ext2/ext3 filesystem."
DEPENDS = "e2fsprogs"
SRC_URI = "http://www.pobox.com/~sheff/sw/e2tools/e2tools-${PV}.tar.gz \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/e2tools-${PV}"

inherit autotools
