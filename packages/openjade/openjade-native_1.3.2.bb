SECTION = "unknown"
DEPENDS = "opensp-native sgml-common-native"
LICENSE = "MIT"
SRC_URI = "${SOURCEFORGE_MIRROR}/openjade/openjade-${PV}.tar.gz \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/openjade-${PV}"

inherit autotools native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openjade-${PV}"
PACKAGES = ""

EXTRA_OECONF = "--enable-spincludedir=${STAGING_INCDIR}/OpenSP \
                --enable-splibdir=${STAGING_LIBDIR}"
acpaths = "-I ${S}/config"
CFLAGS_prepend = "-I${S}/include"

do_configure () {
	mv config/configure.in .
	gnu-configize
	oe_runconf
}

do_stage () {
	install -m 0755 ${S}/jade/.libs/openjade ${STAGING_BINDIR}/openjade
	oe_libinstall -a -so -C style libostyle ${STAGING_LIBDIR}
	oe_libinstall -a -so -C spgrove libospgrove ${STAGING_LIBDIR}
	oe_libinstall -a -so -C grove libogrove ${STAGING_LIBDIR}
}
