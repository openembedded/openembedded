DESCRIPTION = "Fast Artificial Neural Network Library"
HOMEPAGE = "http://leenissen.dk/fann/"
SECTION = "libs"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/fann/fann-${PV}.tar.bz2"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"


SRC_URI[md5sum] = "4224efa533265dcf39237667973d0e20"
SRC_URI[sha256sum] = "762a1313a9b935300cb66ebf052d469d04823ca721fe6dd2a49c01e13e8ab30a"
