DESCRIPTION = "A set of notification sounds"
LICENSE = "CC"
SECTION = "multimedia"
SRCREV = "3a4767ec01988bd0fd8f72f0c35d6d36e5fbc815"
PV = "0.0.1+gitr${SRCPV}"
PE = "1"
PR = "r3"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/artwork.git;protocol=git;branch=master \
"
S = "${WORKDIR}/git/sounds"

do_install() {
	install -d ${D}${datadir}/sounds/
	cp ${S}/*.wav ${D}${datadir}/sounds/
}

PACKAGES += "${PN}-extras"

RSUGGESTS_${PN} = "${PN}-extras"
FILES_${PN} = "${datadir}/sounds/female_message.wav \
               ${datadir}/sounds/female_ringtone.wav \
"
FILES_${PN}-extras = "${datadir}/sounds"

PACKAGE_ARCH = "all"
