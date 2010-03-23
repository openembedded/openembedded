DESCRIPTION = "The reference implementation of the freesmartphone.org framework APIs"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "FreeSmartphone.Org Development Team"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.9.5.9+gitr${SRCREV}"
PR = "r3"

inherit distutils update-rc.d python-dir

INITSCRIPT_NAME = "frameworkd"
INITSCRIPT_PARAMS = "defaults 29"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
           file://frameworkd \
           file://frameworkd.conf \
	   "
SRC_URI_append_shr = "file://oeventsd-use-opimd-signals.patch;patch=1"

S = "${WORKDIR}/git"

do_configure_append() {
	echo "version=\"${PV}\"" >framework/__version__.py
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/frameworkd ${D}${sysconfdir}/init.d/
	install -m 0644 ${WORKDIR}/frameworkd.conf ${D}${sysconfdir}
}

pkg_postinst_${PN} () {
	echo "*IMPORTANT NOTICE*: There has been a change in internal opimd database structure as well as in the backend mechanism."
	echo "  This change is not backwards compatible so a conversion is needed, furthermore, since new opimd does not (and will not) support working with SIM, importing your SIM data is also required."
	echo "  In order to import SIM contacts, please use PISI."
	echo "  If you still have old contacts with 'tel:' prefix instead of field types (i.e you haven't upgraded since 26.1.2010) please run the 'remove-tel' script first."
	echo "  For the database conversion:"
	echo "    1) stop frameworkd '/etc/init.d/frameworkd stop'"
	echo "    2) use the conversion script, called: 'opimd_convert_db' which is already installed in your system"
	echo "    3) restart your device"
}

RDEPENDS_${PN} += "\
  fsousaged \
"

RDEPENDS_${PN} += "\
  python-ctypes \
  python-dbus \
  python-datetime \
  python-difflib \
  python-logging \
  python-pprint \
  python-pyalsaaudio \
  python-pygobject \
  python-pyrtc \
  python-pyserial \
  python-pyyaml \
  python-shell \
  python-subprocess \
  python-syslog \
  python-textutils \
  python-multiprocessing \
  ${PN}-config \
"

RRECOMMENDS_${PN} += "\
  alsa-utils-amixer \
  python-gst \
  python-phoneutils \
  python-vobject \
  ppp \
"

PACKAGES =+ "${PN}-config"
PACKAGE_ARCH_${PN}-config = "${MACHINE_ARCH}"

# machine specific stuff, should ideally be elsewhere
# - recommend MUXer on platforms that require one
RDEPENDS_${PN}-config_append_om-gta01 = " fso-abyss"
RDEPENDS_${PN}-config_append_om-gta02 = " fso-abyss"
# - add wmiconfig for wireless configuration
RDEPENDS_${PN}-config_append_om-gta02 = " wmiconfig"

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
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/framework/subsystems/*/.debug"
