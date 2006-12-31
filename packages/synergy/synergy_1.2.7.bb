DESCRIPTION = "Synergy - control multiple computers with one keyboard and mouse"
HOMEPAGE = "http://synergy2.sourceforge.net/"
LICENSE = "GPLv2"
SECTION = "x11/utils"
# NOTE: This depends on full x11, not diet-x11
DEPENDS = "libx11 libxtst"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/synergy2/synergy-${PV}.tar.gz"

do_configure_prepend() {
	grep -l -- -Werror "${S}/"* | xargs sed -i 's:-Werror::'
}

inherit autotools
