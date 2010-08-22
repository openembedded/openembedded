DESCRIPTION = "Matlab alternative for numerical computations"
HOMEPAGE = "http://www.gnu.org/software/octave/"
SECTION = "console/scientific"
LICENSE = "GPL"
INC_PR = "r3"

DEPENDS = "gperf-native readline ncurses fftw"
RDEPENDS_${PN} = "libfftw3"
# fftw compiled with --disable-fortran

ARM_INSTRUCTION_SET = "arm"

inherit autotools

EXTRA_OECONF = "--without-hdf5 --without-glpk -without-umfpack \
                --without-colamd --without-ccolamd --without-cholmod \
                --without-cxsparse"

TARGET_CC_ARCH += "${LDFLAGS}"

# additional missing dependency/functionality: Qhull gperf

do_configure() {
	gnu-configize
	oe_runconf
}

PACKAGES =+ "octave-m"

# octave-m provides matlab routines in .m file format
FILES_${PN}-m = "${datadir}/${PN}/*"

