DESCRIPTION = "A user-mode PPPoE client and server suite for Linux"
HOMEPAGE = "http://www.roaringpenguin.com/en/penguin/openSourceProducts/rpPppoe"
SECTION = "console/network"
LICENSE = "GPLv2"
RDEPENDS_${PN} = "ppp"
RDEPENDS_${PN}-server = "ppp"
RRECOMMENDS_${PN} = "ppp-oe"
PR = "r2"

SRC_URI = "http://www.roaringpenguin.com/files/download/${P}.tar.gz \
           file://configure_in_cross.patch;patch=1;pnum=2 \
           file://pppoe-src-restrictions.patch;patch=1;pnum=2 \
           file://pppoe-server.default \
           file://pppoe-server.init"

S = "${WORKDIR}/${P}/src"

inherit autotools update-rc.d

do_install() {
        # Set timeout to 0. Fixes lots of reconnect issues
        # No need for full path to the PPPoE plugin, and it's in a different 
        # Can't patch this in because it's outside of what we have {S} set to.
        sed -i -e 's,\(CONNECT_TIMEOUT=\)30,\10,g' \
               -e 's,\(LINUX_PLUGIN=\)/etc/ppp/plugins/rp-pppoe.so,\1rp-pppoe.so,g' \
               ${S}/../configs/pppoe.conf
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
INITSCRIPT_PARAMS_${PN}-server = "defaults 92 08"

