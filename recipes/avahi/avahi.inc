DESCRIPTION = "Avahi implements the DNS-SD over Multicast DNS"
AUTHOR = "Lennart Poettering <lennart@poettering.net>"
HOMEPAGE = "http://avahi.org"
SECTION = "network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "expat virtual/libintl libdaemon dbus glib-2.0"

# uclibc has no nss
RRECOMMENDS_avahi-daemon_append_libc-glibc = "libnss-mdns"
RDEPENDS_avahi-daemon += "sysvinit-pidof update-rc.d"
RDEPENDS_avahi-autoipd += "update-rc.d"

SRC_URI = "http://avahi.org/download/avahi-${PV}.tar.gz \
	   file://00avahi-autoipd file://99avahi-autoipd"

inherit autotools pkgconfig update-rc.d python-dir
# handle update-rc.d RDEPENDS manually, we don't need it on
# anything but avahi-daemon and avahi-autoipd
RDEPENDS_append = ""

# TODO: build and enable all the extra stuff avahi offers
EXTRA_OECONF = "--with-distro=debian  --disable-stack-protector --disable-nls --disable-gdbm ${AVAHI_GTK} --disable-mono --disable-monodoc --disable-qt3 --disable-qt4 ${AVAHI_PYTHON}"
AVAHI_PYTHON = "--disable-python"
AVAHI_GTK = "--disable-gtk"

LDFLAGS_append_linux-uclibc = " -lintl"
LDFLAGS_append_linux-uclibceabi = " -lintl "
LDFLAGS_append_uclinux-uclibc = " -lintl"

PACKAGES =+ "avahi-daemon avahi-discover libavahi-common libavahi-core libavahi-client avahi-dnsconfd libavahi-glib libavahi-ui avahi-discover-standalone avahi-autoipd avahi-utils"

FILES_libavahi-common = "${libdir}/libavahi-common.so.*"
FILES_libavahi-core = "${libdir}/libavahi-core.so.*"
FILES_avahi-daemon = "${sbindir}/avahi-daemon \
                      ${sysconfdir}/avahi/avahi-daemon.conf \
                      ${sysconfdir}/avahi/hosts \
                      ${sysconfdir}/avahi/services \
                      ${sysconfdir}/dbus-1 \
                      ${sysconfdir}/init.d/avahi-daemon \
                      ${datadir}/avahi/introspection/*.introspect \
                      ${datadir}/avahi/avahi-service.dtd \
                      ${datadir}/avahi/service-types"
FILES_libavahi-client = "${libdir}/libavahi-client.so.*"
FILES_libavahi-ui = "${libdir}/libavahi-ui.so.*"
FILES_avahi-dnsconfd = "${sbindir}/avahi-dnsconfd \
                        ${sysconfdir}/avahi/avahi-dnsconfd.action \
                        ${sysconfdir}/init.d/avahi-dnsconfd"
FILES_libavahi-glib = "${libdir}/libavahi-glib.so.*"
FILES_libavahi-gobject = "${libdir}/libavahi-gobject.so.*"
FILES_avahi-utils = "${bindir}/avahi-*"
FILES_avahi-autoipd = "${sbindir}/avahi-autoipd \
                       ${sysconfdir}/avahi/avahi-autoipd.action \
                       ${sysconfdir}/udhcpc.d/*avahi-autoipd"
FILES_python-avahi = "${PYTHON_SITEPACKAGES_DIR}/avahi/*"
FILES_avahi-discover = "${bindir}/avahi-discover \
                        ${datadir}/applications/avahi-discover.desktop \
                        ${datadir}/avahi/interfaces/avahi-discover.glade"
FILES_avahi-discover-standalone = "${bindir}/avahi-discover-standalone \
                                   ${datadir}/avahi/interfaces/avahi-discover.glade"
CONFFILES_avahi-daemon = "${sysconfdir}/avahi/avahi-daemon.conf"

INITSCRIPT_PACKAGES = "avahi-daemon avahi-dnsconfd"
INITSCRIPT_NAME_avahi-daemon = "avahi-daemon"
INITSCRIPT_PARAMS_avahi-daemon = "defaults 21 19"
INITSCRIPT_NAME_avahi-dnsconfd = "avahi-dnsconfd"
INITSCRIPT_PARAMS_avahi-dnsconfd = "defaults 22 19"

# At the time the postinst runs, dbus might not be setup so only restart if running

pkg_postinst_avahi-daemon () {
	# can't do this offline
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	grep "^avahi:" /etc/group > /dev/null || addgroup avahi
	grep "^avahi:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/run/avahi-daemon --no-create-home avahi --ingroup avahi -g Avahi

	DBUSPID="/var/run/dbus/pid"
	if [ -f $DBUSPID ]; then
		if ps `cat $DBUSPID` > /dev/null; then
			/etc/init.d/dbus-1 force-reload
		fi
	fi
}

pkg_postinst_avahi-autoipd () {
	# can't do this offline
	if [ "x$D" != "x" ]; then
		exit 1
	fi
	grep "^avahi-autoipd:" /etc/group > /dev/null || addgroup avahi-autoipd
	grep "^avahi-autoipd:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/lib/avahi-autoipd --no-create-home avahi-autoipd --ingroup avahi-autoipd -g "Avahi autoip daemon"
}

pkg_postrm_avahi-daemon () {
	deluser avahi || true
	delgroup avahi || true
}

pkg_postrm_avahi-autoipd () {
	deluser avahi-autoipd || true
	delgroup avahi-autoipd || true
}

do_install() {
	autotools_do_install
	install -d ${D}${sysconfdir}/udhcpc.d
	install ${WORKDIR}/00avahi-autoipd ${D}${sysconfdir}/udhcpc.d
	install ${WORKDIR}/99avahi-autoipd ${D}${sysconfdir}/udhcpc.d
}

do_stage() {
	autotools_stage_all
}
