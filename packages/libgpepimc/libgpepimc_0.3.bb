LICENSE = "LGPL"
DESCRIPTION = "Common code for GPE PIMs"
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "libgpewidget libdisplaymigration gtk+ sqlite"

inherit pkgconfig gpe

headers = "pim-categories.h pim-categories-ui.h"

do_stage () {
	oe_libinstall -so libgpepimc ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

do_install () {
	gpe_do_install
	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}
