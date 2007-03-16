DESCRIPTION = "IPv6 router advertisement daemon"
HOMEPAGE = "http://www.litech.org/radvd/"
SECTION = "console/network"
LICENSE = "BSD"
DEPENDS = "flex-native"

SRC_URI = "http://v6web.litech.org/radvd/dist/radvd-${PV}.tar.gz;md5sum=${MD5SUM} \
           file://radvd.init \
           file://volatiles.03_radvd \
           file://radvd.conf.empty"

S = "${WORKDIR}/radvd-${PV}"

inherit autotools update-rc.d

do_install_append () {
        install -m 0755 -d ${D}${sysconfdir}/init.d \
                           ${D}${sysconfdir}/default/volatiles \
                           ${D}${docdir}/radvd
        # Install init script and volatiles
        install -m 0755 ${WORKDIR}/radvd.init ${D}${sysconfdir}/init.d/radvd
        install -m 0644 ${WORKDIR}/volatiles.03_radvd ${D}${sysconfdir}/default/volatiles/volatiles.03_radvd
        # Initial configuration
        # install -m 0644 ${WORKDIR}/radvd.conf.empty ${D}${sysconfdir}/radvd.conf
        # Documentation
        for i in ${WORKDIR}/radvd.conf.empty radvd.conf.example README; do \
            install -m 0644 $i ${D}${docdir}/radvd; \
        done
}

#CONFFILES_${PN} = "${sysconfdir}/radvd.conf"

INITSCRIPT_NAME = "radvd"
INITSCRIPT_PARAMS = "defaults 20 80"

pkg_postinst_${PN} () {
        grep -q radvd: /etc/passwd || \
            adduser --disabled-password --home=/var/run/radvd/ --system \
                    --ingroup nogroup --no-create-home -g "IPv6 router advertisement daemon" radvd
        /etc/init.d/populate-volatile.sh update
}
