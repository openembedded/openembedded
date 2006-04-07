DESCRIPTION = "GNU roff"
SECTION = "base"
LICENSE = "GPL"
MAINTAINER = "Inge Arnesen <inge.arnesen@gmail.com>"
PR = "r2"

SRC_URI = "http://ftp.gnu.org/gnu/groff/groff-${PV}.tar.gz \
	           file://groff.patch;patch=1"

PARALLEL_MAKE = ""
# prefix and exec-prefix are broken and the .in file is broken too 
# and can't be autoreconf'ed, so specify every dir
EXTRA_OECONF="--prefix=${D} --exec-prefix=${D} --bindir=${D}${bindir} --datadir=${D}${datadir} --mandir=${D}${datadir}/man --infodir=${D}${datadir}/info"

inherit autotools

do_configure () {
	oe_runconf
}

#do_install() {
#	oe_runmake 'PREFIX=${D}' install
#}

