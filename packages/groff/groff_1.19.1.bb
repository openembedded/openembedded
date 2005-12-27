LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "GNU roff"
MAINTAINER = "Inge Arnesen <inge.arnesen@gmail.com>"
SRC_URI = "http://ftp.gnu.org/gnu/groff/groff-${PV}.tar.gz \
	           file://groff.patch;patch=1"
PR = "r1"

# prefix and exec-prefix are broken and the .in file is broken too 
# and can't be autoreconf'ed, so specify every dir
EXTRA_OECONF="--prefix=${D} --exec-prefix=${D} --bindir=${D}/usr/bin --datadir=${D}/usr/share --mandir=${D}/usr/man --infodir=${D}/usr/share/info"

inherit autotools

do_configure () {
	oe_runconf
}

#do_install() {
#	oe_runmake 'PREFIX=${D}' install
#}

