LICENSE     = "LiPS"
DESCRIPTION = "LiPS message backend library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib librecord2 liblipsevent2 telepathy-mission-control libgsmd-lips"
PV = "0.0+svnr-${SRCREV}"
PR          = "r1"

DEFAULT_PREFERENCE = "-1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = ${WORKDIR}/${PN}

FILES_${PN} += "$(datadir)/libmsgenabler2"

do_stage () {
	autotools_stage_all
}
