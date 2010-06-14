DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPL"
DEPENDS = "networkmanager dbus-glib libglade gconf gnome-keyring"
#TODO DEPENDS libnotify
RDEPENDS_${PN} = "networkmanager"
PR = "r1"

inherit gnome gtk-icon-cache

SRC_URI = "svn://svn.gnome.org/svn/network-manager-applet/;module=trunk;proto=http \
           file://applet-no-gnome.diff;striplevel=0"

SRCREV = "200"

PV = "0.0+svnr${SRCPV}"

S = "${WORKDIR}/trunk"

FILES_${PN} += "${datadir}/nm-applet/ \
        ${datadir}/gnome-vpn-properties/ \
        ${datadir}/gnome/autostart/ \
        "
