require libglade.inc

PR = "r1"
DEPENDS += "libxml2"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libglade/2.0/libglade-${PV}.tar.bz2 \
           file://glade-cruft.patch;patch=1;pnum=0 \
           file://gtk-2.0.m4"

do_configure_prepend() {
	install -d m4
	install ${WORKDIR}/gtk-2.0.m4 m4/
}
