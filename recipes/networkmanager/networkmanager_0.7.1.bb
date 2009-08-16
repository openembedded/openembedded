DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
HOMEPAGE = "http://www.gnome.org"
PRIORITY = "optional"
DEPENDS = "libnl dbus dbus-glib hal gconf-dbus wireless-tools policykit"
RDEPENDS = "wpa-supplicant iproute2 dhcdbd"

PR = "r1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/NetworkManager/0.7/NetworkManager-${PV}.tar.bz2 \
	  file://NetworkManager \
	  file://99_networkmanager"

S = "${WORKDIR}/NetworkManager-${PV}/"

inherit autotools pkgconfig


EXTRA_OECONF = " \
		--with-gnome \
		--with-distro=debian \
		--without-gcrypt \
 		--with-wpa_supplicant=/usr/sbin/wpa_supplicant \
		--with-dhcdbd=/sbin/dhcdbd \
		--with-ip=/sbin/ip.iproute2 \
		--with-crypto=gnutls \
		--enable-more-warnings=no \
		--disable-rpath"


pkg_postinst_${PN} () {
if [ "x$D" != "x" ]; then
        exit 1
fi
/etc/init.d/populate-volatile.sh update
}

PACKAGES =+ "libnmutil libnmglib libnmglib-vpn" 

FILES_libnmutil += "${libdir}/libnm-util.so.*"
FILES_libnmglib += "${libdir}/libnm_glib.so.*"
FILES_libnmglib-vpn += "${libdir}/libnm_glib_vpn.so.*"

FILES_${PN} += " \
		${libexecdir} \
		${libdir}/pppd/*/nm-pppd-plugin.so \
		${libdir}/NetworkManager/*.so"
FILES_${PN}-dbg += "${libdir}/NetworkManager/.debug/ \
		    ${libdir}/pppd/*/.debug/ "

FILES_${PN}-dev += " ${datadir}/NetworkManager/gdb-cmd "

