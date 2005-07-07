DEPENDS = "dreambox-dvbincludes tuxbox-libs"
RDEPENDS = "libtuxbox-mpegtools0"
DESCRIPTION = "tuxbox net streaming tools"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/tools/stream;method=ext \
           file://acinclude.m4 \
           file://disablev3.diff;patch=1;pnum=1 \
	   file://add_configfiles.diff;patch=1;pnum=1"

CVSDATE = "20041028"
S = "${WORKDIR}/stream"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"

do_configure_prepend() {
	install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}

