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

SRC_URI[md5sum] = "08649756a41358b24e1857201a90f8bf"
SRC_URI[sha256sum] = "bad7cc70c773ecc05edf7d511f37f50a3e753fa8cddea0a81f2fc8f582a10489"
