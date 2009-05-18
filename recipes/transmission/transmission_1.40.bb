DESCRIPTION = "Transmission is a BitTorrent client w/ a built-in Ajax-Powered Webif GUI."
SECTION = "network"
HOMEPAGE = "www.transmissionbt.com/"
DEPENDS = "openssl gettext libtool intltool-native curl glib-2.0-native"
LICENSE = "GPLv2"
PR = "r2"
SRC_URI = "http://mirrors.m0k.org/transmission/files/transmission-${PV}.tar.bz2 \
           file://init"

INITSCRIPT_NAME = "transmission"
INITSCRIPT_PARAMS = "defaults 60 "

inherit autotools update-rc.d

do_install_append() {
	install -d -p ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/transmission
}

# No need for online check, since update-rc.d will prepend it to here
pkg_postinst_${PN}() {
grep -q transmission  ${sysconfdir}/group || addgroup transmission
grep -q transmission ${sysconfdir}/passwd || adduser -h /home/transmission -S -D -G transmission -s ${base_bindir}/false transmission
mkdir -p /home/transmission/.config
chown transmission:transmission /home/transmission/.config
}

pkg_postrm_${PN}() {
delgroup transmission
deluser transmission
}

