DESCRIPTION = "Archive::Tar - module for manipulations of tar archives"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KA/KANE/Archive-Tar-${PV}.tar.gz"

S = "${WORKDIR}/Archive-Tar-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "89604ea8fadc990c7bb668259dacb439"
SRC_URI[sha256sum] = "c456d5c73a57a567440bca5c138a549a21637aa2e4049228b5ba63cf68d75a1a"
