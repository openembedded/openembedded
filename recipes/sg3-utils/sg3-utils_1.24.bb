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

SRC_URI[md5sum] = "9e1b8811b013d8f97d8ea2e0942cebad"
SRC_URI[sha256sum] = "0a06dae84a8f7f464c0c29c78a8f73f24a62894a2d3fc10b5f74a993f7b5abfe"
