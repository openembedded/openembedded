DESCRIPTION = "Text editor for Xfce based on Leafpad"
DEPENDS = "libxfce4util xfce-mcs-manager hal liburi-perl-native python-native"

inherit xfce

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.1/src/mousepad-${PV}.tar.bz2"
