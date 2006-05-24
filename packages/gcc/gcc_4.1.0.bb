PR = "r0"
DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
DEFAULT_PREFERENCE = "-1"

inherit autotools gettext

include gcc-package.inc

SRC_URI = "http://ftp.gnu.org/pub/gnu/gcc/gcc-4.1.0/gcc-4.1.0.tar.bz2 \
	file://arm-nolibfloat.patch;patch=1 \
	file://arm-softfloat.patch;patch=1 \
	file://ldflags.patch;patch=1"

SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "

include gcc4-build.inc
EXTRA_OECONF += "--disable-libssp"

FORTRAN = ""
HAS_GFORTRAN = ""
HAS_G2C = "no"

  
