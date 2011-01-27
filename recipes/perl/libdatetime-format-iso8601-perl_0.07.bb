DESCRIPTION = "DateTime::Format::ISO8601 - Parses ISO8601 formats"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = " libdatetime-perl-native libdatetime-format-builder-perl-native "
RDEPENDS_${PN} = " libdatetime-perl libdatetime-format-builder-perl "
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JH/JHOBLITT/DateTime-Format-ISO8601-${PV}.tar.gz"
SRC_URI[md5sum] = "debb51180d0318ae09cad01c544a1d7d"
SRC_URI[sha256sum] = "e362d6a006934854d041b3833b106bd1489278ee8348ee3c24bbc5ed87ed9618"

S = "${WORKDIR}/DateTime-Format-ISO8601-${PV}"

inherit cpan_build

BBCLASSEXTEND="native"
