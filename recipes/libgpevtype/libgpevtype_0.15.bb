LICENSE     = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libmimedir libeventdb"
PR          = "r0"

inherit pkgconfig gpe autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

headers = "tag-db.h vcard.h vevent.h vtodo.h"


do_stage () {
	oe_libinstall -so libgpevtype ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/${h}
	done
}



SRC_URI[md5sum] = "6bef54f2dbc76e77d5ba49c16e4f04e5"
SRC_URI[sha256sum] = "a49c0a9d7b8e1edc7659469c524237ce55202b91dad61e08d95eb6749b2eb020"
