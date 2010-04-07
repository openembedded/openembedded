DESCRIPTION = "A set of notification sounds"
LICENSE = "CC"
SECTION = "multimedia"
SRCREV = "3a4767ec01988bd0fd8f72f0c35d6d36e5fbc815"
PV = "0.0.1+gitr${SRCREV}"
PR = "r2"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/artwork.git;protocol=git;branch=master \
"

do_install() {
	install -d ${D}${datadir}/sounds/
	install ${WORKDIR}/git/sounds/female_message.wav ${D}${datadir}/sounds/
	install ${WORKDIR}/git/sounds/female_ringtone.wav ${D}${datadir}/sounds/
}

FILES_${PN} = "${datadir}"
PACKAGE_ARCH = "all"
