DESCRIPTION = "Charset converting utility"
SECTION = "console/utils"
LICENSE = "GPL"

PR = "r1"
SRC_URI = "${GNU_MIRROR}/recode/recode-${PV}.tar.gz \
	file://recode-bitfield-width.patch;patch=1"

inherit autotools

TARGET_CC_ARCH_append = "${LDFLAGS}"

do_configure() {
	gnu-configize
	oe_runconf
	echo "#undef malloc" >>config.h
	echo "#undef realloc" >>config.h
}

do_stage() {
	install -m 0644 src/recode.h ${STAGING_INCDIR}/
	install -m 0644 src/recodext.h ${STAGING_INCDIR}/
	oe_libinstall -a -C src librecode ${STAGING_LIBDIR}/
}


SRC_URI[md5sum] = "be3f40ad2e93dae5cd5f628264bf1877"
SRC_URI[sha256sum] = "e3e6a4f3f8e5c6052ab70155990c074d87aa0b614fc1be31d194750d1d962fcf"
