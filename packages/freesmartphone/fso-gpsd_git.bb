DESCRIPTION = "freesmartphone.org gpsd compatibility daemon"
LICENSE = "GPL"
SECTION = "network"
DEPENDS = "dbus-glib"
PV = "0.7+gitr${SRCREV}"
PR = "r0"

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
RCONFLICTS_${PN} = "gpsd"
RREPLACES_${PN} = "gpsd"
