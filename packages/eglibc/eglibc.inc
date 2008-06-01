DESCRIPTION = "Embedded GNU C Library"
HOMEPAGE = "http://www.eglibc.org/home"
SECTION = "libs"
PRIORITY = "required"
LICENSE = "LGPL"
# nptl needs unwind support in gcc, which can't be built without glibc.
DEPENDS = "${@['virtual/${TARGET_PREFIX}gcc-initial', 'virtual/${TARGET_PREFIX}gcc']['nptl' in '${GLIBC_ADDONS}']} linux-libc-headers"
#this leads to circular deps, so lets not add it yet
#RDEPENDS_ldd += " bash"
# nptl needs libgcc but dlopens it, so our shlibs code doesn't detect this
RDEPENDS += "${@['','libgcc']['nptl' in '${GLIBC_ADDONS}']}"
PROVIDES = "virtual/libc ${@['virtual/${TARGET_PREFIX}libc-for-gcc', '']['nptl' in '${GLIBC_ADDONS}']}"
PROVIDES += "virtual/libintl virtual/libiconv"

inherit autotools

LEAD_SONAME = "libc.so"

GLIBC_EXTRA_OECONF ?= ""
INHIBIT_DEFAULT_DEPS = "1"

PACKAGES = "glibc catchsegv sln nscd ldd localedef glibc-utils glibc-dev glibc-doc glibc-locale libsegfault glibc-extra-nss glibc-thread-db glibc-pcprofile"
