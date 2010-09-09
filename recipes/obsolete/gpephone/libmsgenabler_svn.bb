LICENSE     = "LiPS"
DESCRIPTION = "LiPS message backend library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib librecord sqlite3"
PV = "1.0+svnr-${SRCREV}"
PR          = "r0"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

FILES_${PN} += "$(datadir)/libmsgenabler"

S = "${WORKDIR}/${PN}"

