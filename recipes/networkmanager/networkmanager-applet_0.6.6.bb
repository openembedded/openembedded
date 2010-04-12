DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "networkmanager dbus-glib libglade gconf gnome-keyring"
#TODO DEPENDS libnotify
RDEPENDS = "networkmanager"

inherit gnome gtk-icon-cache

SRC_URI = "http://people.redhat.com/dcbw/NetworkManager/0.6.6/nm-applet-0.6.6.tar.gz \
 file://applet-no-gnome.diff;patch=1;pnum=0"

FILES_${PN} += "${datadir}/nm-applet/ \
        ${datadir}/gnome-vpn-properties/ \
        ${datadir}/gnome/autostart/ \
        "

SRC_URI[md5sum] = "16e95a3515e4255d034b14045a9effd5"
SRC_URI[sha256sum] = "8eb264d5838d1f9e2e507a570cb23dc54e11505023b71b6868cee31da2dff38d"
