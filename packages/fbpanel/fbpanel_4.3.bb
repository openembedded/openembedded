DESCRIPTION = "A gtk based panel application"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "gtk+ libxmu libxpm"
HOMEPAGE = "http://fbpanel.sourceforge.net/"
SRC_URI = "${SOURCEFORGE_MIRROR}/fbpanel/fbpanel-${PV}.tgz \
           file://makefile.common.patch;patch=1 "

PR = "r1"

LDFLAGS += "-Wl,--export-dynamic"

do_configure () {
	./configure --prefix=/usr --cpu=on
}

do_compile () {
	oe_runmake CHATTY=1
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 fbpanel ${D}${bindir}
	install -d ${D}${datadir}/fbpanel/
	install -d ${D}${datadir}/fbpanel/plugins
	install -m 644 plugins/*.so ${D}${datadir}/fbpanel/plugins
	install -m 644 systray/tray.so ${D}${datadir}/fbpanel/plugins
	install -m 644 config/default ${D}${datadir}/fbpanel/default
	install -d ${D}${datadir}/fbpanel/images
	install -m 644 config/images/* ${D}${datadir}/fbpanel/images
}

