DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPL"
PRIORITY = "optional"
DEPENDS = "libnl dbus dbus-glib hal wireless-tools policykit gnutls e2fsprogs-libs ppp"
RDEPENDS = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "

RCONFLICTS_${PN} = "connman"

inherit gnome update-rc.d

SRC_URI = "${GNOME_MIRROR}/NetworkManager/${@gnome_verdir("${PV}")}/NetworkManager-${PV}.tar.bz2"

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

INITSCRIPT_NAME = "NetworkManager"
INITSCRIPT_PARAMS = "defaults 28"

do_stage () {
	autotools_stage_all
}

# Work around dbus permission problems since we lack a proper at_console
do_install_prepend() {
		sed -i -e s:deny:allow:g ${S}/src/NetworkManager.conf
		sed -i -e s:deny:allow:g ${S}/system-settings/src/nm-system-settings.conf || true
		sed -i -e s:deny:allow:g ${S}/callouts/nm-dispatcher.conf
}

do_install_append () {
        install -d ${D}/etc/default/volatiles
        install -d ${D}/etc/dbus-1/event.d
        # Test binaries
        install -d ${D}/usr/bin
        install -m 0755 ${S}/test/.libs/nm-tool ${D}/usr/bin
        install -m 0755 ${S}/test/.libs/libnm* ${D}/usr/bin
        install -m 0755 ${S}/test/.libs/nm-online ${D}/usr/bin
}

pkg_postinst_${PN} () {
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	/etc/init.d/populate-volatile.sh update
}

PACKAGES =+ "libnmutil libnmglib libnmglib-vpn ${PN}-tests" 

FILES_libnmutil += "${libdir}/libnm-util.so.*"
FILES_libnmglib += "${libdir}/libnm_glib.so.*"
FILES_libnmglib-vpn += "${libdir}/libnm_glib_vpn.so.*"


FILES_${PN} += " \
		${libexecdir} \
		${libdir}/pppd/*/nm-pppd-plugin.so \
		${libdir}/NetworkManager/*.so \
		${datadir}/PolicyKit \
		${datadir}/dbus-1 \
		${base_libdir}/udev/* \
"

FILES_${PN}-dbg += "${libdir}/NetworkManager/.debug/ \
		    ${libdir}/pppd/*/.debug/ "

FILES_${PN}-dev += "${datadir}/NetworkManager/gdb-cmd \
                    ${libdir}/pppd/*/*.a \
                    ${libdir}/pppd/*/*.la \
                    ${libdir}/NetworkManager/*.a \
                    ${libdir}/NetworkManager/*.la"

FILES_${PN}-tests = "${bindir}/nm-tool \
                     ${bindir}/libnm_glib_test \
                     ${bindir}/nminfotest \
                     ${bindir}/nm-online \
                     ${bindir}/nm-supplicant \
                     ${bindir}/nm-testdevices"
