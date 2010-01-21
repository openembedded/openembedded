HOMEPAGE = "http://www.packagekit.org/"
DEPENDS = "libpam expat dbus-glib intltool-native"

PR = "r8"

SRC_URI = "http://hal.freedesktop.org/releases/PolicyKit-${PV}.tar.gz \
           file://PolicyKit.conf \
          "

EXTRA_OECONF = "--with-authfw=pam --with-os-type=moblin --disable-man-pages --disable-gtk-doc"

S = "${WORKDIR}/PolicyKit-${PV}"

inherit autotools pkgconfig

do_install_append () {
	install -m 0644 ${WORKDIR}/PolicyKit.conf ${D}${sysconfdir}/PolicyKit/PolicyKit.conf
	install -d ${D}${localstatedir}/run/PolicyKit
}

FILES_${PN} += " ${datadir}/dbus-1 \
                 ${datadir}/PolicyKit \
                 ${localstatedir}/run/PolicyKit \
"

pkg_postinst_${PN} () {
    # can't do this offline
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    grep "^polkituser:" /etc/group > /dev/null || addgroup polkituser
    grep "^polkituser:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/run/polkit polkituser --ingroup polkituser -g polkituser 

	echo "d root polkituser 0770 /var/run/PolicyKit none" > /etc/default/volatiles/98_policykit
	rm -f /etc/volatile.cache 

	# Fix owners
	for i in /var/lib/PolicyKit /usr/libexec/polkit-read-auth-helper /usr/libexec/polkit-revoke-helper /usr/libexec/polkit-grant-helper /usr/libexec/polkit-explicit-grant-helper /usr/libexec/polkit-grant-helper-pam ; do
		chown root:polkituser $i
	done

	for i in /var/lib/PolicyKit-public /usr/libexec/polkit-set-default-helper ; do
		chown polkituser:root $i
	done

	chown polkituser:polkituser /var/lib/misc/PolicyKit.reload
	chown root:root /usr/libexec/polkit-resolve-exe-helper
 
	# Fix permissions
	for i in /var/run/PolicyKit /var/lib/PolicyKit ; do
		chmod 770 $i
	done

	chmod 755 /var/lib/PolicyKit-public
	chmod 775 /var/lib/misc/PolicyKit.reload

	for i in /usr/libexec/polkit-read-auth-helper /usr/libexec/polkit-revoke-helper /usr/libexec/polkit-grant-helper /usr/libexec/polkit-explicit-grant-helper ; do
		chmod 2755 $i
	done

	for i in /usr/libexec/polkit-set-default-helper /usr/libexec/polkit-resolve-exe-helper ; do
		chmod 4755 $i
	done

	chmod 4754 /usr/libexec/polkit-grant-helper-pam

	DBUSPID=`pidof dbus-daemon`
    if [ "x$DBUSPID" != "x" ]; then
        /etc/init.d/dbus-1 force-reload
    fi
}

pkg_postrm_${PN} () {
    deluser polkituser || true
    delgroup polkituser || true
	rm -f /etc/default/volatiles/98_policykit
    rm -f /etc/volatile.cache  
}
