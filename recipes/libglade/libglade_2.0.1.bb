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

SRC_URI[md5sum] = "4d93f6b01510013ae429e91af432cfe2"
SRC_URI[sha256sum] = "6386901d84cb41fb8a584f7aa1b54c984e0590f36f45ee016ef30aa45554194d"
