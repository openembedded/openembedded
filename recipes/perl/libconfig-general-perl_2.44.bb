DESCRIPTION = "Generic Configuration Module"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TL/TLINDEN/Config-General-${PV}.tar.gz"

S = "${WORKDIR}/Config-General-${PV}"

inherit cpan

SRC_URI[md5sum] = "ad17b4ae5e0142fadd9b81f264deb266"
SRC_URI[sha256sum] = "7c82d49c1c1b517d338bb51eb17898ced90e2afb46fb0b145c67091cf0a1867e"
