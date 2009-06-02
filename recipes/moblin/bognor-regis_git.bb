LICENSE = "GPLv2"

SRCREV = "181a62fa73527905fa01859b49eeb9d326ef7742"
PV = "0.3.1"
PR_append = "+git${SRCREV}"

DEPENDS = "dbus-glib gstreamer glib-2.0"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage

FILES_${PN} =+ "${datadir}/dbus-1/services/"

