DESCRIPTION = "Image::Size   	 read the dimensions of an image in several popular formats"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJRAY/Image-Size-${PV}.tar.gz"
SRC_URI[md5sum] = "17b5cc123a522aa3c4ca842094d0c0ba"
SRC_URI[sha256sum] = "b2cf429c306fc865c551843bb2db42c24e28286964219758f315fce7d2aa76ae"

S = "${WORKDIR}/Image-Size-${PV}"

inherit cpan

BBCLASSEXTEND="native"
