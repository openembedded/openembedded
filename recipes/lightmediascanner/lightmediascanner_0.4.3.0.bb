DESCRIPTION = "Lightweight media scanner meant to be used in not-so-powerful devices"
AUTHOR = "ProFUSION"
HOMEPAGE = "http://lms.garage.maemo.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"
DEPENDS = "sqlite3 flac virtual/libiconv"

PE = "1"
PR = "r0"

SRC_URI = "https://garage.maemo.org/frs/download.php/9439/lightmediascanner-${PV}.tar.bz2 \
    file://0001-use-AM_ICONV-to-allow-external-libiconv-to-be-used.patch \
"

inherit autotools pkgconfig

do_configure_prepend() {
    touch config.rpath
}

do_install_append() {
    install -d ${D}/${bindir}/
    install -m 755 ${S}/src/bin/.libs/test  ${D}/${bindir}/test-lms
}

PACKAGES =+ "${PN}-test"

FILES_${PN}-test = "${bindir}/test-lms"

FILES_${PN}-dbg += "${libdir}/${PN}/plugins/.debug"

SRC_URI[md5sum] = "188ff5188cfa0f2504a42934c969cb77"
SRC_URI[sha256sum] = "bdbe76655ad212b936fb3cf6a9ca725e318ddeb57cd7d950d9c8409297d3b0da"


