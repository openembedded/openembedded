SECTION = "console/utils"
DEPENDS = "ncurses"
DESCRIPTION = "Less is a program similar to more, i.e. a terminal \
based program for viewing text files and the output from other \
programs. Less offers many features beyond those that more does."
LICENSE = "GPL"
SRC_URI = "${GNU_MIRROR}/less/less-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

do_install () {
	oe_runmake 'bindir=${D}${bindir}' 'mandir=${D}${mandir}' install
}
