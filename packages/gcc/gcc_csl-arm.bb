PR = "r0"
DESCRIPTION = "The GNU cc and gcc C compilers."
HOMEPAGE = "http://www.gnu.org/software/gcc/"
SECTION = "devel"
LICENSE = "GPL"
MAINTAINER = "Gerald Britton <gbritton@doomcom.org>"
PV = "3.4.3+csl-arm-${CVSDATE}"
BINV = "3.4.3"
FILESDIR = "${FILE_DIRNAME}/gcc-csl-arm"
DEFAULT_PREFERENCE = "-1"

inherit autotools gettext

include gcc-package.inc

SRC_URI = "cvs://anoncvs@savannah.gnu.org/cvsroot/gcc;method=ext;tag=csl-arm-branch;module=gcc;date=${CVSDATE} \
	   file://gcc34-arm-tune.patch;patch=1"

include gcc3-build.inc

S = "${WORKDIR}/gcc"

