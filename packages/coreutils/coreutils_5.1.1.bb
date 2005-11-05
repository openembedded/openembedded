LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "A collection of core GNU utilities."
RREPLACES = "textutils shellutils fileutils"
RPROVIDES = "textutils shellutils fileutils"
PR = "r1"

SRC_URI = "ftp://alpha.gnu.org/gnu/coreutils/coreutils-${PV}.tar.bz2"

inherit autotools
