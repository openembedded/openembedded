LICENSE     = "LGPL"
DESCRIPTION = "LiPS instant messenger library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 librecord2 libabenabler2 liblipsevent2 telepathy-glib telepathy-mission-control"
PV = "0.0+svnr-${SRCREV}"
PR          = "r1"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN} \
           file://disable-tests.patch"

EXTRA_OECONF = "--enable-test=no"

S = ${WORKDIR}/libim2

FILES_${PN} += " ${datadir}/dbus-1"

