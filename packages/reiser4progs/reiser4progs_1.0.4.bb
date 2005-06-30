# This package builds tools to manipulate Reiser4 file systems,
# the libaal package must be built and installed as well to
# run these tools.
PR = "r0"
DESCRIPTION = "User-level tools for Reiser4 filesystems"
HOMEPAGE = "http://www.namesys.com"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "base"
LICENSE = "GPL-2"

SRC_URI = "ftp://ftp.namesys.com/pub/${PN}/${P}.tar.gz \
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
