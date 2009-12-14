DESCRIPTION = "Utilities for working with generic SCSI devices"
AUTHOR = "Eric Schwartz (Skif) <emschwar@debian.org>"
HOMEPAGE = "http://packages.qa.debian.org/s/sg3-utils.html"
SECTION = "console/admin"
LICENSE = "GPLv2"
AUTHOR = "Eric Schwartz (Skif) <emschwar@debian.org>"
PR = "r2"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "${DEBIAN_MIRROR}/main/s/sg3-utils/sg3-utils_${PV}.orig.tar.gz \
	file://Makefile-r1.patch;patch=1"

S = "${WORKDIR}/sg3-utils-${PV}"

inherit autotools

EXTRA_OEMAKE='"LIBTOOL=${STAGING_BINDIR_NATIVE}/${HOST_SYS}-libtool"'
