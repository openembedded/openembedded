SECTION = "unknown"
DEPENDS = "opensp-native sgml-common-native"
LICENSE = "MIT"
SRC_URI = "${SOURCEFORGE_MIRROR}/openjade/openjade-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://oj-native-libosp-fix.patch;patch=1;pnum=1"
S = "${WORKDIR}/openjade-${PV}"

inherit autotools native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/openjade-${PV}"
PACKAGES = ""

EXTRA_OECONF = "--enable-spincludedir=${STAGING_INCDIR}/OpenSP \
                --enable-splibdir=${STAGING_LIBDIR} \
		--enable-default-catalog=${sysconfdir}/sgml/catalog \
		--enable-default-search-path=${datadir}/sgml"

acpaths = "-I ${S}/config"

# Trailing whitespace is important. Otherwise compiler arguments will be messed
# up, resulting in a fail in do_configure.
CFLAGS_prepend = "-I${S}/include "

do_configure () {
	mv config/configure.in .
	gnu-configize
	oe_runconf
}

do_stage () {
	# Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/openjade.html
	# for details.
	install -m 0755 ${S}/jade/.libs/openjade ${STAGING_BINDIR_NATIVE}/openjade
	ln -sf openjade ${STAGING_BINDIR_NATIVE}/jade

	oe_libinstall -a -so -C style libostyle ${STAGING_LIBDIR}
	oe_libinstall -a -so -C spgrove libospgrove ${STAGING_LIBDIR}
	oe_libinstall -a -so -C grove libogrove ${STAGING_LIBDIR}
	
  install -d ${STAGING_DATADIR}/sgml/openjade-${PV}
	install -m 644 dsssl/catalog ${STAGING_DATADIR}/sgml/openjade-${PV}
	install -m 644 dsssl/*.{dtd,dsl,sgm} ${STAGING_DATADIR}/sgml/openjade-${PV}
	
	install-catalog --add ${sysconfdir}/sgml/openjade-${PV}.cat \
	    ${STAGING_DATADIR}/sgml/openjade-${PV}/catalog
	    
	install-catalog --add ${sysconfdir}/sgml/sgml-docbook.cat \
	    ${sysconfdir}/sgml/openjade-${PV}.cat
}

SRC_URI[md5sum] = "7df692e3186109cc00db6825b777201e"
SRC_URI[sha256sum] = "1d2d7996cc94f9b87d0c51cf0e028070ac177c4123ecbfd7ac1cb8d0b7d322d1"
