DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
HOMEPAGE = "http://www.gnome.org"
PRIORITY = "optional"
DEPENDS = "libnl dbus dbus-glib hal gconf-dbus wireless-tools"
RDEPENDS = "wpa-supplicant iproute2 dhcdbd"
PR = "r1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/NetworkManager/0.6/NetworkManager-${PV}.tar.bz2 \
	  file://NetworkManager \
	  file://99_networkmanager"

S = "${WORKDIR}/NetworkManager-${PV}/"


EXTRA_OECONF = " \
		--with-gnome \
		--with-distro=debian \
		--without-gcrypt \
 		--with-wpa_supplicant=/usr/sbin/wpa_supplicant \
		--with-dhcdbd=/sbin/dhcdbd \
		--with-ip=/sbin/ip.iproute2"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

do_install () {
	oe_libinstall -C libnm-util libnm-util ${D}/usr/lib
	oe_libinstall -C gnome/libnm_glib libnm_glib ${D}/usr/lib

	oe_runmake -C src DESTDIR="${D}" install
	install -d ${D}/etc/default/volatiles
	install -m 0644 ${WORKDIR}/99_networkmanager ${D}/etc/default/volatiles
	install -d ${D}/etc/init.d/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d/
	install -d ${D}/${datadir}/
}

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

