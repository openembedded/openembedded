SECTION = "devel"
DESCRIPTION = "General-purpose x86 assembler"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
COMPATIBLE_HOST = '(x86_64|i.86.*)-(linux|freebsd.*)'
LICENSE = "GPL"
SECTION = "dev-lang"

SRC_URI = "${SOURCEFORGE_MIRROR}/nasm/nasm-${PV}.tar.bz2"

inherit autotools

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1

	oe_runmake 'INSTALLROOT=${D}' install
}
