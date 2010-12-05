DESCRIPTION = "Lightweight media scanner meant to be used in not-so-powerful devices"
SECTION = "libs/multimedia"
AUTHOR = "Profusion"
LICENSE = "LGPLv2.1+"
DEPENDS = "sqlite3 flac"
SRC_URI = "https://garage.maemo.org/frs/download.php/8852/lightmediascanner-${PV}.tar.bz2"
PE = "1"

inherit autotools pkgconfig

do_install_append() {
    install -d ${D}/${bindir}/
    install -m 755 ${WORKDIR}/${PN}-${PV}/src/bin/.libs/test  ${D}/${bindir}/test-lms
}

PACKAGES =+ "${PN}-test"

FILES_${PN}-test = "${bindir}/test-lms"

FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug"

SRC_URI[md5sum] = "01c3040ea9df1a4509474bedc1d8adc7"
SRC_URI[sha256sum] = "fa679d473ba85f5046eddae550f1810f69a9b1c481a57bbed75076ee11f9f88d"


