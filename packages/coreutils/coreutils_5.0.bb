LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "A collection of core GNU utilities."
RREPLACES = "textutils shellutils fileutils"
RPROVIDES = "textutils shellutils fileutils"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/coreutils/coreutils-${PV}.tar.gz \
	   file://malloc.patch;patch=1 \
	   file://configure.patch;patch=1"

inherit autotools

export EXTRA_OEMAKE="'SUBDIRS=lib src doc m4 po tests' MAKEFLAGS="
