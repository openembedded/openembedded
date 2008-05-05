DESCRIPTION = "The Open Device Daemon Prototype in Python"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/OpenDeviceDaemon"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPLv2"
PV = "0.7.9+gitr${SRCREV}"
PR = "r0"

inherit distutils update-rc.d

INITSCRIPT_NAME = "odeviced"
INITSCRIPT_PARAMS = "defaults 20"

SRC_URI = "${FREESMARTPHONE_GIT}/python-odeviced.git;protocol=git;branch=master \
           file://odeviced \
           file://odeviced.conf"
S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/odeviced ${D}${sysconfdir}/init.d/
	install -m 0644 ${WORKDIR}/odeviced.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/dbus-1/system.d/
	mv -f ${D}${datadir}/etc/dbus-1/system.d/odeviced.conf ${D}${sysconfdir}/dbus-1/system.d/
}

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
  python-pyrtc \
  python-syslog \
"

FILES_${PN} += "${sysconfdir}"
