# This needs bjam (boost-jam-native) 3.1.16
#
# Warning! The build system for boost seems to have changed
# significantly since 1.33 (again).
DESCRIPTION = "Free peer-reviewed portable C++ source libraries"
HOMEPAGE = "http://www.boost.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Boost Software License"
DEPENDS = "python boost-jam-native zlib bzip2"

PR = "6"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
	file://linux-uclibc.patch;patch=1 \
	file://${PV}-gcc43.patch;patch=1 \
	"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${BOOST_P}"

BOOST_VER = "${@"_".join(bb.data.getVar("PV",d,1).split("."))}"
BOOST_MAJ = "${@"_".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"

BJAM_TOOLS = "--toolset=gcc \
		'-sBUILD=release <optimization>space <inlining>on <debug-symbols>off' \
		'-sPYTHON_VERSION=${PYTHON_VERSION}' \
		'-sPYTHON=${STAGING_BINDIR_NATIVE}/python' \
    '-sPYTHON_ROOT=${PYTHON_ROOT}' \
		'-sBZIP2_LIBPATH=${STAGING_LIBDIR}' \
		'-sZLIB_LIBPATH=${STAGING_LIBDIR}' \
		'--layout=system' \
		"

BJAM_OPTS = '${BJAM_TOOLS} \
    --builddir=${S}/${TARGET_SYS} \
    ${BJAM_EXTRA}'

PYTHON_ROOT = "${STAGING_DIR_HOST}/${layout_prefix}"
PYTHON_VERSION = "2.5"

do_configure() {
	cp -f boost/config/platform/linux.hpp boost/config/platform/linux-gnueabi.hpp

	platform_config="-DBOOST_PLATFORM_CONFIG='boost/config/platform/${TARGET_OS}.hpp'"

  echo "import toolset : using ;" > tools/build/v2/user-config.jam
	echo "using gcc : : ${CC} : <cflags>${CFLAGS} <cxxflags>${CXXFLAGS} $platform_config<linkflags>${LDFLAGS} ;" >> tools/build/v2/user-config.jam
	echo "using python : 2.5 : : ${STAGING_INCDIR}/python2.5 : ${STAGING_LIBDIR}/python2.5 : : ; " >> tools/build/v2/user-config.jam
}

do_compile() {
	set -ex
	bjam ${BJAM_OPTS} --prefix=${prefix} \
		--exec-prefix=${exec_prefix} \
		--libdir=${libdir} \
		--includedir=${includedir}
}

do_stage() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${STAGING_LIBDIR} \
		--includedir=${STAGING_INCDIR} \
		install
}

do_install() {
	set -ex
	bjam ${BJAM_OPTS} \
		--libdir=${D}${libdir} \
		--includedir=${D}${includedir} \
		install
}

BOOSTLIBS = ""

# -dev last to pick up the remaining stuff
PACKAGES = "${BOOSTLIBS} ${PN}-dev ${PN}"
FILES_${PN}-dev = "${includedir} ${libdir}/libboost_*.so ${libdir}/libboost_*.a"

# "boost" is a metapackage which pulls in all boost librabries
RRECOMMENDS_${PN} += "${BOOSTLIBS}"

BOOSTLIBS += "boost-date-time boost-date-time-dbg boost-date-time-mt boost-date-time-mt-dbg"
FILES_boost-date-time = "${libdir}/libboost_date_time.so"
FILES_boost-date-time-dbg = "${libdir}/libboost_date_time-d.so ${libdir}/.debug/libboost_date_time-d.so"
FILES_boost-date-time-mt = "${libdir}/libboost_date_time-mt.so"
FILES_boost-date-time-mt-dbg = "${libdir}/libboost_date_time-mt-d.so ${libdir}/.debug/libboost_date_time-mt-d.so"

BOOSTLIBS += "boost-filesystem boost-filesystem-dbg boost-filesystem-mt boost-filesystem-mt-dbg"
FILES_boost-filesystem = "${libdir}/libboost_filesystem.so"
FILES_boost-filesystem-dbg = "${libdir}/libboost_filesystem-d.so ${libdir}/.debug/libboost_filesystem-d.so"
FILES_boost-filesystem-mt = "${libdir}/libboost_filesystem-mt.so"
FILES_boost-filesystem-mt-dbg = "${libdir}/libboost_filesystem-mt-d.so ${libdir}/.debug/libboost_filesystem-mt-d.so"

BOOSTLIBS += "boost-graph boost-graph-dbg boost-graph-mt boost-graph-mt-dbg"
FILES_boost-graph = "${libdir}/libboost_graph.so"
FILES_boost-graph-dbg = "${libdir}/libboost_graph-d.so ${libdir}/.debug/libboost_graph-d.so"
FILES_boost-graph-mt = "${libdir}/libboost_graph-mt.so"
FILES_boost-graph-mt-dbg = "${libdir}/libboost_graph-mt-d.so ${libdir}/.debug/libboost_graph-mt-d.so"

BOOSTLIBS += "boost-iostreams boost-iostreams-dbg boost-iostreams-mt boost-iostreams-mt-dbg"
FILES_boost-iostreams = "${libdir}/libboost_iostreams.so"
FILES_boost-iostreams-dbg = "${libdir}/libboost_iostreams-d.so ${libdir}/.debug/libboost_iostreams-d.so"
FILES_boost-iostreams-mt = "${libdir}/libboost_iostreams-mt.so"
FILES_boost-iostreams-mt-dbg = "${libdir}/libboost_iostreams-mt-d.so ${libdir}/.debug/libboost_iostreams-mt-d.so"

