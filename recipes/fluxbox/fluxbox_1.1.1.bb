DESCRIPTION = "The Fluxbox Windowmanager"
HOMEPAGE = "http://www.fluxbox.org"
LICENSE = "MIT"
DEPENDS = "fontconfig virtual/libx11"

PE = "1"

SRC_URI = "${SOURCEFORGE_MIRROR}/fluxbox/fluxbox-${PV}.tar.gz \
           file://fluxbox-wm \
          "

inherit autotools update-alternatives

EXTRA_OECONF = "--disable-xmb \
                "

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/fluxbox-wm ${D}${bindir}
}

FILES_${PN} += "${datadir}/fluxbox/"

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_PATH = "${bindir}/fluxbox-wm"
ALTERNATIVE_LINK = "x-window-manager"
ALTERNATIVE_PRIORITY = "20"


SRC_URI[md5sum] = "e0be927617be4ffc1ddc79513f4eb0f9"
SRC_URI[sha256sum] = "7306ee55a8e95a4d07bee339ffb3be2d88ef8cc08b86edd6c63d7b28f559ec88"
