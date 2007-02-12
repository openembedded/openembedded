DESCRIPTION = "GNOME NetworkManager port"
SECTION = "network/misc"
LICENSE = "GPL"
HOMEPAGE = "http://www.gnome.org"
PRIORITY = "optional"
DEPENDS = "libnl dbus dbus-glib libhal-nm libgpewidget gnome-keyring gconf-dbus wireless-tools libglade"
RDEPENDS = "wpa-supplicant iproute2 dhcdbd gnome-keyring hicolor-icon-theme"

PR = "r5"

SRC_URI="http://www.handhelds.org/~mmp/files/NetworkManager-${PV}-gpe.tar.gz \
	file://dbus-api-fix.patch;patch=1 \
	file://dbus-1.0-fix.patch;patch=1 \
        file://99_networkmanager \
	file://NetworkManager \
	file://nm-applet.desktop"

EXTRA_OECONF = " \
		--without-gnome \
		--with-gpe \
		--with-distro=debian \
		--without-gcrypt \
 		--with-wpa_supplicant=/usr/sbin/wpa_supplicant \
		--disable-hal  \
		--with-dhcdbd=/sbin/dhcdbd"

S = "${WORKDIR}/NetworkManager-${PV}"

inherit autotools

do_staging () {
	autotools_stage_includes
	oe_libinstall -C libnm-util libnm-util ${STAGING_LIBDIR}
	oe_libinstall gnome/libnm_glib libnm_glib ${STAGING_LIBDIR}
}

do_install () {
	oe_libinstall -C libnm-util libnm-util ${D}/usr/lib
	oe_libinstall -C gnome/libnm_glib libnm_glib ${D}/usr/lib

	oe_runmake -C src DESTDIR="${D}" install
	oe_runmake -C gnome/applet DESTDIR="${D}" install
	install -d ${D}/etc/default/volatiles
	install -m 0644 ${WORKDIR}/99_networkmanager ${D}/etc/default/volatiles
	install -d ${D}/etc/init.d/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d/
	install -d ${D}/${datadir}/
	install -m 0755 ${WORKDIR}/nm-applet.desktop ${D}/${datadir}/
}

pkg_postinst () {
	/etc/init.d/populate-volatile.sh update
}

FILES_${PN} += "${datadir} \
		${libdir}/*.so* \
		${libdir}/*.la \
		${sbindir} \
             	${bindir} \
		${sysconfdir} \
		${libexecdir}"

FILES_${PN}-dev = "${incdir} \
		   ${libdir}/*.a \
		   ${libdir}/pkgconfig"

