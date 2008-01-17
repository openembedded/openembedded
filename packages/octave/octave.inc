DESCRIPTION = "Matlab alternative for numerical computations"
HOMEPAGE = "http://www.gnu.org/software/octave/"
SECTION = "console/scientific"
LICENSE = "GPL"
DEPENDS = "readline ncurses fftw"
RDEPENDS = "libfftw3"
# fftw compiled with --disable-fortran

inherit autotools

EXTRA_OECONF = "--without-hdf5 --without-glpk -without-umfpack \
                --without-colamd --without-ccolamd --without-cholmod \
                --without-cxsparse"

# additional missing dependency/functionality: Qhull gperf

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
