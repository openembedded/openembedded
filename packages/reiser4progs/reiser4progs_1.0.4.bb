# This package builds tools to manipulate Reiser4 file systems,
# the libaal package must be built and installed as well to
# run these tools.
PR = "r1"
DESCRIPTION = "User-level tools for Reiser4 filesystems"
HOMEPAGE = "http://www.namesys.com"
SECTION = "base"
LICENSE = "GPLv2"

SRC_URI = "ftp://ftp.namesys.com/pub/${PN}/old-versions/${P}.tar.gz \
		file://oid40.c.patch;patch=1 \
		file://key_short.c.patch;patch=1 \
		file://key_large.c.patch;patch=1 \
		file://align.patch;patch=1"

LIBAAL = "libaal"

DEPENDS = "${LIBAAL}"

# This disables anything which uses libminimal - that library
# is used for boot loader stuff and so is not required unless
# the system will boot from a Reiser4 file system, the same
# setting must exist for the LIBAAL build
DISABLE_LIBMINIMAL ?= "--disable-libminimal"
EXTRA_OECONF = "${DISABLE_LIBMINIMAL}"

LEAD_SONAME = "libreiser4"

inherit autotools
