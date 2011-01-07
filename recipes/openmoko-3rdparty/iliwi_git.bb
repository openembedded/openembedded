DESCRIPTION = "Iliwi connects you to WiFi networks"
HOMEPAGE = "http://github.com/Ebbe/Iliwi"
LICENSE = "GPLv3"
AUTHOR = "Esben Damgaard <ebbe@hvemder.dk>"
DEPENDS = "dbus-glib elementary libgee"
# killall and udhcpc from busybox are enough
RDEPENDS_${PN} = "wireless-tools wpa-supplicant"

SRCREV = "fcd77fada06f6373b0fb5771f78aaa9dcaa97036"
PV = "0.0.1+gitr${SRCPV}"
SRC_URI = "git://github.com/Ebbe/Iliwi.git;protocol=http;branch=master"
PR = "r10"

SRC_URI = "git://github.com/Ebbe/Iliwi.git;protocol=http;branch=master \
           file://0001-adapt-to-elementary-genlist_item_insert_before-API-c.patch \
           file://new.vala.patch"
S = "${WORKDIR}/git"

inherit autotools vala
