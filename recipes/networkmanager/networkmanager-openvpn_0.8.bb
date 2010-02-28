DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib hal wireless-tools policykit gnutls e2fsprogs-libs ppp"
RDEPENDS = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

inherit autotools pkgconfig

PR = "r1"

SRC_URI += "${GNOME_MIRROR}/NetworkManager-openvpn/${@gnome_verdir("${PV}")}/NetworkManager-openvpn-${PV}.tar.bz2 \
"

S = "${WORKDIR}/NetworkManager-openvpn-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "


