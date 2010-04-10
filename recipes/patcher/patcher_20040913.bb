DESCRIPTION = "Patcher is a perl script for managing patches."
HOMEPAGE = "http://www.holgerschurig.de/patcher.html"
LICENSE = "Perl"
DEPENDS = ""
SECTION = "base"
PRIORITY = "optional"
INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "http://www.holgerschurig.de/files/linux/patcher-${PV}.tar.bz2"
S="${WORKDIR}/patcher"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 patcher.py ${D}${bindir}/patcher
}

SRC_URI[md5sum] = "08649756a41358b24e1857201a90f8bf"
SRC_URI[sha256sum] = "bad7cc70c773ecc05edf7d511f37f50a3e753fa8cddea0a81f2fc8f582a10489"
