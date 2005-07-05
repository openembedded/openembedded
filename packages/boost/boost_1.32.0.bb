# The Boost web site provides free peer-reviewed portable
# C++ source libraries. The emphasis is on libraries which
# work well with the C++ Standard Library. The libraries are
# intended to be widely useful, and are in regular use by
# thousands of programmers across a broad spectrum of applications.
DESCRIPTION = "Free peer-reviewed portable C++ source libraries"
HOMEPAGE = "http://www.boost.org/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "Boost Software License"

# need debian package naming for the libs
inherit debian

DEPENDS += "boost-jam-native"

BOOST_VER = "${@"_".join(bb.data.getVar("PV",d,1).split("."))}"
BOOST_MAJ = "${@"_".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"
SRC_URI = "http://download.sourceforge.net/boost/${BOOST_P}.tar.bz2"

S = "${WORKDIR}/${BOOST_P}"

# Make a package for each library, plus -dev and -python
PACKAGES =

PACKAGES += boost-date-time
FILES_boost-date-time = "${libdir}/libboost_date_time.so.${PV}"

PACKAGES += boost-filesystem
FILES_boost-filesystem = "${libdir}/libboost_filesystem.so.${PV}"

PACKAGES += boost-prg-exec-monitor
FILES_boost-prg-exec-monitor = "${libdir}/libboost_prg_exec_monitor.so.${PV}"

PACKAGES += boost-program-options
FILES_boost-program-options = "${libdir}/libboost_program_options.so.${PV}"

PACKAGES += boost-regex
FILES_boost-regex = "${libdir}/libboost_regex.so.${PV}"

PACKAGES += boost-signals
FILES_boost-signals = "${libdir}/libboost_signals.so.${PV}"

PACKAGES += boost-test-exec-monitor
FILES_boost-test-exec-monitor = "${libdir}/libboost_test_exec_monitor.so.${PV}"

PACKAGES += boost-thread-mt
FILES_boost-thread-mt = "${libdir}/libboost_thread-mt.so.${PV}"

PACKAGES += boost-unit-test-framework
FILES_boost-unit-test-framework = "${libdir}/libboost_unit_test_framework.so.${PV}"

# Python - remove this and set:
#PYTHON_ROOT = "/dev/null"
# to remove the python build
DEPENDS += "python"
PYTHON_ROOT = "${STAGING_DIR}/${HOST_SYS}"
PYTHON_VERSION = "2.4"

PACKAGES += boost-python
FILES_boost-python = "${libdir}/libboost_python.so.${PV}"

# -dev last to pick up the remaining stuff
PACKAGES += "${PN}-dev"
FILES_${PN}-dev = "${includedir} ${libdir}/libboost_*.so ${libdir}/libboost_*.a"

# Oh yippee, a new build system, it's sooo cooool I could eat my own
# foot.  inlining=on lets the compiler choose, I think.  At least this
# stuff is documented...
# NOTE: if you leave <debug-symbols>on then in a debug build the build sys
# objcopy will be invoked, and that won't work.  Building debug apparently
# requires hacking gcc-tools.jam
BJAM_TOOLS   = "-sTOOLS=gcc \
		'-sGCC=${CC}' \
		'-sGXX=${CXX}' \
		-sBUILD='release <optimization>space <inlining>on <debug-symbols>off' \
		'-sPYTHON_VERSION=${PYTHON_VERSION}' \
		--layout=system \
		"

BJAM_OPTS    = '${BJAM_TOOLS} \
		--builddir=${S}/${TARGET_SYS} \
		--with-python-root=${PYTHON_ROOT} \
		${BJAM_EXTRA}'


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
