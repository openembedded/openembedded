LICENSE = "GPL"
DESCRIPTION = "GNU Octave is a high-level language, primarily intended for numerical computations. \
It provides a convenient command line interface for solving linear and nonlinear problems numerically, \
and for performing other numerical experiments using a language that is mostly compatible with Matlab. \
It may also be used as a batch-oriented language." 
SECTION = "console/util"
DEPENDS = "readline ncurses"
MAINTAINER = "Simon Pickering <S.G.Pickering@bath.ac.uk>"
SRC_URI = "ftp://ftp.octave.org/pub/octave/bleeding-edge/octave-${PV}.tar.gz"

inherit autotools

FILES_${PN}-dev += "${libdir}/octave-${PV}/*.la ${libdir}/octave-${PV}/*.a"

do_configure() {
	gnu-configize
	oe_runconf
}
