LICENSE = "GPL"
DESCRIPTION = "Frotz is an interpreter for Infocom games and other Z-machine games."
HOMEPAGE = "http://frotz.sourceforge.net/"
SECTION = "console/games"
PR = "r1"

DEPENDS = "ncurses"

SRC_URI = "http://downloads.sourceforge.net/project/frotz/frotz/2.43/frotz-${PV}.tar.gz \
	file://Makefile-${PV}.patch \
	file://remove_root_restriction.patch "

do_configure() {
	rm -f ${SourceTree}/frotz.conf
}

EXTRA_OEMAKE = "CC='${CC}' INCL='${CFLAGS}' LIB='${LDFLAGS}' PREFIX=${prefix} CONFIG_DIR=${sysconfdir}"

do_compile() {
	oe_runmake frotz
}

do_install() {
	oe_runmake PREFIX=${D}${prefix} MAN_PREFIX=${D}${mandir} install
}

SRC_URI[md5sum] = "efe51879e012b92bb8d5f4a82e982677"
SRC_URI[sha256sum] = "f831eae9182e4a1407a34cb1098a4f5ad5ad6c6632e34eed734b9601a06a764b"
