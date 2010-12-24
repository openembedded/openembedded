DESCRIPTION = "Fribidi library for bidirectional text"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/fribidi/fribidi-${PV}.tar.bz2"
SRC_URI[md5sum] = "0f6e7ecca08e6e108dc06337f5b5cabf"
SRC_URI[sha256sum] = "f3ecdb9d108bd61ec9394df75f5fd68ba886a8da0863ba6258338893aec6c04f"

S = "${WORKDIR}/fribidi-${PV}"

inherit autotools lib_package binconfig pkgconfig

do_configure_prepend () {
        # this version of libtool is old - we have to nobble this file to get it to litoolize
        rm -f ltconfig
        rm -f aclocal.m4
        rm -f acinclude.m4
}
