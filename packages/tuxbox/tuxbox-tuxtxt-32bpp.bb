DEPENDS = "freetype dreambox-dvbincludes libtuxtxt"
DESCRIPTION = "tuxbox tuxtxt for 32bit framebuffer"
MAINTAINER = "Sven Karschewski <seddi@i-have-a-dreambox.com>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins/tuxtxt;method=ext \
	   file://makefiles.diff;patch=1;pnum=1 \
	   file://32bpp.diff;patch=1;pnum=1 \
	   file://add_new_default_conf.diff;patch=1;pnum=1 \
	   file://add_e2_plugin.diff;patch=1;pnum=1"

FILES_${PN} = "/usr/bin /usr/share/fonts /usr/lib/enigma2/python/Plugins/Extensions/Tuxtxt /etc/tuxtxt"

SRCDATE = "20060112"
PV = "0.0+cvs${SRCDATE}"
PR = "r2"

S = "${WORKDIR}/tuxtxt"

CFLAGS_append = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"

do_configure_prepend() {
	touch ${S}/python/__init__.py
}
