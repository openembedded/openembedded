HOMEPAGE = "http://www.packagekit.org/"
DEPENDS = "expat dbus-glib intltool-native ${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"
LICENSE = "LGPLv2+"
PR = "r0"

SRC_URI = "http://hal.freedesktop.org/releases/polkit-${PV}.tar.gz"
SRC_URI[md5sum] = "9f957bf046ff5a32b0fa0ffe1e35c09c"
SRC_URI[sha256sum] = "afe63bec81b7f49e884ea4f2671ec76db121d84d05f36e75cde9b4ca4c828186"

AUTHFW = "${@base_contains('DISTRO_FEATURES', 'pam', 'pam', 'shadow', d)}"
EXTRA_OECONF = "--with-authfw=${AUTHFW} \
                --with-os-type=${DISTRO} \
                --disable-man-pages \
                --disable-gtk-doc \
                --enable-introspection=no \
"

S = "${WORKDIR}/polkit-${PV}"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}${localstatedir}/run/PolicyKit
	${@base_contains('DISTRO_FEATURES', 'pam', 'sed -i -e s:system:common:g ${D}${sysconfdir}/pam.d/*', '', d)}
}

FILES_${PN} += " ${datadir}/dbus-1 \
                 ${datadir}/PolicyKit ${datadir}/polkit-1\
                 ${localstatedir}/run/PolicyKit \
                 ${libdir}/polkit-1/extensions/*.so \
"

FILES_${PN}-dev += " ${libdir}/polkit-1/extensions/*a"

pkg_postinst_${PN} () {
    # can't do this offline
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    grep "^polkituser:" /etc/group > /dev/null || addgroup polkituser
    grep "^polkituser:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/run/polkit polkituser --ingroup polkituser -g polkituser 

	# Fix owners
	for i in /etc/polkit-1/localauthority /var/lib/polkit-1 ; do
		mkdir -p $i
		chown root $i
		chmod 700 $i
	done

	for i in /usr/libexec/polkit-agent-helper-1 /usr/bin/pkexec ; do
		chown root $i
		chmod 4755 $i
	done

	DBUSPID=`pidof dbus-daemon`
    if [ "x$DBUSPID" != "x" ]; then
        /etc/init.d/dbus-1 force-reload
    fi
}

pkg_postrm_${PN} () {
    deluser polkituser || true
    delgroup polkituser || true
}
