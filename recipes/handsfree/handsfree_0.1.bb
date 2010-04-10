DESCRIPTION = "Handsfree and Handset Bluetooth tool"
HOMEPAGE = "http://www.soft.uni-linz.ac.at/_wiki/tiki-index.php?page=ProjectBluezHandsfree"
SECTION = "network/misc"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS= "bluez-libs alsa-lib"
PR = "r0"


SRC_URI = "\
   http://www.soft.uni-linz.ac.at/~vogl/bluez/handsfree-040326.tar.gz \
  file://Makefile.patch;patch=1 \
"
S = "${WORKDIR}/handsfree"

# Alsa devices
# Example: "plughw:0,0"
ALSA_PLAY = "default"
ALSA_REC = "default"

CFLAGS =+ "-DOSS=0 "
LDFLAGS =+ "-lbluetooth -lasound "

do_compile() {
	oe_runmake all
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 handsfree ${D}${bindir}
	install -m 0755 headset ${D}${bindir}
}

SRC_URI[md5sum] = "488b0f2f346361bba7996b459c5d7b6f"
SRC_URI[sha256sum] = "dbd0c389a160c9f6dcd9eac81b6c4d5a02866968a33f06201556d6860012f6c3"
