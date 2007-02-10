DESCRIPTION = "Data interchange library for GPE"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libmimedir libeventdb"
PV = "0.17+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit pkgconfig gpe autotools

do_stage () {
        oe_libinstall -so libgpevtype ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/${h}
        done
}

headers = "tag-db.h vcard.h vevent.h vtodo.h"

DEFAULT_PREFERENCE = "-1"
