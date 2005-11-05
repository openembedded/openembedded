DESCRIPTION = "Patcher is a perl script for managing patches."
HOMEPAGE = "http://www.holgerschurig.de/patcher.html"
LICENSE = "Perl"
DEPENDS = ""
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Holger Schurig <hs4233@mail.mn-solutions.de>"
INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "http://www.holgerschurig.de/files/linux/patcher-${PV}.tar.bz2"
S="${WORKDIR}/patcher"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 patcher.py ${D}${bindir}/patcher
}

DEPENDS_prepend_delete = "patcher "
