DESCRIPTION = "Transmission is a BitTorrent client w/ a built-in Ajax-Powered Webif GUI."
SECTION = "network"
HOMEPAGE = "www.transmissionbt.com/"
DEPENDS = "gtk+ gnutls openssl gettext libtool intltool-native curl glib-2.0-native"
LICENSE = "GPLv2"
PR = "r4"
SRC_URI = "http://mirrors.m0k.org/transmission/files/transmission-${PV}.tar.bz2;name=archive \
           file://init \
           file://config"

INITSCRIPT_NAME = "transmission"
INITSCRIPT_PARAMS = "defaults 60 "

inherit autotools update-rc.d

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/transmission
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/config ${D}${sysconfdir}/default/transmission-daemon
	install -d ${D}${localstatedir}/lib/transmission-daemon
}

PACKAGES += "${PN}-gui ${PN}-client"

FILES_${PN} = "${bindir}/transmission-daemon ${datadir}/transmission ${sysconfdir} ${localstatedir}/lib/${PN}-daemon"
FILES_${PN}-client = "${bindir}/transmissioncli ${bindir}/transmission-remote"
FILES_${PN}-gui += "${bindir}/transmission ${datadir}/icons ${datadir}/applications ${datadir}/pixmaps"
CONFFILES_${PN} = "${sysconfdir}/default/transmission-daemon"

# No need for online check, since update-rc.d will prepend it to here
pkg_postinst_${PN}() {
grep -q transmission  ${sysconfdir}/group || addgroup transmission
grep -q transmission ${sysconfdir}/passwd || adduser -h ${localstatedir}/lib/transmission-daemon -S -D -G transmission -s ${base_bindir}/false transmission
chown -R transmission:transmission /var/lib/transmission-daemon/
}

pkg_postrm_${PN}() {
delgroup transmission
deluser transmission
}
