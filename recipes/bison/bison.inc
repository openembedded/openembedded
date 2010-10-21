DESCRIPTION = "GNU Project parser generator (yacc replacement)."
HOMEPAGE = "http://www.gnu.org/software/bison/"
LICENSE = "GPLv2+"
SECTION = "devel"
PRIORITY = "optional"
DEPENDS = "virtual/libintl flex-native"

SRC_URI = "${GNU_MIRROR}/bison/bison-${PV}.tar.gz \
	   file://m4.patch"

INC_PR = "r8"

inherit autotools gettext

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
PSTAGING_DISABLED_virtclass-native = "1"
