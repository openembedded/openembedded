DESCRIPTION = "GNU C Library"
HOMEPAGE = "http://www.gnu.org/software/libc/libc.html"
SECTION = "libs"
PRIORITY = "required"
LICENSE = "LGPL"
GLIBC_PREFIX ?= "${TARGET_PREFIX}"
# nptl needs unwind support in gcc, which can't be built without glibc.
DEPENDS = "virtual/${GLIBC_PREFIX}gcc-intermediate linux-libc-headers"
#this leads to circular deps, so lets not add it yet
#RDEPENDS_ldd += " bash"
PROVIDES = "virtual/libc virtual/${GLIBC_PREFIX}libc-for-gcc"
PROVIDES += "virtual/libintl virtual/libiconv"

# INC_PR for glibc.inc, glibc-initial.inc and glibc-stage.inc
INC_PR = "r33"

inherit autotools

LEAD_SONAME = "libc.so"

GLIBC_EXTRA_OECONF ?= ""
INHIBIT_DEFAULT_DEPS = "1"

def get_glibc_fpu_setting(bb, d):
	if bb.data.getVar('TARGET_FPU', d, 1) in [ 'soft' ]:
		return "--without-fp"
	return ""

ARM_INSTRUCTION_SET = "arm"

PACKAGES = "glibc catchsegv sln nscd ldd localedef glibc-utils glibc-dev glibc-doc glibc-locale libsegfault glibc-extra-nss glibc-thread-db glibc-pcprofile"
