DESCRIPTION = "Expect.pm - Perl Expect interface"
SECTION = "libs"
LICENSE = "Artistic"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/Expect/Expect-${PV}.tar.gz"

S = "${WORKDIR}/Expect-${PV}"

inherit cpan

SRC_URI[md5sum] = "9134ae3778285bcf8c3ffdba1a177886"
SRC_URI[sha256sum] = "bbf70ce7cb39425a0f72c252491826747983ee82fb2d7b0a8a99d8940a58392f"
