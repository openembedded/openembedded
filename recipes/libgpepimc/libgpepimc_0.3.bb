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

SRC_URI[md5sum] = "5142dd86386e1106a29f90837f57c3eb"
SRC_URI[sha256sum] = "f6a27c361b7ca41e32f4fedcf588e19745437ad5955fa68612ed21f45e828fc5"
