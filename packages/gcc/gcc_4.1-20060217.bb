PR = "r0"
DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
DEFAULT_PREFERENCE = "-99999"

inherit autotools gettext

include gcc-package.inc

SRC_URI = "http://ftp.nluug.nl/languages/gcc/snapshots/4.1-20060217/gcc-4.1-20060217.tar.bz2 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://ldflags.patch;patch=1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

include gcc4-build.inc
