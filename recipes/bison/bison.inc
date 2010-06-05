DESCRIPTION = "GNU Project parser generator (yacc replacement)."
HOMEPAGE = "http://www.gnu.org/software/bison/"
LICENSE = "GPL"
SECTION = "devel"
PRIORITY = "optional"
DEPENDS = "virtual/libintl"

SRC_URI = "${GNU_MIRROR}/bison/bison-${PV}.tar.gz \
	   file://m4.patch"

INC_PR = "r5"

inherit autotools

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
