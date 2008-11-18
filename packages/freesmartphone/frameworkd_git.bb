DESCRIPTION = "The reference implementation of the freesmartphone.org framework APIs"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de> et. al."
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.8.4.4+gitr${SRCREV}"
PR = "r0"

inherit distutils update-rc.d

INITSCRIPT_NAME = "frameworkd"
INITSCRIPT_PARAMS = "defaults 29"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=stabilization/milestone4 \
           file://frameworkd \
           file://frameworkd.conf"
S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/frameworkd ${D}${sysconfdir}/init.d/
	install -m 0644 ${WORKDIR}/frameworkd.conf ${D}${sysconfdir}
}

RDEPENDS_${PN} += "\
  python-ctypes \
  python-dbus \
  python-datetime \
  python-difflib \
  python-pprint \
  python-pygobject \
  python-pyrtc \
  python-pyserial \
  python-pyyaml \
  python-shell \
  python-subprocess \
  python-syslog \
  python-textutils \
  \
  ${PN}-config \
"

RRECOMMENDS_${PN} += "\
  alsa-utils-amixer \
  python-gst \
  ppp \
"

# recommend MUXer on platforms that require one
RRECOMMENDS_${PN}_append_om-gta01 = "gsm0710muxd"
RRECOMMENDS_${PN}_append_om-gta02 = "gsm0710muxd"

PACKAGES =+ "${PN}-config"
PACKAGE_ARCH_${PN}-config = "${MACHINE_ARCH}"

FILES_${PN}-config = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone \
"
CONFFILES_${PN}-config = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/profiles/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/default.yaml \
  ${sysconfdir}/freesmartphone/oevents/rules.yaml \
"

PACKAGE_ARCH_${PN} = "${BASE_PACKAGE_ARCH}"
FILES_${PN} += "${sysconfdir}/dbus-1 ${sysconfdir}/freesmartphone ${sysconfdir}/init.d ${datadir}"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/framework/subsystems/*/.debug"
