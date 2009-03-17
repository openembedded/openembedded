DESCRIPTION = "Common code for GPE PIMs"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libgpewidget gtk+ sqlite"
PROVIDES = "libgepepimc"
RPROVIDES = "libgepepimc"
PV = "0.8+svn${SRCDATE}"
PR = "r0"

inherit pkgconfig autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage () {
        oe_libinstall -so libgpepimc ${STAGING_LIBDIR}
        mkdir -p ${STAGING_INCDIR}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
        done
}

headers = "pim-categories.h pim-categories-ui.h"

DEFAULT_PREFERENCE = "-1"
