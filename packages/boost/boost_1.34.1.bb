# This needs bjam (boost-jam-native) 3.1.16
#
# Warning! The build system for boost seems to have changed
# significantly since 1.33 (again).

include boost.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS += "bzip2"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
	file://linux-uclibc.patch;patch=1 \
	file://${PV}-gcc43.patch;patch=1 \
	"

PR = "r0"

BJAM_TOOLS   = "--toolset=gcc \
		'-sGCC=${CC} '${BJAM_CONF} \
		'-sGXX=${CXX} '${BJAM_CONF} \
		'-sGCC_INCLUDE_DIRECTORY=${STAGING_INCDIR}' \
		'-sGCC_STDLIB_DIRECTORY=${STAGING_LIBDIR}' \
		'-sBUILD=release <optimization>space <inlining>on <debug-symbols>off' \
		'-sPYTHON_VERSION=${PYTHON_VERSION}' \
		'-sPYTHON=${STAGING_BINDIR_NATIVE}/python' \
    '-sPYTHON_ROOT=${PYTHON_ROOT}' \
		'-sBZIP2_LIBPATH=${STAGING_LIBDIR}' \
		'-sZLIB_LIBPATH=${STAGING_LIBDIR}' \
		'--layout=system' \
		"

BJAM_OPTS    = '${BJAM_TOOLS} \
    --builddir=${S}/${TARGET_SYS} \
    ${BJAM_EXTRA}'

do_configure() {
  echo "import toolset : using ;" > tools/build/v2/user-config.jam
	echo "using gcc : : ${CC} : <cflags>${CFLAGS} <cxxflags>${CXXFLAGS} <linkflags>${LDFLAGS} ;" >> tools/build/v2/user-config.jam
}
