DESCRIPTION = "Common code for GPE PIMs"
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libgpewidget gtk+ sqlite"
PROVIDES = "libgepepimc"
RPROVIDES_${PN} = "libgepepimc"
PV = "0.8+svn${SRCDATE}"
PR = "r3"

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

inherit pkgconfig autotools

headers = "pim-categories.h pim-categories-ui.h"

DEFAULT_PREFERENCE = "-1"
