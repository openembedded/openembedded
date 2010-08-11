inherit gnome vala

DESCRIPTION = "Collection of DLNA[1] (UPnP[2] AV) devices, implemented through a plug-in mechanism."
SECTION = "network/multimedia"
DEPENDS = "glib-2.0 gupnp gupnp-av gstreamer sqlite3 libsoup-2.4 "
HOMEPAGE = "http://live.gnome.org/Rygel"

SRC_URI[archive.md5sum] = "037894e84f9b57c32e9bde75ee5b4dbf"
SRC_URI[archive.sha256sum] = "94b0904468c74d0931c95ba0920c5585e96f25cf014dd9756f78d5b6f2e428ca"

#EXTRA_OECONF = "--enable-vala=no"

do_configure() {
    libtoolize --force
    gnu-configize --force
    oe_runconf
}

FILES_${PN} += "${libdir}/rygel-1.0/librygel*.so ${datadir}/dbus-1/"
FILES_${PN}-dbg += "${libdir}/rygel-1.0/.debug/"
