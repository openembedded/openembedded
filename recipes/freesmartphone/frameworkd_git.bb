DESCRIPTION = "The reference implementation of the freesmartphone.org framework APIs"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "FreeSmartphone.Org Development Team"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.8.5.2+gitr${SRCREV}"
PR = "r0"

inherit distutils update-rc.d

INITSCRIPT_NAME = "frameworkd"
INITSCRIPT_PARAMS = "defaults 29"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
           file://frameworkd \
           file://frameworkd.conf"
S = "${WORKDIR}/git"

do_configure_append() {
	echo "version=\"${PV}\"" >framework/__version__.py
}

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
  python-logging \
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

# machine specific stuff, should ideally be elsewhere
# - recommend MUXer on platforms that require one
RDEPENDS_${PN}_append_om-gta01 = " fso-gsm0710muxd"
RDEPENDS_${PN}_append_om-gta02 = " fso-gsm0710muxd"
RDEPENDS_${PN}-append-om-3d7k  = " fso-abyss"
# - add wmiconfig for wireless configuration
RDEPENDS_${PN}_append_om-gta02 = " wmiconfig"

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
  ${sysconfdir}/freesmartphone/ogsmd/networks.tab \
  "

PACKAGE_ARCH_${PN} = "${BASE_PACKAGE_ARCH}"
FILES_${PN} += "${sysconfdir}/dbus-1 ${sysconfdir}/freesmartphone ${sysconfdir}/init.d ${datadir}"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/framework/subsystems/*/.debug"
