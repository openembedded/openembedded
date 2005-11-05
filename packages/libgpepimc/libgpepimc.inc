LICENSE     = "LGPL"
PR          = "r0"
DESCRIPTION = "Common code for GPE PIMs"
SECTION     = "gpe/libs"
PRIORITY    = "optional"
MAINTAINER  = "Florian Boor <florian@kernelconcepts.de>"
DEPENDS     = "libgpewidget gtk+ sqlite"
PROVIDES    = "libgepepimc"
RPROVIDES   = "libgepepimc"

SRC_URI     = "${GPE_MIRROR}/libgpepimc-${PV}.tar.bz2"

inherit pkgconfig autotools

headers = "pim-categories.h pim-categories-ui.h"

do_stage () {
	oe_libinstall -so libgpepimc ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

