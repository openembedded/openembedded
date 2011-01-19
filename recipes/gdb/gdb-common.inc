DESCRIPTION = "gdb - GNU debugger"
HOMEPAGE = "http://www.gnu.org/software/gdb/"
LICENSE="GPL"
SECTION = "devel"
PRIORITY = "optional"

INC_PR = "r9"

inherit autotools

SRC_URI = "${GNU_MIRROR}/gdb/gdb-${PV}.tar.gz"

FILESPATHPKG =. "gdb-${PV}:" 

export CC_FOR_BUILD = "${BUILD_CC}"
export CXX_FOR_BUILD = "${BUILD_CXX}"
export CPP_FOR_BUILD = "${BUILD_CPP}"
export CFLAGS_FOR_BUILD = "${BUILD_CFLAGS}"
export CXXFLAGS_FOR_BUILD = "${BUILD_CXXFLAGS}"
export CPPFLAGS_FOR_BUILD = "${BUILD_CPPFLAGS}"

S = "${WORKDIR}/gdb-${PV}"
B = "${WORKDIR}/build-${TARGET_SYS}"

do_install_append() {
	# these mo and doc files from gdb-cross-sdk clash with files from
	# binutils-cross-sdk when building sdk archives. Drop them for now as a
	# way to restore toolchains.
	rm -f ${D}${datadir}/locale/*/LC_MESSAGES/{bfd,opcodes}.mo
	rm -rf ${D}${docdir}/bfd.html

	# we don't care about these infos, installed from binutils
	rm -f ${D}${infodir}/{configure,standards,bfd}.info
	rm -f ${D}${docdir}/{configure,standards,bfd,libiberty}.html
	rm -f ${D}${infodir}/dir

	# We use libiberty from binutils
	rm -f ${D}${prefix}/${TARGET_SYS}/lib/libiberty.a
	rm -f ${D}${prefix}/lib{,64}/libiberty.a

	# Use libbfd from binutils.
	rm -f ${D}${prefix}/lib/libbfd.{,l}a

	# Use libopcodes from binutils.
	rm -f ${D}${prefix}/lib/libopcodes.{,l}a
}
