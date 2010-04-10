LICENSE     = "LGPL"
PR          = "r0"
DESCRIPTION = "Common code for GPE PIMs (hildon UI version)"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libgpewidget-hildon gtk+ sqlite hildon-lgpl"
PROVIDES    = "libgepepimc"
RPROVIDES   = "libgepepimc"

SRC_URI     = "${GPE_MIRROR}/libgpepimc-${PV}.tar.bz2"

EXTRA_OECONF = "--enable-hildon"
S = "${WORKDIR}/libgpepimc-${PV}"

inherit pkgconfig autotools

headers = "pim-categories.h pim-categories-ui.h"

do_stage () {
	oe_libinstall -so libgpepimc ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}


SRC_URI[md5sum] = "bbb0efe3359510fc0393f3f305c1c6e7"
SRC_URI[sha256sum] = "b0d1236dbb27f054f8b8a6f8ed4d735db89eb466be641bed67363f4dd76385ad"
