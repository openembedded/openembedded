MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
LICENSE     = "LGPL"
PR          = "r0"
PV = "0.8+svn${SRCDATE}"
DESCRIPTION = "Common code for GPE PIMs"
SECTION     = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "libgpewidget gtk+ sqlite"
PROVIDES    = "libgepepimc"
RPROVIDES   = "libgepepimc"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit pkgconfig autotools

headers = "pim-categories.h pim-categories-ui.h"

do_stage () {
        oe_libinstall -so libgpepimc ${STAGING_LIBDIR}

        mkdir -p ${STAGING_INCDIR}/gpe
        for h in ${headers}; do
                install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
        done
}

