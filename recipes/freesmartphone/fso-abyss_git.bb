require cornucopia.inc

DESCRIPTION = "Abyss is a GSM 07.10 muxer userspace daemon"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/Abyss"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib libgsm0710mux"
LICENSE = "GPL"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.9.2+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += " file://fso-abyss.conf"
S = "${WORKDIR}/git/tools/${PN}"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/fso-abyss.conf ${D}${sysconfdir}/
}

PACKAGES =+ "${PN}-config"

FILES_${PN} += "${sysconfdir} ${datadir}"

RRECOMMENDS_${PN} = "${PN}-config"

FILES_${PN}-config = "\
  ${sysconfdir}/fso-abyss.conf \
"

CONFFILES_${PN}-config = "\
  ${sysconfdir}/fso-abyss.conf \
"

PACKAGE_ARCH_${PN} = "${BASE_PACKAGE_ARCH}"
