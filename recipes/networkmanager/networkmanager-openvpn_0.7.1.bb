DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib hal wireless-tools policykit gnutls util-linux-ng ppp"
RDEPENDS = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

inherit autotools pkgconfig

PR = "r1"

SRC_URI += "http://ftp.gnome.org/pub/GNOME/sources/NetworkManager-openvpn/0.7/NetworkManager-openvpn-${PV}.tar.bz2 \
"

S = "${WORKDIR}/NetworkManager-openvpn-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "



SRC_URI[md5sum] = "3637145716d5a2d55af0d713e4f05c68"
SRC_URI[sha256sum] = "7c6a7b9b8c6ccf3e2fbf2431b9fb2035f99e1d78065f3344f667e2f108f38d5b"
