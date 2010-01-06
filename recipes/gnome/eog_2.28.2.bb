DESCRIPTION = "Image viewer for gnome"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "gtk+ glib-2.0 gnome-desktop gnome-icon-theme shared-mime-info zlib libexif lcms jpeg dbus-glib libxml2 " 

inherit gnome

FILES_${PN}-dbg += "${libdir}/eog/plugins/.debug"

