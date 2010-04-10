LICENSE = "GPL"
DESCRIPTION = "Frotz is an interpreter for Infocom games and other Z-machine games."
HOMEPAGE = "http://www.cs.csubak.edu/~dgriffi/proj/frotz/"
SECTION = "console/games"
DEPENDS = "ncurses"

SRC_URI = "http://www.cs.csubak.edu/~dgriffi/proj/frotz/files/frotz-${PV}.tar.gz \
	file://Makefile-${PV}.patch;patch=1 \
	file://remove_root_restriction.patch;patch=1 "

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
