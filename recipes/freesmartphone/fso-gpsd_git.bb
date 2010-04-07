DESCRIPTION = "freesmartphone.org gpsd compatibility daemon"
LICENSE = "GPL"
SECTION = "network"
DEPENDS = "dbus-glib"
SRCREV = "39e810899110a9bb302cf2064e1c0f73541fb4e6"
PV = "0.8+gitr${SRCREV}"
PR = "r2"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/fso-gpsd.git;protocol=git;branch=master \
  file://fso-gpsd \
"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "fso-gpsd"
INITSCRIPT_PARAMS = "defaults 35"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/fso-gpsd ${D}${sysconfdir}/init.d/
}

FILES_${PN} += "${sysconfdir}"
RDEPENDS_${PN} = "frameworkd"
RPROVIDES_${PN} = "gpsd"
# Disabled as we always got gpsd but not fso-gpsd in the fso-image. Needs
# fixing.
#RCONFLICTS_${PN} = "gpsd"
