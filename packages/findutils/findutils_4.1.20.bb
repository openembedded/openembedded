SECTION = "console/utils"
LICENSE = "GPL"
DESCRIPTION = "find, locate, and xargs binaries."
PR = "r2"

SRC_URI = "ftp://alpha.gnu.org/gnu/findutils/findutils-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://make.patch;patch=1"

inherit autotools gettext

# diffutils assumes non-glibc compilation with uclibc and
# this causes it to generate its own implementations of
# standard functionality.  regex.c actually breaks compilation
# because it uses __mempcpy, there are other things (TBD:
# see diffutils.mk in buildroot)
EXTRA_OECONF_linux-uclibc = "--without-included-regex"
