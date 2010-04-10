LICENSE = "LGPL"
DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libmimedir libeventdb"
PR = "r1"

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



SRC_URI[md5sum] = "66e2996cd89545827cba6d195904346f"
SRC_URI[sha256sum] = "157d54ac1248a430dcbbef0ddd0c486d76e67712b4ebccf63c23603fb75b23aa"
