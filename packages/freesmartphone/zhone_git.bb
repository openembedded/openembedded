DESCRIPTION = "A phone UI based on the freesmartphone.org framework"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "edje-native python-pyrex-native python-cython-native"
PV = "0.0.1+gitr${SRCREV}"
PR = "r10"

SRC_URI = "${FREESMARTPHONE_GIT}/zhone.git;protocol=git;branch=master \
           file://80zhone"
S = "${WORKDIR}/git"

inherit distutils

do_install_append() {
	install -d ${D}${sysconfdir}/X11/Xsession.d/
	install -m 0755 ${WORKDIR}/80zhone ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

RDEPENDS = "\
  task-python-efl \
  python-textutils \
  python-dbus \
  python-pycairo \
"
