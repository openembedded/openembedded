DESCRIPTION = "The Open Phone Daemon (Python Implementation)"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/OpenPhoneServer"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPLv2"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

inherit distutils update-rc.d

INITSCRIPT_NAME = "ophoned"
INITSCRIPT_PARAMS = "defaults 20"

SRC_URI = "${FREESMARTPHONE_GIT}/python-ophoned.git;protocol=git;branch=master \
           file://ophoned"
S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/ophoned ${D}${sysconfdir}/init.d/
#	install -m 0644 ${WORKDIR}/odeviced.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/dbus-1/system.d/
#	mv -f ${D}${datadir}/etc/dbus-1/system.d/odeviced.conf ${D}${sysconfdir}/dbus-1/system.d/
}

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
  python-pyrtc \
  python-syslog \
"

FILES_${PN} += "${sysconfdir}"
