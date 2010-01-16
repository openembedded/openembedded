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

