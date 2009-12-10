DESCRIPTION = "A user-mode PPPoE client and server suite for Linux"
HOMEPAGE = "http://www.roaringpenguin.com/en/penguin/openSourceProducts/rpPppoe"
SECTION = "console/network"
LICENSE = "GPLv2"
RDEPENDS_${PN} = "ppp"
RDEPENDS_${PN}-server = "${PN}"
RRECOMMENDS_${PN} = "ppp-oe"
PR = "r6"

SRC_URI = "http://www.roaringpenguin.com/files/download/${P}.tar.gz \
           file://top-autoconf.patch;patch=1 \
           file://configure_in_cross.patch;patch=1 \
           file://pppoe-src-restrictions.patch;patch=1 \
           file://update-config.patch;patch=1 \
           file://dont-swallow-errors.patch;patch=1 \
           file://pppoe-server.default \
           file://pppoe-server.init"

inherit autotools update-rc.d

do_install() {
        # Install init script and default settings
        install -m 0755 -d ${D}${sysconfdir}/default ${D}${sysconfdir}/init.d
        install -m 0644 ${WORKDIR}/pppoe-server.default ${D}${sysconfdir}/default/pppoe-server
        install -m 0755 ${WORKDIR}/pppoe-server.init ${D}${sysconfdir}/init.d/pppoe-server
        # Install
        oe_runmake -C ${S} RPM_INSTALL_ROOT=${D} docdir=${docdir} install
}

# Insert server package before main package
PACKAGES = "${PN}-dbg ${PN}-server ${PN}-relay ${PN}-sniff ${PN} ${PN}-doc"

FILES_${PN}-server = "${sysconfdir}/default/pppoe-server \
                      ${sysconfdir}/init.d/pppoe-server \
                      ${sbindir}/pppoe-server \
                      ${sysconfdir}/ppp/pppoe-server-options"
FILES_${PN}-relay = "${sbindir}/pppoe-relay"
FILES_${PN}-sniff = "${sbindir}/pppoe-sniff"

pkg_postinst_${PN} () {
    if [ x"$D" != "x" ]; then
        exit 1
    fi
    chmod 4755 ${sbindir}/pppoe
}

CONFFILES_${PN} = "${sysconfdir}/ppp/pppoe.conf \
                   ${sysconfdir}/ppp/firewall-standalone \
                   ${sysconfdir}/ppp/firewall-masq"
CONFFILES_${PN}-server = "${sysconfdir}/ppp/pppoe-server-options \
                          ${sysconfdir}/default/pppoe-server"

INITSCRIPT_PACKAGES            = "${PN}-server"
INITSCRIPT_NAME_${PN}-server   = "pppoe-server"
INITSCRIPT_PARAMS_${PN}-server = "defaults 92 8"

