LICENSE = "GPLv2"

SRCREV = "7f3f5f46cc40f9012300aca66a25ca31511df897"
PV = "0.4.1"
PR_append = "+git${SRCREV}"

DEPENDS = "dbus-glib gstreamer glib-2.0"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} =+ "${datadir}/dbus-1/services/"

