DESCRIPTION = "R is GNU S, a freely available language and environment for statistical computing \
and graphics which provides a wide variety of statistical and graphical techniques: \
linear and nonlinear modelling, statistical tests, time series analysis, classification, clustering, etc."
MAINTAINER = "Simon Pickering <S.G.Pickering@bath.ac.uk>"
SECTION = "console/scientific"
PRIORITY = "optional"
DEPENDS = "ncurses readline less perl-native r-native"

SRC_URI = "http://www.stats.bris.ac.uk/R/src/base/R-2/R-${PV}.tar.gz \
	file://configure.patch;patch=1 \
	file://src_library_Makefile.patch;patch=1 \
	file://src_library_Recommended_Makefile.patch;patch=1 \
	file://src_library_base_Makefile.patch;patch=1 \
	file://src_library_tools_Makefile.patch;patch=1 \
	file://src_library_utils_Makefile.patch;patch=1 \
	file://src_library_datasets_Makefile.patch;patch=1 \
	file://src_library_graphics_Makefile.patch;patch=1 \
	file://src_library_grid_Makefile.patch;patch=1 \
	file://src_library_methods_Makefile.patch;patch=1 \
	file://src_library_splines_Makefile.patch;patch=1 \
	file://src_library_stats4_Makefile.patch;patch=1 \
	file://src_library_stats_Makefile.patch;patch=1 \
	file://src_library_tcltk_Makefile.patch;patch=1 \
	file://src_library_grDevices_Makefile.patch;patch=1"

S = "${WORKDIR}/R-${PV}"

inherit autotools

EXTRA_OECONF = "--without-x"

do_configure() {
	gnu-configize
	oe_runconf
}

do_compile_prepend () {
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} src/extra/pcre/dftables.c -o src/extra/pcre/dftables -Isrc/include
	touch src/extra/pcre/dftables.o
	src/extra/pcre/dftables src/extra/pcre/chartables.h
}

do_compile() {
	oe_runmake 'R_EXE_NATIVE = ${STAGING_BINDIR}/R'
}
