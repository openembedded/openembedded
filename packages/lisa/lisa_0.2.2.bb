SECTION = "console/network"
DESCRIPTION = "LISa is a small daemon which provides something \
like the network neighbourhood under windows, but more and \
only relying on the TCP/IP protocol stack."

SRC_URI = "http://lisa-home.sourceforge.net/src/lisa-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://head-n.patch;patch=1"
LICENSE = "GPL"
inherit autotools 

do_configure_prepend () {
	set -e
	rm -f configure.in configure.files acinclude.m4 subdirs
	oe_runmake -f admin/Makefile.common configure.in
	oe_runmake -f admin/Makefile.common configure.files
	cat admin/acinclude.m4.in admin/libtool.m4.in > acinclude.m4
	oe_runmake -f admin/Makefile.common subdirs
}
