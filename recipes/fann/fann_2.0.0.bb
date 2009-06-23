DESCRIPTION = "Fast Artificial Neural Network Library"
HOMEPAGE = "http://leenissen.dk/fann/"
SECTION = "libs"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/fann/fann-${PV}.tar.bz2"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

