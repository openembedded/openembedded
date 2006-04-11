DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
MAINTAINER = "Gerald Britton <gbritton@doomcom.org>"
BINV = "3.4.4"
PV = "3.4.4+csl-arm-${SRCDATE}"
PR = "r0"

FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"
DEFAULT_PREFERENCE = "-1"

inherit autotools gettext

include gcc-package.inc

SRC_URI = "cvs://anonymous@cvs.savannah.gnu.org/cvsroot/gcc;method=pserver;tag=csl-arm-branch;module=gcc;date=${SRCDATE} \
	   file://gcc34-arm-tune.patch;patch=1"

include gcc3-build.inc

S = "${WORKDIR}/gcc"

