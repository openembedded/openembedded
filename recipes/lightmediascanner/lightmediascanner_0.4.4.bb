DESCRIPTION = "Lightweight media scanner meant to be used in not-so-powerful devices"
AUTHOR = "ProFUSION"
HOMEPAGE = "http://lms.garage.maemo.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
DEPENDS = "sqlite3 flac virtual/libiconv"

PE = "1"
PR = "r0"

SRC_URI = "http://git.profusion.mobi/cgit.cgi/lightmediascanner.git/snapshot/release_${PV}.tar.bz2 \
"
SRC_URI[md5sum] = "f423376a70f8f321af69b12563b176fe"
SRC_URI[sha256sum] = "302a7f6cc355467cd20332f4e02c8b87ba6c0c7a6818a6a987e007aace19b41e"

S = "${WORKDIR}/release_${PV}"

inherit autotools pkgconfig

do_install_append() {
    install -d ${D}/${bindir}/
    install -m 755 ${S}/src/bin/.libs/test  ${D}/${bindir}/test-lms
}

PACKAGES =+ "${PN}-test"

FILES_${PN}-test = "${bindir}/test-lms"

FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug"
