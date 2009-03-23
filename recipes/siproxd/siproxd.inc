DESCRIPTION = "SIP proxy/masquerading daemon"
SECTION = "net"
DEPENDS = "libosip2"
LICENSE = "GPL"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/siproxd/siproxd-${PV}.tar.gz \
	file://siproxd.init \
	"

inherit autotools update-rc.d

INITSCRIPT_NAME = "siproxd"

EXTRA_OECONF = "--disable-doc"

do_configure() {
	gnu-configize
	aclocal
	libtoolize --copy --force
	automake --add-missing
	autoreconf
	oe_runconf
}

do_install_append() {
	cp ${D}/${sysconfdir}/siproxd.conf.example ${D}/${sysconfdir}/siproxd.conf
	sed -ri "s,^#?(pid_file)\ *=\ *.*$,\1 = /var/run/siproxd.pid," ${D}/${sysconfdir}/siproxd.conf
	sed -ri "s,^#?(plugindir)\ *=\ *.*$,\1 = ${libdir}/siproxd/," ${D}/${sysconfdir}/siproxd.conf
	install -d ${D}/${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/siproxd.init ${D}/${sysconfdir}/init.d/siproxd
}

CONFFILES_${PN} = " \
	${sysconfdir}/siproxd.conf \
	${sysconfdir}/siproxd_passwd.cfg \
	"

FILES_${PN} = "${sysconfdir} ${sbindir} ${libdir}/siproxd/*.so.*"
FILES_${PN}-dev += "${libdir}/siproxd/*.so ${libdir}/siproxd/*.a ${libdir}/siproxd/*.la"
