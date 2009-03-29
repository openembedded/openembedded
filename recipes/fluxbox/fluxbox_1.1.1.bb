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

