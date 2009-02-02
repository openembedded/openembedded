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
