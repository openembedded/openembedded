DESCRIPTION = "A phone UI based on the freesmartphone.org framework"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "edje-native python-pyrex-native python-cython-native"
SRCREV = "f2b39bfe7d6e7e2288337f83f3a02f5541027ea8"
PV = "0.0.2+gitr${SRCPV}"
PE = "1"
PR = "r15"

SRC_URI = "${FREESMARTPHONE_GIT}/zhone.git;protocol=git;branch=master \
           file://80zhone"
S = "${WORKDIR}/git"

inherit distutils

do_install_append() {
	install -d ${D}${sysconfdir}/X11/Xsession.d/
	install -m 0755 ${WORKDIR}/80zhone ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

RDEPENDS_${PN} = "\
  python-edbus \
  python-edje \
  python-ecore \
  python-logging \
  python-textutils \
  python-dbus \
  python-pycairo \
"
