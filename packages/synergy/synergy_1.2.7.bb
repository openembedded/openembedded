DESCRIPTION = "Synergy - control multiple computers with one keyboard and mouse"
HOMEPAGE = "http://synergy2.sourceforge.net/"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "x11"
# NOTE: This depends on full x11, not diet-x11
DEPENDS = "libx11 libxtst"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/synergy2/synergy-${PV}.tar.gz"

do_configure_prepend() {
	grep -l -- -Werror "${S}/"* | xargs sed -i 's:-Werror::' 
}

inherit autotools
