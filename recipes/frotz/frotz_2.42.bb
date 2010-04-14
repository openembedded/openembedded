LICENSE = "GPL"
DESCRIPTION = "Frotz is an interpreter for Infocom games and other Z-machine games."
HOMEPAGE = "http://www.cs.csubak.edu/~dgriffi/proj/frotz/"
SECTION = "console/games"
DEPENDS = "ncurses"

SRC_URI = "http://www.cs.csubak.edu/~dgriffi/proj/frotz/files/frotz-${PV}.tar.gz \
	file://Makefile.patch;patch=1 "

do_configure() {
	patch -N ${s}/ux_init.c < remove_root_restriction.patch || :
	rm -f ${SourceTree}/frotz.conf
}

EXTRA_OEMAKE = "CC='${CC}' INCL='${CFLAGS}' LIB='${LDFLAGS}' PREFIX=${prefix} CONFIG_DIR=${sysconfdir}"

do_compile() {
	oe_runmake frotz
	sed 's/^[a-z]/#&/' frotz.conf-big > frotz.conf;
}

do_install() {
	oe_runmake PREFIX=${D}${prefix} MAN_PREFIX=${D}${mandir} install
}

SRC_URI[md5sum] = "a1cf81b39f749ea96e4585238ffc1b3f"
SRC_URI[sha256sum] = "cbdd2b2911aaf57a3efa6e12d4b45036b80efbb3ede30e88118fc528d90a4768"
