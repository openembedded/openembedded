DESCRIPTION = "GNU Octave is a high-level language, primarily intended for numerical computations. \
It provides a convenient command line interface for solving linear and nonlinear problems numerically, \
and for performing other numerical experiments using a language that is mostly compatible with Matlab. \
It may also be used as a batch-oriented language."
HOMEPAGE = "http://www.gnu.org/software/octave/"
SECTION = "console/scientific"
LICENSE = "GPL"
DEPENDS = "readline ncurses fftw"
RDEPENDS = "libfftw3"
# fftw compiled with --disable-fortran

inherit autotools

EXTRA_OECONF = "--without-hdf5"

do_configure() {
	gnu-configize
	oe_runconf
}

PACKAGES =+ "octave-m"

# octave-m provides matlab routines in .m file format
FILES_${PN}-m = "${datadir}/${PN}/*"

do_stage() {
        autotools_stage_all
}

