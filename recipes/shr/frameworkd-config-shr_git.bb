DESCRIPTION = "SHR Configuration for frameworkd"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de> et. al."
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"

SRCREV_pn-frameworkd-config-shr_FSO_REV ?= "f751f2724eea23d0ca050bdf2672f9011ae09517"
SRCREV_pn-frameworkd-config-shr_SHR_REV ?= "cdf5b5f3d8f37d6d91e1eb8d9cf07d034291df87"

SRCREV_FORMAT = "FSO_REV-SHR_REV"
PV = "0.9.5.9+gitr${SRCREV}"
PR = "r8"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master;name=FSO_REV \
           git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master;name=SHR_REV"
S = "${WORKDIR}/git"

PROVIDES_${PN} = "frameworkd-config"
RPROVIDES_${PN} = "frameworkd-config"
CONF_PATH = "${S}/frameworkd/${PN}"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/profiles/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/
	install -d ${D}${sysconfdir}/freesmartphone/oevents/
	install -d ${D}${sysconfdir}/freesmartphone/ogsmd/
	install -d ${D}${sysconfdir}/freesmartphone/persist/
        install -d ${D}${sysconfdir}/freesmartphone/opim/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/phone.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/profiles.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/opreferences/schema/rules.yaml ${D}${sysconfdir}/freesmartphone/opreferences/schema/
	install -m 0644 ${S}/etc/freesmartphone/persist/README ${D}${sysconfdir}/freesmartphone/persist/
	install -m 0644 ${S}/etc/freesmartphone/ogsmd/networks.tab ${D}${sysconfdir}/freesmartphone/ogsmd/
        install -m 0644 ${S}/etc/freesmartphone/ogsmd/cell.db ${D}${sysconfdir}/freesmartphone/ogsmd/
        install -m 0644 ${S}/etc/freesmartphone/ogsmd/la.db ${D}${sysconfdir}/freesmartphone/ogsmd/

	#Check for machine specific conf.
        CONF_PATH_MACHINE="${CONF_PATH}"
        if [ -d "${CONF_PATH}/${MACHINE}" ] ; then
                CONF_PATH_MACHINE="${CONF_PATH}/${MACHINE}"
        fi
        # Install SHR custom files
        install -m 0644 ${CONF_PATH_MACHINE}/frameworkd.conf ${D}${sysconfdir}
        install -m 0644 ${CONF_PATH_MACHINE}/rules.yaml ${D}${sysconfdir}/freesmartphone/oevents/
        install -m 0644 ${CONF_PATH}/profiles/profiles/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/profiles/

        install -m 0644 ${CONF_PATH}/profiles/phone/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${CONF_PATH}/profiles/rules/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -m 0644 ${CONF_PATH}/profiles/phone/ring.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${CONF_PATH}/profiles/rules/ring.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -m 0644 ${CONF_PATH}/profiles/phone/vibrate.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${CONF_PATH}/profiles/rules/vibrate.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -m 0644 ${CONF_PATH}/profiles/phone/silent.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/
        install -m 0644 ${CONF_PATH}/profiles/rules/silent.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/rules/

        install -d ${D}${datadir}/sounds
        install -m 0644 ${CONF_PATH}/*.wav ${D}${datadir}/sounds/
}

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

# machine specific stuff, should ideally be elsewhere
# - recommend MUXer on platforms that require one
RDEPENDS_${PN}_append_om-gta01 = " fso-abyss"
RDEPENDS_${PN}_append_om-gta02 = " fso-abyss"
# - add wmiconfig for wireless configuration
RDEPENDS_${PN}_append_om-gta02 = " wmiconfig"

FILES_${PN} = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone \
  ${datadir}/sounds \
"
CONFFILES_${PN} = "\
  ${sysconfdir}/frameworkd.conf \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/profiles/default.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/silent.yaml \
  ${sysconfdir}/freesmartphone/opreferences/conf/rules/default.yaml \
  ${sysconfdir}/freesmartphone/oevents/rules.yaml \
  ${sysconfdir}/freesmartphone/ogsmd/networks.tab \
"
