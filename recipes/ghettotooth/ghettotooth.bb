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

SRC_URI[md5sum] = "dc94cb07c6e43fc8c4745b728b0ce32b"
SRC_URI[sha256sum] = "71e285da2f8f03dd0c6f6a969d1f541ab2a2f1a9d91e26f6f60779897d68824e"
