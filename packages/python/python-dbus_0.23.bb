DESCRIPTION = "Python bindings for DBus, a socket-based message bus system for interprocess communication"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "expat glib-2.0 virtual/libintl python-pyrex-native python"
RDEPENDS = "dbus"
PR = "ml1"

SRC_URI = "http://freedesktop.org/software/dbus/releases/dbus-${PV}.tar.gz \
	   file://cross.patch;patch=1 \
	   file://tmpdir.patch;patch=1 \
	   file://gettext.patch;patch=1"
S = "${WORKDIR}/dbus-${PV}"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-qt --disable-gtk --disable-tests \
		--disable-checks --disable-xml-docs --disable-doxygen-docs \
		--with-xml=expat --without-x --enable-python"

FILES_${PN} = "${libdir}/python2.4/site-packages/dbus.* ${libdir}/python2.4/site-packages/dbus_bindings.so"

