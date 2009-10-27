DESCRIPTION = "Notification daemon for the Xfce desktop."
DEPENDS = "pkgconfig dbus gtk+ libsexy"
RDEPENDS = "libxfce4util libxfcegui4 libnotify xfconf"

SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://spuriousinterrupt.org/files/${PN}/${PN}-${PV}.tar.bz2"

FILES_${PN} = "\
    ${datadir}/dbus-1/services \
    ${datadir}/themes \
    ${datadir}/icons \
    ${datadir}/applications \  
    ${libexecdir}/xfce4-notifyd \     
    ${bindir}/xfce4-notifyd-config \
"
