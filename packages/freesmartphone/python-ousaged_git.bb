DESCRIPTION = "The Open Usage Daemon Prototype in Python"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/OpenUsageDaemon"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPLv2"
PV = "0.7.9+gitr${SRCREV}"
PR = "r1"

inherit distutils update-rc.d

INITSCRIPT_NAME = "ousaged"
INITSCRIPT_PARAMS = "defaults 21"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/usaged.git;protocol=git;branch=master \
  file://ousaged \
"
S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/ousaged ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/dbus-1/system.d/
	mv -f ${D}${datadir}/etc/dbus-1/system.d/ousaged.conf ${D}${sysconfdir}/dbus-1/system.d/
}

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
  python-pyrtc \
  python-syslog \
  python-odeviced \
"

FILES_${PN} += "${sysconfdir}"
