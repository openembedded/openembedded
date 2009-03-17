DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
HOMEPAGE = "http://www.gnome.org"
PRIORITY = "optional"
DEPENDS = "libnl dbus dbus-glib hal gconf-dbus wireless-tools ppp"
RDEPENDS = "hal wpa-supplicant iproute2 dhcp-client"

PV = "0.7+svnr${SRCREV}"
PR = "r5"

SRC_URI="svn://svn.gnome.org/svn/NetworkManager/;module=trunk;proto=http \
	file://no-restarts.diff;patch=1;pnum=0 \
	file://25NetworkManager \
	file://99_networkmanager"

S = "${WORKDIR}/trunk"

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-ip=/sbin/ip.iproute2"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

do_install_append () {
	install -d ${D}/etc/default/volatiles
	install -m 0644 ${WORKDIR}/99_networkmanager ${D}/etc/default/volatiles
	install -d ${D}/etc/dbus-1/event.d
	install -m 0755 ${WORKDIR}/25NetworkManager ${D}/etc/dbus-1/event.d
	sed -i s,/sbin/ip,/sbin/ip.iproute2, ${D}/etc/init.d/NetworkManager
}

pkg_postinst () {
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

