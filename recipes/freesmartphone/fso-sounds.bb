DESCRIPTION = "A set of notification sounds"
LICENSE = "CC"
SECTION = "multimedia"
PV = "0.0.1+gitr${SRCREV}"
PR = "r1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/artwork.git;protocol=git;branch=master \
"

do_install() {
	install -d ${D}${datadir}/sounds/
	install ${WORKDIR}/git/sounds/*.wav ${D}${datadir}/sounds/
}

FILES_${PN} = "${datadir}"
PACKAGE_ARCH = "all"
