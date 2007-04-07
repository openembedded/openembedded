DESCRIPTION = "Editor for the GPE Palmtop Environment"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"

inherit gpe autotools

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
