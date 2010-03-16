DESCRIPTION = "An Encode::Encoding subclass that detects the encoding of data"
SECTION = "libs"
LICENSE = "MPL"
RDEPENDS_${PN} += "perl-module-module-build perl-module-extutils-cbuilder"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JG/JGMYERS/Encode-Detect-${PV}.tar.gz;name=encode-detect-perl-${PV}"
SRC_URI[encode-detect-perl-1.01.md5sum] = "ee9faf55d7105c97b02b8ebe590819c7"
SRC_URI[encode-detect-perl-1.01.sha256sum] = "834d893aa7db6ce3f158afbd0e432d6ed15a276e0940db0a74be13fd9c4bbbf1"

BBCLASSEXTEND = "native"

S = "${WORKDIR}/Encode-Detect-${PV}"

inherit cpan_build