BOOSTLIBS += "boost-prg-exec-monitor boost-prg-exec-monitor-dbg boost-prg-exec-monitor-mt boost-prg-exec-monitor-mt-dbg"
FILES_boost-prg-exec-monitor = "${libdir}/libboost_prg_exec_monitor.so"
FILES_boost-prg-exec-monitor-dbg = "${libdir}/libboost_prg_exec_monitor-d.so ${libdir}/.debug/libboost_prg_exec_monitor-d.so"
FILES_boost-prg-exec-monitor-mt = "${libdir}/libboost_prg_exec_monitor-mt.so"
FILES_boost-prg-exec-monitor-mt-dbg = "${libdir}/libboost_prg_exec_monitor-mt-d.so ${libdir}/.debug/libboost_prg_exec_monitor-mt-d.so"

BOOSTLIBS += "boost-program-options boost-program-options-dbg boost-program-options-mt boost-program-options-mt-dbg"
FILES_boost-program-options = "${libdir}/libboost_program_options.so"
FILES_boost-program-options-dbg = "${libdir}/libboost_program_options-d.so ${libdir}/.debug/libboost_program_options-d.so"
FILES_boost-program-options-mt = "${libdir}/libboost_program_options-mt.so"
FILES_boost-program-options-mt-dbg = "${libdir}/libboost_program_options-mt-d.so ${libdir}/.debug/libboost_program_options-mt-d.so"

BOOSTLIBS += "boost-python boost-python-dbg boost-python-mt boost-python-mt-dbg"
FILES_boost-python = "${libdir}/libboost_python.so"
FILES_boost-python-dbg = "${libdir}/libboost_python-d.so ${libdir}/.debug/libboost_python-d.so"
FILES_boost-python-mt = "${libdir}/libboost_python-mt.so"
FILES_boost-python-mt-dbg = "${libdir}/libboost_python-mt-d.so ${libdir}/.debug/libboost_python-mt-d.so"

BOOSTLIBS += "boost-regex boost-regex-dbg boost-regex-mt boost-regex-mt-dbg"
FILES_boost-regex = "${libdir}/libboost_regex.so"
FILES_boost-regex-dbg = "${libdir}/libboost_regex-d.so ${libdir}/.debug/libboost_regex-d.so"
FILES_boost-regex-mt = "${libdir}/libboost_regex-mt.so"
FILES_boost-regex-mt-dbg = "${libdir}/libboost_regex-mt-d.so ${libdir}/.debug/libboost_regex-mt-d.so"

BOOSTLIBS += "boost-serialization boost-serialization-dbg boost-serialization-mt boost-serialization-mt-dbg"
FILES_boost-serialization = "${libdir}/libboost_serialization.so"
FILES_boost-serialization-dbg = "${libdir}/libboost_serialization-d.so ${libdir}/.debug/libboost_serialization-d.so"
FILES_boost-serialization-mt = "${libdir}/libboost_serialization-mt.so"
FILES_boost-serialization-mt-dbg = "${libdir}/libboost_serialization-mt-d.so ${libdir}/.debug/libboost_serialization-mt-d.so"

BOOSTLIBS += "boost-signals boost-signals-dbg boost-signals-mt boost-signals-mt-dbg"
FILES_boost-signals = "${libdir}/libboost_signals.so"
FILES_boost-signals-dbg = "${libdir}/libboost_signals-d.so ${libdir}/.debug/libboost_signals-d.so"
FILES_boost-signals-mt = "${libdir}/libboost_signals-mt.so"
FILES_boost-signals-mt-dbg = "${libdir}/libboost_signals-mt-d.so ${libdir}/.debug/libboost_signals-mt-d.so"

BOOSTLIBS += "boost-thread-mt boost-thread-mt-dbg"
FILES_boost-thread-mt = "${libdir}/libboost_thread-mt.so"
FILES_boost-thread-mt-dbg = "${libdir}/libboost_thread-mt-d.so ${libdir}/.debug/libboost_thread-mt-d.so"

BOOSTLIBS += "boost-unit-test-framework boost-unit-test-framework-dbg boost-unit-test-framework-mt boost-unit-test-framework-mt-dbg"
FILES_boost-unit-test-framework = "${libdir}/libboost_unit_test_framework.so"
FILES_boost-unit-test-framework-dbg = "${libdir}/libboost_unit_test_framework-d.so ${libdir}/.debug/libboost_unit_test_framework-d.so"
FILES_boost-unit-test-framework-mt = "${libdir}/libboost_unit_test_framework-mt.so"
FILES_boost-unit-test-framework-mt-dbg = "${libdir}/libboost_unit_test_framework-mt-d.so ${libdir}/.debug/libboost_unit_test_framework-mt-d.so"

BOOSTLIBS += "boost-wave boost-wave-dbg boost-wave-mt boost-wave-mt-dbg"
FILES_boost-wave = "${libdir}/libboost_wave.so"
FILES_boost-wave-dbg = "${libdir}/libboost_wave-d.so ${libdir}/.debug/libboost_wave-d.so"
FILES_boost-wave-mt = "${libdir}/libboost_wave-mt.so"
FILES_boost-wave-mt-dbg = "${libdir}/libboost_wave-mt-d.so ${libdir}/.debug/libboost_wave-mt-d.so"

BOOSTLIBS += "boost-wserialization boost-wserialization-dbg boost-wserialization-mt boost-wserialization-mt-dbg"
FILES_boost-wserialization = "${libdir}/libboost_wserialization.so"
FILES_boost-wserialization-dbg = "${libdir}/libboost_wserialization-d.so ${libdir}/.debug/libboost_wserialization-d.so"
FILES_boost-wserialization-mt = "${libdir}/libboost_wserialization-mt.so"
FILES_boost-wserialization-mt-dbg = "${libdir}/libboost_wserialization-mt-d.so ${libdir}/.debug/libboost_wserialization-mt-d.so"

