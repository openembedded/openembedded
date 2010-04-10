SECTION = "libs"
DEPENDS = "libpcre"
LICENSE = "BSD"
DESCRIPTION = "PME is a C++ wrapper around the PCRE library."
SRC_URI = "http://xaxxon.slackworks.com/pme/pme-${PV}.tar.gz"
PR = "r1"

inherit autotools

do_stage () {
	oe_libinstall -a -so libpme ${STAGING_LIBDIR}
	install -m 0644 pme.h ${STAGING_INCDIR}/
}

SRC_URI[md5sum] = "da0da7ed1689469b45c8d62fa2dfb204"
SRC_URI[sha256sum] = "25b84792473fa17d118e69b588f32fe940d13a01c3b3db89290ce6516ad01b2e"
