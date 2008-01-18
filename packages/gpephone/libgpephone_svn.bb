LICENSE     = "LGPL"
DESCRIPTION = "Base library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ gtk-doc dbus-glib"
PV = "0.4+svnr-${SRCREV}"
PR          = "r0"

SRC_URI = "${GPEPHONE_SVN}"
inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}
