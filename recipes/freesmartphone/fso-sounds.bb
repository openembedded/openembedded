DESCRIPTION = "A set of notification sounds"
LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://COPYING;md5=a288ad49522a0d7d8c5d10c476b58a1f"
SECTION = "multimedia"
SRCREV = "dc8135c2d78f6335661a4ddefff0204721550abd"
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
