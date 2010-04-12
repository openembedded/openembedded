DESCRIPTION = "Archive::Zip - Provide an interface to ZIP archive files."
SECTION = "libs"
LICENSE = "Artistic|GPL"

DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl"
PR= "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/Archive-Zip-${PV}.tar.gz"

S = "${WORKDIR}/Archive-Zip-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "40153666e7538b410e001aa8a810e702"
SRC_URI[sha256sum] = "f8b472ff77b7238e423bcb351968accc562f9d20700fbf2d8ed2a65fa0fa6318"
