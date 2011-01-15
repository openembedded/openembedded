DESCRIPTION = "pjproject "
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"
LICENSE = "GPLv3"

DEPENDS = "alsa-lib openssl"

PARALLEL_MAKE = ""

SRC_URI = "https://projects.savoirfairelinux.com/attachments/download/1977/sflphone-0.9.12.tar.gz \
           file://fix-Makefile.patch"
SRC_URI[md5sum] = "f784b5dd02542a5beb07d872d50bd8ee"
SRC_URI[sha256sum] = "eab77836d1205402ad05fc33af2fb9734f69743eabbec4d93fdb5ae7bfdef02b"

S = "${WORKDIR}/sflphone-${PV}/sflphone-common/libs/pjproject"

inherit pkgconfig autotools

do_compile_prepend() {
        oe_runmake dep
}