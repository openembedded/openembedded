DESCRIPTION = "Iliwi connects you to WiFi networks"
HOMEPAGE = "http://github.com/Ebbe/Iliwi"
LICENSE = "GPLv3"
AUTHOR = "Esben Damgaard <ebbe@hvemder.dk>"
DEPENDS = "dbus-glib elementary"
# killall and udhcpc from busybox are enough
RDEPENDS = "wireless-tools wpa-supplicant"

SRCREV = "5be2b301033418fb9a33759047274b676034f096"
PV = "0.0.1+gitr${SRCPV}"

SRC_URI = "git://github.com/Ebbe/Iliwi.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools vala

# needed because there is do_stage_append in vala.bbclass and no do_stage()
do_stage() {

}
