DESCRIPTION = "Patcher is a perl script for managing patches."
HOMEPAGE = "http://www.holgerschurig.de/patcher.html"
LICENSE = "Perl"
DEPENDS = ""
SECTION = "base"
PRIORITY = "optional"
PACKAGES = ""
PR = "r1"

inherit native

SRC_URI = "http://www.holgerschurig.de/files/linux/patcher-${PV}.tar.bz2"
SRC_URI_append_build-freebsd = " file://freebsd_gpatch.patch;patch=1 "
S = "${WORKDIR}/patcher"

PATCHTOOL = "patch"

do_stage() {
	install -m 0755 patcher.py ${STAGING_BINDIR}/patcher
}
