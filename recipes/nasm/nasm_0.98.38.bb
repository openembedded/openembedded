DESCRIPTION = "General-purpose x86 assembler"
SECTION = "devel"
LICENSE = "GPL"
COMPATIBLE_HOST = '(x86_64|i.86).*-(linux|freebsd.*)'
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/nasm/nasm-${PV}.tar.bz2"

inherit autotools

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1

	oe_runmake 'INSTALLROOT=${D}' install
}

SRC_URI[md5sum] = "9f682490c132b070d54e395cb6ee145e"
SRC_URI[sha256sum] = "87e64eff736196862ed46c04a3dffa612d765df980fa974fc65e026d811bd9d0"
