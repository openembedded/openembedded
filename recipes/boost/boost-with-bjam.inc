# The Boost web site provides free peer-reviewed portable
# C++ source libraries. The emphasis is on libraries which
# work well with the C++ Standard Library. The libraries are
# intended to be widely useful, and are in regular use by
# thousands of programmers across a broad spectrum of applications.

# This recipe is for building Boost versions > 1.45, where bjam has been merged
# into the Boost tree.

DESCRIPTION = "Free peer-reviewed portable C++ source libraries"
HOMEPAGE = "http://www.boost.org/"
SECTION = "libs"
DEPENDS = "zlib bzip2 icu"
PRIORITY = "optional"
LICENSE = "Boost Software License"
INC_PR = "r10"

BOOST_VER = "${@"_".join(bb.data.getVar("PV",d,1).split("."))}"
BOOST_MAJ = "${@"_".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"
BOOST_P = "boost_${BOOST_VER}"

S = "${WORKDIR}/${BOOST_P}"

# Make a package for each library, plus -dev and -python
PACKAGES = "${PN}-dbg"
BOOSTLIBS = ""

PACKAGES += "boost-date-time"
FILES_boost-date-time = "${libdir}/libboost_date_time.so.${PV}"

BOOSTLIBS += "boost-filesystem"
FILES_boost-filesystem = "${libdir}/libboost_filesystem.so.${PV}"

BOOSTLIBS += "boost-prg-exec-monitor"
FILES_boost-prg-exec-monitor = "${libdir}/libboost_prg_exec_monitor.so.${PV}"

BOOSTLIBS += "boost-program-options"
FILES_boost-program-options = "${libdir}/libboost_program_options.so.${PV}"

BOOSTLIBS += "boost-regex"
FILES_boost-regex = "${libdir}/libboost_regex.so.${PV}"

BOOSTLIBS += "boost-signals"
FILES_boost-signals = "${libdir}/libboost_signals.so.${PV}"

BOOSTLIBS += "boost-test-exec-monitor"
FILES_boost-test-exec-monitor = "${libdir}/libboost_test_exec_monitor.so.${PV}"

BOOSTLIBS += "boost-thread-mt"
FILES_boost-thread-mt = "${libdir}/libboost_thread-mt.so.${PV}"

BOOSTLIBS += "boost-unit-test-framework"
FILES_boost-unit-test-framework = "${libdir}/libboost_unit_test_framework.so.${PV}"

BOOSTLIBS += "boost-iostreams"
FILES_boost-iostreams = "${libdir}/libboost_iostreams.so.${PV}"

BOOSTLIBS += "boost-serialization"
FILES_boost-serialization = "${libdir}/libboost_serialization.so.${PV}"

BOOSTLIBS += "boost-wserialization"
FILES_boost-wserialization = "${libdir}/libboost_wserialization.so.${PV}"

# Python - remove this and set:
#PYTHON_ROOT = "/dev/null"
# to remove the python build
DEPENDS += "python"
PYTHON_ROOT = "${STAGING_DIR_HOST}/${layout_prefix}"
PYTHON_VERSION = "2.6"

BOOSTLIBS += "boost-python"
FILES_boost-python = "${libdir}/libboost_python.so.${PV}"

PACKAGES += "${BOOSTLIBS}"

# -dev last to pick up the remaining stuff
PACKAGES += "${PN}-dev"
FILES_${PN}-dev = "${includedir} ${libdir}/libboost_*.so ${libdir}/libboost_*.a"

# "boost" is a metapackage which pulls in all boost librabries
PACKAGES += "${PN}"
RRECOMMENDS_${PN} += "${BOOSTLIBS}"

# to avoid GNU_HASH QA errors added LDFLAGS to ARCH; a little bit dirty but at least it works
TARGET_CC_ARCH += " ${LDFLAGS}" 

# Oh yippee, a new build system, it's sooo cooool I could eat my own
# foot.  inlining=on lets the compiler choose, I think.  At least this
# stuff is documented...
# NOTE: if you leave <debug-symbols>on then in a debug build the build sys
# objcopy will be invoked, and that won't work.  Building debug apparently
# requires hacking gcc-tools.jam
#
# Sometimes I wake up screaming.  Famous figures are gathered in the nightmare,
# Steve Bourne, Larry Wall, the whole of the ANSI C committee.  They're just
# standing there, waiting, but the truely terrifying thing is what they carry
# in their hands.  At first sight each seems to bear the same thing, but it is
# not so for the forms in their grasp are ever so slightly different one from
# the other.  Each is twisted in some grotesque way from the other to make each
# an unspeakable perversion impossible to perceive without the onset of madness.
# True insanity awaits anyone who perceives all of these horrors together.
#
# Quotation marks, there might be an easier way to do this, but I can't find
# it.  The problem is that the user.hpp configuration file must receive a
# pre-processor macro defined as the appropriate string - complete with "'s
# around it.  (<> is a possibility here but the danger to that is that the
# failure case interprets the < and > as shell redirections, creating
# random files in the source tree.)
#
#bjam: '-DBOOST_PLATFORM_CONFIG=\"config\"'
#do_compile: '-sGCC=... '"'-DBOOST_PLATFORM_CONFIG=\"config\"'"
SQD = '"'
EQD = '\"'
#boost.bb:   "...  '-sGCC=... '${SQD}'-DBOOST_PLATFORM_CONFIG=${EQD}config${EQD}'${SQD} ..."
BJAM_CONF = "${SQD}'-DBOOST_PLATFORM_CONFIG=${EQD}boost/config/platform/${TARGET_OS}.hpp${EQD}'${SQD}"

BJAM_TOOLS   = "--layout=system \
                --toolset=gcc-target \
                -sICU_PATH=${STAGING_DIR_TARGET} \
		'-sGCC_INCLUDE_DIRECTORY=${STAGING_INCDIR}' \
		'-sGCC_STDLIB_DIRECTORY=${STAGING_LIBDIR}' \
                "

BJAM_OPTS    = '${BJAM_TOOLS} \
		--builddir=${S}/${TARGET_SYS} \
		${BJAM_EXTRA} \
                ${PARALLEL_MAKE}'


do_configure_prepend() {
	cp -f boost/config/platform/linux.hpp boost/config/platform/linux-gnueabi.hpp
        echo "using gcc : host : ${HOST_CXX} : <cxxflags>${HOST_CFLAGS} ${HOST_CXXFLAGS} <linkflags>${HOST_LDFLAGS} ;" >> tools/build/v2/user-config.jam
        echo "using gcc : target : ${CXX} : <cxxflags>${CFLAGS} ${CXXFLAGS} <linkflags>${LDFLAGS} ;" >> tools/build/v2/user-config.jam
        echo "using python : ${PYTHON_VERSION} : : ${STAGING_INCDIR}/python${PYTHON_VERSION} ;" >> tools/build/v2/user-config.jam

        CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" ./bootstrap.sh --with-toolset=gcc
        sed -i '/^using python/d' project-config.jam
}

do_compile() {
	set -ex
	./bjam -d2 ${BJAM_OPTS} --prefix=${prefix} \
		--exec-prefix=${exec_prefix} \
		--libdir=${libdir} \
		--includedir=${includedir} \
                --include=${STAGING_INCDIR} \
                --debug-configuration
}

do_stage() {
	set -ex
	./bjam ${BJAM_OPTS} \
		--libdir=${STAGING_LIBDIR} \
		--includedir=${STAGING_INCDIR} \
		install
}

do_install() {
	set -ex
	./bjam ${BJAM_OPTS} \
		--libdir=${D}${libdir} \
		--includedir=${D}${includedir} \
		install
}
