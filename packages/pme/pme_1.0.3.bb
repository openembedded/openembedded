SECTION = "unknown"
DEPENDS = "pcre"
LICENSE = "BSD"
DESCRIPTION = "PME is a C++ wrapper around the PCRE library."
SRC_URI = "http://xaxxon.slackworks.com/pme/pme-${PV}.tar.gz"

inherit autotools 

do_stage () {
	oe_libinstall -a -so libpme ${STAGING_LIBDIR}
	install -m 0644 pme.h ${STAGING_INCDIR}/
}
