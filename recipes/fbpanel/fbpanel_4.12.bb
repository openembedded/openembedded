DESCRIPTION = "A gtk based panel application"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "gtk+ libxmu libxpm"
HOMEPAGE = "http://fbpanel.sourceforge.net/"
SRC_URI = "${SOURCEFORGE_MIRROR}/fbpanel/fbpanel-${PV}.tgz"

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

SRC_URI[md5sum] = "12528e7b2936a3548840fe01acaf39f5"
SRC_URI[sha256sum] = "9f665777df5023e3d3c33598a0f5d81d0b79314b75a128c16c07126ef0fc607f"
