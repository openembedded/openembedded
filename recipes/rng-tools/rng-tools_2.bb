DESCRIPTION = "Random number generator daemon"
LICENSE = "GPL"
DEPENDS_append_libc-uclibc = " argp-standalone"
PR = "3"

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/gkernel/${P}.tar.gz \
           file://init \
           file://default"

inherit autotools update-rc.d

INITSCRIPT_NAME = "rng-tools"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
        install -d "${D}${sysconfdir}/init.d"
        sed -e's,/etc/,${sysconfdir}/,; s,/usr/sbin/,${sbindir},' \
            ${WORKDIR}/init > ${D}${sysconfdir}/init.d/rng-tools

        install -d "${D}${sysconfdir}/default"
        install -m 0644 ${WORKDIR}/default ${D}${sysconfdir}/default
}

SRC_URI[md5sum] = "63d503191eabed630324c104cc024475"
SRC_URI[sha256sum] = "1126f0ecc8cab3af14a562cddc5d8ffeef47df7eba34a7aadcdee35a25ec2b1e"
