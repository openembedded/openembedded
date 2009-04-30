LICENSE = "GPLv2"

SRCREV = "7f3f5f46cc40f9012300aca66a25ca31511df897"
PV = "0.4.1+gitr${SRCPV}"
PE = "1"

DEPENDS = "dbus-glib gstreamer glib-2.0"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage

FILES_${PN} =+ "${datadir}/dbus-1/services/"

