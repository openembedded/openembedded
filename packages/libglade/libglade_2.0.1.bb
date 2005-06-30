LICENSE = LGPL
DESCRIPTION = "Runtime support for GTK interface builder"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libxml2 gtk+"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libglade/2.0/libglade-${PV}.tar.bz2 \
           file://glade-cruft.patch;patch=1;pnum=0 \
           file://gtk-2.0.m4"

inherit autotools pkgconfig 

headers = "glade-build.h glade-init.h glade-parser.h glade-xml.h glade.h"

do_configure_prepend() {
	install -d m4
	install ${WORKDIR}/gtk-2.0.m4 m4/
}

do_stage () {
	oe_libinstall -a -so -C glade libglade-2.0 ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/libglade-2.0/glade
	for i in ${headers}; do
		install -m 0644 ${S}/glade/$i ${STAGING_INCDIR}/libglade-2.0/glade/$i
	done
}
