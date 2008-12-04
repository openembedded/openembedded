DEPENDS = "freetype"
DESCRIPTION = "TuxCom for dreambox 8000/32bit framebuffer"
MAINTAINER = "Sven Karschewski <seddi@i-have-a-dreambox.com>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins/tuxcom;method=ext \
	file://makefiles.diff;patch=1;pnum=1 \
	file://add_font.diff;patch=1;pnum=1 \
	file://32bpp.diff;patch=1;pnum=1 \
	file://add_e2_plugin.diff;patch=1;pnum=1 \
	file://add_advanced_rc.diff;patch=1;pnum=1"

SRCDATE = "20060123"
PV = "0.0+cvs${SRCDATE}"
PR = "r0"

PACKAGES = "${PN}-dbg ${PN}"

S = "${WORKDIR}/tuxcom"

CFLAGS_append = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"

do_configure_prepend() {
	touch ${S}/python/__init__.py
}

do_install() {
	install -d ${D}/etc/tuxcom
	install -d ${D}/usr/plugins
	install -d ${D}/usr/share/fonts
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/Tuxcom
	
	install -m 0755 ${S}/tuxcom ${D}/usr/plugins/tuxcom
	install -m 0644 ${S}/tuxcom.cfg ${D}/etc/tuxcom/tuxcom.cfg
	install -m 0644 ${S}/font/pakenham.ttf ${D}/usr/share/fonts/pakenham.ttf
	install -m 0644 ${S}/python/__init__.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/Tuxcom/__init__.py
	install -m 0644 ${S}/python/plugin.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/Tuxcom/plugin.py
}

FILES_${PN}-dbg ="/usr/plugins/.debug"
FILES_${PN} = "/etc/tuxcom/tuxcom.cfg /usr/plugins/tuxcom /usr/share/fonts/pakenham.ttf /usr/lib/enigma2/python/Plugins/Extensions/Tuxcom/__init__.py \
		/usr/lib/enigma2/python/Plugins/Extensions/Tuxcom/plugin.py"
