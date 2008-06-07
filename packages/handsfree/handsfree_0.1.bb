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
