LICENSE = "GPL"
DESCRIPTION = "GPE to-do list"
DEPENDS = "libgpewidget libgpepimc libtododb gtk+"
SECTION = "gpe"
PRIORITY = "optional"

inherit autotools pkgconfig

SRC_URI="${GPE_SVN}"

S = "${WORKDIR}/${PN}"

