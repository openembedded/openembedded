DEPENDS = "dreambox-dvbincludes tuxbox-libs"
RDEPENDS = "libtuxbox-mpegtools0"
DESCRIPTION = "tuxbox net streaming tools"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/tools/stream;method=ext \
           file://acinclude.m4 \
           file://enable_transform.diff;patch=1;pnum=1 \
	   file://add_configfiles.diff;patch=1;pnum=1"

SRCDATE = "20050802"
S = "${WORKDIR}/stream"
PV = "1.0+${SRCDATE}"
PR = "r1"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native --with-boxtype=${MACHINE}"

CFLAGS_append = " -DHAVE_DREAMBOX_HARDWARE"

do_configure_prepend() {
	install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}

do_install_append() {
	ln -s streampes ${D}/usr/sbin/streames
}
