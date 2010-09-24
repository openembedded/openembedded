DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib hal wireless-tools policykit gnutls util-linux-ng ppp libglade gnome-keyring"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

inherit autotools pkgconfig

SRC_URI += "${GNOME_MIRROR}/NetworkManager-openvpn/0.8/NetworkManager-openvpn-${PV}.tar.bz2 \
"

SRC_URI[md5sum] = "0995450e31d1a47c3e3767de9773b7a7"
SRC_URI[sha256sum] = "7deac7c07da82292722f74135462e36a964ace7faf43e9a6d367dcefea721ecc"


S = "${WORKDIR}/NetworkManager-openvpn-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "

