DESCRIPTION = "Collection of DLNA[1] (UPnP[2] AV) devices, implemented through a plug-in mechanism."
SECTION = "network/multimedia"
DEPENDS = "glib-2.0 gupnp gupnp-av gstreamer sqlite3 libsoup-2.4 "
HOMEPAGE = "http://live.gnome.org/Rygel"

SRC_URI = "http://ftp.acc.umu.se/pub/GNOME/sources/rygel/0.4/rygel-${PV}.tar.bz2 \
           file://configure.ac.patch;patch=1"

inherit autotools

# Needs automake 1.11.x, which isn't safe to use yet in OE
do_configure() {
	oe_runconf
}

EXTRA_OECONF = "--enable-vala=no"

FILES_${PN} += "${libdir}/rygel-1.0/librygel*.so ${datadir}/dbus-1/"
FILES_${PN}-dbg += "${libdir}/rygel-1.0/.debug/"
