DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib hal wireless-tools policykit gnutls util-linux-ng ppp libglade gnome-keyring"
RDEPENDS = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

inherit autotools pkgconfig

PR = "r1"

SRC_URI += "${GNOME_MIRROR}/NetworkManager-openvpn/${PV}/NetworkManager-openvpn-${PV}.tar.bz2 \
"

S = "${WORKDIR}/NetworkManager-openvpn-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "



SRC_URI[md5sum] = "5039d6a840be45445db876cd71d64d20"
SRC_URI[sha256sum] = "8fd6f25093ade66a98ce1327f24ef953351aabf02870c5dcf12500a6b7f08d43"