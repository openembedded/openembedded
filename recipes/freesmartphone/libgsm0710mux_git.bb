DESCRIPTION = "A GSM 07.10 Multiplexing Engine"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/libgsm0710mux"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "libgsm0710 vala-native glib-2.0 libfsotransport"
PV = "0.3.4+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/libgsm0710mux;protocol=git;branch=master \
  file://abyss.conf \
"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/abyss.conf ${D}${sysconfdir}/
}

PACKAGES =+ "${PN}-config"

FILES_${PN} += "${sysconfdir} ${datadir}"
# ship vapi file
FILES_${PN}-dev += "${datadir}/vala"

RRECOMMENDS_${PN} = "${PN}-config"

FILES_${PN}-config = "\
  ${sysconfdir}/abyss.conf \
"

CONFFILES_${PN}-config = "\
  ${sysconfdir}/abyss.conf \
"

PACKAGE_ARCH_${PN} = "${BASE_PACKAGE_ARCH}"
