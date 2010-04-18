DESCRIPTION = "Iliwi connects you."
HOMEPAGE = "http://github.com/Ebbe/Iliwi"
LICENSE = "GPLv3"
AUTHOR = "Esben Damgaard <ebbe@hvemder.dk>"
DEPENDS = "dbus-glib elementary"
# killall and udhcpc from busybox are enough
RDEPENDS = "wireless-tools wpa-supplicant"

SRCREV = "adae747061e8d885bbe9084814dad169fb00fae2"
PV = "0.0.1+gitr${SRCPV}"

SRC_URI = "git://github.com/Ebbe/Iliwi.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools vala

# needed because there is do_stage_append in vala.bbclass and do_stage() was removed..
do_stage() {

}
