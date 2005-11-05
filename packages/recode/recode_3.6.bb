DESCRIPTION = "Charset converting utility"
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "${GNU_MIRROR}/recode/recode-${PV}.tar.gz"

inherit autotools

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

