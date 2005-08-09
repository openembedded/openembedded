PRIORITY = "optional"
include eet_${PV}.bb
inherit native
DEPENDS = "zlib-native jpeg-native"
LICENSE = "BSD"

do_stage () {
	install -m 0755 src/bin/.libs/eet ${STAGING_BINDIR}
	oe_libinstall -C src/lib libeet ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Eet.h ${STAGING_INCDIR}/
}

do_install() {
	:
}
