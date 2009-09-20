DESCRIPTION = "Liblinebreak is an implementation of the line breaking algorithm as described in Unicode 5.1.0 Standard Annex 14, Revision 22"
HOMEPAGE = "http://vimgadgets.sourceforge.net/liblinebreak/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/vimgadgets/liblinebreak/${PV}/liblinebreak-${PV}.tar.gz"

inherit autotools_stage
