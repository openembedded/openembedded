DESCRIPTION = "jar replacement written in C."
HOMEPAGE = "http://sourceforge.net/projects/fastjar/"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"

DEPENDS = "zlib"

GCC_VER = "${@bb.data.getVar('PV',d,1).split('gcc')[1]}"
SRC_URI = "${GNU_MIRROR}/gcc/gcc-${GCC_VER}/gcc-${GCC_VER}.tar.bz2"

S = "${WORKDIR}/gcc-${GCC_VER}"

inherit autotools native

EXTRA_OECONF = "--with-system-zlib --with-fastjar"

do_configure () {
	gnu-configize || die "failure running gnu-configize"
	oe_runconf
}

do_compile() {
	oe_runmake maybe-all-fastjar
}

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 fastjar/jar ${STAGING_BINDIR}/fastjar
	install -m 755 fastjar/grepjar ${STAGING_BINDIR}
}
