LICENSE = "LGPL"
DESCRIPTION = "Common code for GPE PIMs"
SECTION = "gpe/libs"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "7aaa9220d1ffa77b70c1cf8355141b29"
SRC_URI[sha256sum] = "260c329ca2e197e8c85f21da4186cf8a4746ad0398fb708fbb266453f570734a"
