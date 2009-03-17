SECTION = "network/misc"
DESCRIPTION = "Bluetooth scanner"
LICENSE = "GPL"
RDEPENDS = "perl"

SRC_URI = "http://www.wardriving.ch/hpneu/blue/perl/ghettotooth.pl"

DEFAULT_PREFERENCE="-1"


S = "${WORKDIR}"
do_install() {
	install -d ${D}${bindir}
	install -m 0755 ghettotooth.pl ${D}${bindir}/
}
