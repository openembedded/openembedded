DESCRIPTION = "Open source SIP stack and media stack for presence, im/instant \
               messaging, and multimedia communication"
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"
LICENSE = "GPLv3"

DEPENDS = "alsa-lib openssl"

PARALLEL_MAKE = ""

SRC_URI = "http://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2 "
SRC_URI[md5sum] = "1680ed5ffa00ab38449efc2affda53c5"
SRC_URI[sha256sum] = "de39b121f10bae22cf3e53b0b8d7f62f19b8ca994d29f175a72644f1bd9a60f9"

S = "${WORKDIR}/pjproject-${PV}"

inherit autotools pkgconfig

do_configure_prepend () {
        sed -i -e 's#ac_default_prefix=/usr/local#ac_default_prefix=/usr#' aconfigure
        sed -i -e 's#^prefix = /usr/local#prefix = /usr#' Makefile
}

do_compile_prepend() {
        oe_runmake dep
}
