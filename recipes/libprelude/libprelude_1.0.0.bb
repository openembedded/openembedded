DESCRIPTION = "Libprelude is a library that guarantees secure connections between all sensors and the Prelude Manager"
SECTION = "net"
DEPENDS = "gnutls libgcrypt zlib perl perl-native"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = " \
	http://www.prelude-ids.com/download/releases/libprelude/${PN}-${PV}.tar.gz \
	file://libprelude-dont-regenerate-perl-makefile.patch \
	file://libprelude-perl-build-with-gnu-hash.patch \
	file://libprelude-fix-uid-gid-conflicting-types.patch \
	file://fix-ltdl-hack.patch \
	"
SRC_URI[md5sum] = "a5bb76538d240e5fac5f6ab0b7fabfe5"
SRC_URI[sha256sum] = "e16d83a6a7bcc43a02d6f2bd40c91a03a258a9a86bab42262cbb5adaba8c4640"

inherit autotools gettext cpan-base binconfig pkgconfig

EXTRA_OECONF = "--with-perl --without-python --without-lua-config"
PERL_VERSION = ${@get_perl_version(d)}

do_configure_append() {
	. ${STAGING_LIBDIR}/perl/config.sh
	for i in bindings/perl bindings/low-level/perl; do
		cd $i
		export lddlflags
		yes '' | perl Makefile.PL ${EXTRA_CPANFLAGS}  CC="${cc}" LD="${ld}" LDFLAGS="${ldflags}" CCFLAGS="${ccflags}"
		sed -i -e "s:\(SITELIBEXP = \).*:\1${sitelibexp}:" \
			-e "s:\(SITEARCHEXP = \).*:\1${sitearchexp}:" \
			-e "s:\(INSTALLVENDORLIB = \).*:\1${D}${datadir}/perl5:" \
			-e "s:\(INSTALLVENDORARCH = \).*:\1${D}${libdir}/perl5:" \
			-e "s:\(LDDLFLAGS.*\)${STAGING_LIBDIR_NATIVE}:\1${STAGING_LIBDIR}:" \
			-e "s:^\(INSTALLSITELIB = \).*:\1${libdir}/perl/${PERL_VERSION}:" \
			-e "s:^\(INSTALLSITEARCH = \).*:\1${libdir}/perl/${PERL_VERSION}:" \
			Makefile
		cd ${S}
	done
}

do_install_append() {
	sed -i "s:${WORKDIR}/image::" ${D}${libdir}/perl/${PERL_VERSION}/auto/Prelude/.packlist
	sed -i "s:${WORKDIR}/image::" ${D}${libdir}/perl/${PERL_VERSION}/auto/PreludeEasy/.packlist
}

PACKAGES =+ "libpreludecpp libpreludecpp-dev libpreludecpp-dbg libprelude-perl-dbg libprelude-perl"

FILES_${PN} = "${sysconfdir}/prelude ${libdir}/*.so.* ${bindir}/prelude-* ${localstatedir}"
FILES_${PN}-dev += "${bindir}/libprelude-config"
CONFFILES_${PN} = " \
	${sysconfdir}/prelude/default/client.conf \
	${sysconfdir}/prelude/default/global.conf \
	${sysconfdir}/prelude/default/idmef-client.conf \
	${sysconfdir}/prelude/default/tls.conf \
	"

FILES_libpreludecpp = "${libdir}/libpreludecpp.so.*"
FILES_libpreludecpp-dev = "${libdir}/libpreludecpp.so ${libdir}/libpreludecpp.la"
FILES_libpreludecpp-dbg = "${libdir}/.debug/libpreludecpp.so.*"

FILES_libprelude-perl-dbg = "${libdir}/perl/${PERL_VERSION}/auto/Prelude/.debug"
FILES_libprelude-perl = "${libdir}/perl"

FILES_${PN}-dbg += "${libdir}/.debug ${bindir}/.debug ${libdir}/perl/${PERL_VERSION}/auto/Prelude/.debug"
