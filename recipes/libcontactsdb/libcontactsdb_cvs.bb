LICENSE = "GPL"
DESCRIPTION = "Database access library for GPE contacts"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

LICENSE = "GPL"

S = "${WORKDIR}/${PN}"
PV = "0.3+cvs${SRCDATE}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

inherit autotools gpe pkgconfig

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"

headers = "contacts-db.h"

do_stage () {
	oe_libinstall -so libcontactsdb ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}
