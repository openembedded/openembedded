DESCRIPTION = "Simple MPlayer frontend with lite Gnome integration"
AUTHOR = "Kevin DeKorte <kdekorte@gmail.com>"
HOMEPAGE = "http://code.google.com/p/gnome-mplayer/"
SECTION = "x11/multimedia"
LICENSE = "GPL"
DEPENDS = "curl gtk+ gconf dbus-glib libmusicbrainz libgpod"
RDEPENDS = "mplayer"

inherit gnome

INC_PR = "r10"

SRC_URI = "http://gnome-mplayer.googlecode.com/files/${P}.tar.gz;name=gnomemplayer"

PACKAGES =+ "${PN}-nautilus-extension"
FILES_${PN}-nautilus-extension = "${libdir}/nautilus/extension*/*.so"

FILES_${PN}-dbg += "${libdir}/nautilus/*/.debug"

FILES_${PN} += "${datadir}/icons  ${datadir}/gnome-control-center/"

do_install_append() {
    sed -i "s/OnlyShowIn=GNOME;//" ${D}${datadir}/applications/gnome-mplayer.desktop
}   
