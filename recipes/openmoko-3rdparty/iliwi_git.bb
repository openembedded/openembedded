DESCRIPTION = "Iliwi connects you to WiFi networks"
HOMEPAGE = "http://github.com/Ebbe/Iliwi"
LICENSE = "GPLv3"
AUTHOR = "Esben Damgaard <ebbe@hvemder.dk>"
DEPENDS = "dbus-glib elementary libgee libeflvala"
# killall and udhcpc from busybox are enough
RDEPENDS_${PN} = "wireless-tools wpa-supplicant"

SRCREV = "fcd77fada06f6373b0fb5771f78aaa9dcaa97036"
PV = "0.0.1+gitr${SRCPV}"
PR = "r9"

SRC_URI = "git://github.com/Ebbe/Iliwi.git;protocol=http;branch=master \
           file://new.vala.patch"
S = "${WORKDIR}/git"

inherit autotools vala
