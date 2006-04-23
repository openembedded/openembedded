DESCRIPTION = "GTK panel applet to control bluetooth stuff"
LICENSE = "GPLv2"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

DEPENDS = "bluez-utils-dbus libglade dbus libnotify popt gtk+"
SRC_URI = "http://www.cin.ufpe.br/~ckt/gbluezconf/${P}.tar.gz"

inherit autotools pkgconfig




