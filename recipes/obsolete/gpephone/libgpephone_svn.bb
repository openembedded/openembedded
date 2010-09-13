LICENSE     = "LGPL"
DESCRIPTION = "Base library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ gtk-doc dbus-glib"
PV = "0.4+svnr-${SRCREV}"
PR          = "r0"

inherit gpephone pkgconfig autotools
SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"

