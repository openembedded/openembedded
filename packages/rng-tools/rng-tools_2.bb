DESCRIPTION = "Random number generator daemon"
LICENSE = "GPL"
PR = "1"

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/gkernel/${P}.tar.gz \
           file://init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "rng-tools"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
        install -d "${D}${sysconfdir}/init.d"
        install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/rng-tools
}
