DESCRIPTION = "Zhone: Zen Phone"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "edje-native"
RDEPENDS = "task-python-efl python-textutils"
PV = "0.0.0+gitr${SRCREV}"
PR = "r3"

SRC_URI = "${FREESMARTPHONE_GIT}/zhone.git;protocol=git;branch=master \
           file://80zhone"
S = "${WORKDIR}/git"

inherit autotools

RDEPENDS_${PN} += "\
  python-dbus \
"

do_install_append() {
	install -d ${D}${sysconfdir}/X11/Xsession.d/
	install -m 0755 ${WORKDIR}/80zhone ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

RCONFLICTS = "openmoko-session2"
RREPLACES = "openmoko-session2"
PACKAGE_ARCH = "${MACHINE_ARCH}"

