SRC_URI = http://ftp.gnome.org/pub/gnome/sources/glib/1.2/glib-${PV}.tar.gz \
	  file://${FILESDIR}/configure.patch;patch=1

inherit autotools

do_configure_prepend () {
	install -m 0644 ${FILESDIR}/glibconfig-sysdefs.h .
}
