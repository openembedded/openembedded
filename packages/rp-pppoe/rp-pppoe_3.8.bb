DESCRIPTION = "A user-mode PPPoE client and server suite for Linux"
HOMEPAGE = "http://www.roaringpenguin.com/en/penguin/openSourceProducts/rpPppoe"
SECTION = "console/network"
LICENSE = "GPLv2"
RDEPENDS = "ppp"
RRECOMMENDS = "ppp-oe"
PR = "r1"

SRC_URI = "http://www.roaringpenguin.com/files/download/${P}.tar.gz \
           file://configure_in_cross.patch;patch=1;pnum=2 \
           file://pppoe-src-restrictions.patch;patch=1;pnum=2"

S = "${WORKDIR}/${P}/src"

inherit autotools

do_install() {
        # Set timeout to 0. Fixes lots of reconnect issues
        # No need for full path to the PPPoE plugin, and it's in a different 
        # Can't patch this in because it's outside of what we have {S} set to.
        sed -i -e 's,\(CONNECT_TIMEOUT=\)30,\10,g' \
               -e 's,\(LINUX_PLUGIN=\)/etc/ppp/plugins/rp-pppoe.so,\1rp-pppoe.so,g' \
               ${S}/../configs/pppoe.conf
        # Install
        oe_runmake -C ${S} RPM_INSTALL_ROOT=${D} docdir=${docdir} install
}

pkg_postinst() {
    if [ x"$D" != "x" ]; then
        exit 1
    fi
    chmod 4755 ${sbindir}/pppoe
}

CONFFILES_${PN} = "${sysconfdir}/ppp/pppoe-server-options \
                   ${sysconfdir}/ppp/pppoe.conf \
                   ${sysconfdir}/ppp/firewall-standalone \
                   ${sysconfdir}/ppp/firewall-masq"
