DESCRIPTION = "A GSM 07.10 Multiplexing Engine"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "glib-2.0 libgsm0710 libfsotransport"
PV = "0.3.6+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/libgsm0710mux;protocol=git;branch=master \
  file://abyss.conf \
"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig vala

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/abyss.conf ${D}${sysconfdir}/
}

PACKAGES =+ "${PN}-config"

FILES_${PN} += "${sysconfdir} ${datadir}"

RRECOMMENDS_${PN} = "${PN}-config"

FILES_${PN}-config = "\
  ${sysconfdir}/abyss.conf \
"

CONFFILES_${PN}-config = "\
  ${sysconfdir}/abyss.conf \
"

PACKAGE_ARCH_${PN} = "${BASE_PACKAGE_ARCH}"
