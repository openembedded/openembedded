DESCRIPTION = "Common code for GPE PIMs"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libgpewidget gtk+ sqlite"
PROVIDES = "libgepepimc"
RPROVIDES_${PN} = "libgepepimc"

SRC_URI = "${GPE_MIRROR}/libgpepimc-${PV}.tar.bz2"

inherit pkgconfig autotools

#headers = "pim-categories.h pim-categories-ui.h"

#do_install () {
#        oe_libinstall -so libgpepimc ${D}${libdir}
#        install -d ${D}${includedir}/gpe
#        for h in ${headers}; do
#                install -m 0644 ${S}/gpe/$h ${D}${includedir}/gpe/$h
#        done
#}
