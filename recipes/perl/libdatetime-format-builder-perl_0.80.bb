DESCRIPTION = "DateTime::Format::Builder - Create DateTime parser classes and objects"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = " libclass-factory-util-perl-native libdatetime-perl-native libdatetime-format-strptime-perl-native \
	libtask-weaken-perl-native "
RDEPENDS_${PN} = " libclass-factory-util-perl libdatetime-perl libdatetime-format-strptime-perl libtask-weaken-perl "
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/DateTime-Format-Builder-${PV}.tar.gz"
SRC_URI[md5sum] = "f6c5d5a17b5b7478ff555a2d3cce5136"
SRC_URI[sha256sum] = "9250fe0f7312fe6b12295280a10968d665bee563170477a272a099464cd02c89"

S = "${WORKDIR}/DateTime-Format-Builder-${PV}"

inherit cpan

BBCLASSEXTEND="native"
