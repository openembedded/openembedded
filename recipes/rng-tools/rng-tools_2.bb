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

SRC_URI[md5sum] = "63d503191eabed630324c104cc024475"
SRC_URI[sha256sum] = "1126f0ecc8cab3af14a562cddc5d8ffeef47df7eba34a7aadcdee35a25ec2b1e"
