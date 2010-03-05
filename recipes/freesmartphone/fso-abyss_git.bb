DESCRIPTION = "Abyss is a GSM 07.10 muxer userspace daemon"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/Abyss"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "vala-native dbus dbus-glib libgsm0710mux"
LICENSE = "GPL"
PV = "0.9.1+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/fso-abyss.git;protocol=git;branch=master \
  file://fso-abyss.conf \
"
S = "${WORKDIR}/git"

inherit autotools

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



