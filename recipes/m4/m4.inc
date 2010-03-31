DESCRIPTION = "GNU m4 is an implementation of the traditional Unix macro \
processor."
HOMEPAGE = "http://www.gnu.org/software/m4/"
LICENSE = "GPLv3"
INC_PR = "r0"

SRC_URI = "${GNU_MIRROR}/m4/m4-${PV}.tar.bz2;name=archive"

inherit autotools
