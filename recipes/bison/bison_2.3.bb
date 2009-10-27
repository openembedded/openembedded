DESCRIPTION = "GNU Project parser generator (yacc replacement)."
HOMEPAGE = "http://www.gnu.org/software/bison/"
LICENSE = "GPL"
SECTION = "devel"
PRIORITY = "optional"

PR = "r1"

SRC_URI = "${GNU_MIRROR}/bison/bison-${PV}.tar.gz \
	   file://m4.patch;patch=1"

inherit autotools

# >> bison-2.3-r0: /usr/lib/liby.a
# That one is a special case: it wants to stay in the main bison package,
# since bison itself is a development tool.  I'm not sure why it is a
# static-only library; that might be an error.

FILES_${PN} += "${libdir}/liby.a"

