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

SRC_URI[md5sum] = "da9effc847d13f9725b6db043d8283a5"
SRC_URI[sha256sum] = "567a50863c04dc9ccf5def3c62bb9f0494e995357620603dd00bbe035ca7500e"
