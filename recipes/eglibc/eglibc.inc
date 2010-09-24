DESCRIPTION = "Embedded GNU C Library"
HOMEPAGE = "http://www.eglibc.org/home"
SECTION = "libs"
PRIORITY = "required"
LICENSE = "LGPL"
INC_PR = "r12"
# nptl needs unwind support in gcc, which can't be built without glibc.
DEPENDS = "virtual/${TARGET_PREFIX}gcc-intermediate linux-libc-headers"
#this leads to circular deps, so lets not add it yet
#RDEPENDS_ldd += " bash"
# nptl needs libgcc but dlopens it, so our shlibs code doesn't detect this
#RDEPENDS_${PN} += "${@['','libgcc']['nptl' in '${GLIBC_ADDONS}']}"
PROVIDES = "virtual/libc virtual/${TARGET_PREFIX}libc-for-gcc"
PROVIDES += "virtual/libintl virtual/libiconv"
inherit autotools

LEAD_SONAME = "libc.so"

GLIBC_EXTRA_OECONF ?= ""
INHIBIT_DEFAULT_DEPS = "1"

ARM_INSTRUCTION_SET = "arm"
# eglibc uses PARALLELMFLAGS variable to pass parallel build info so transfer
# PARALLEL_MAKE into PARALLELMFLAGS and empty out PARALLEL_MAKE
EXTRA_OEMAKE := "PARALLELMFLAGS=${PARALLEL_MAKE}"
PARALLEL_MAKE = ""
PACKAGES = "glibc catchsegv sln nscd ldd localedef glibc-utils glibc-dev glibc-doc glibc-locale libsegfault glibc-extra-nss glibc-thread-db glibc-pcprofile"
