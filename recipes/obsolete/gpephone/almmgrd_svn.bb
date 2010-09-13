DESCRIPTION = "Alarm manager daemon"
SECTION = "gpephone"
PRIORITY = "required"
LICENSE = "LiPS"
DEPENDS = "glib-2.0 libiac sqlite3 libcalenabler2 libalmmgr"
PV = "0.0+svnr-${SRCREV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = "${WORKDIR}/${PN}"
