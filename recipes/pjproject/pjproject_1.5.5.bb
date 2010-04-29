DESCRIPTION = "Open source SIP stack and media stack for presence, im/instant \
               messaging, and multimedia communication"
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"
LICENSE = "GPLv3"

DEPENDS = "alsa-lib openssl"

PARALLEL_MAKE = ""

SRC_URI = "http://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2 "
SRC_URI[md5sum] = "bcafe54494e0ba44942d352b442ba773"
SRC_URI[sha256sum] = "a769d4e3812ae9ea2342fa8d918841e60797d1a8605fd9f46a6496ce2e61998c"

S = "${WORKDIR}/pjproject-${PV}"

inherit autotools pkgconfig

do_configure_prepend () {
        sed -i -e 's#ac_default_prefix=/usr/local#ac_default_prefix=/usr#' aconfigure
        sed -i -e 's#^prefix = /usr/local#prefix = /usr#' Makefile
}

do_compile_prepend() {
        oe_runmake dep
}
