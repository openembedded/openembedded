SECTION = "unknown"
DEPENDS = "mono-native glib-2.0"
LICENSE = "GPL LGPL X11"
SRC_URI = "http://mono2.ximian.com/archive/1.0/mono-1.0.tar.gz \
	file://libtool-lossage.patch;patch=1 \
	file://install-lossage.patch;patch=1"

EXTRA_OECONF_arm = "--without-nptl"

inherit autotools

do_configure_prepend() {
	rm -f libgc/libtool.m4
}

do_install() {
	oe_runmake 'DESTDIR=${D}' mono_runtime='mint' install
}
