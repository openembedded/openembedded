DESCRIPTION = "tuxbox libtuxbox"
DEPENDS = "dreambox-dvbincludes"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"
SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/libtuxbox;method=ext \
           file://acinclude.m4"

SRCDATE = "20040928"
PN = "libtuxbox"
PR = "r1"
S = "${WORKDIR}/libtuxbox"
EXTRA_OECONF = "--with-target=native"

inherit autotools pkgconfig

FILES_libtuxbox_append = " /usr/lib/libtuxbox.so"

FILES_${PN}-dev = "/usr/lib/libtuxbox.la /usr/lib/libtuxbox.a \
	/usr/lib/pkgconfig/tuxbox.pc /usr/include/tuxbox.h"

python populate_packages_prepend () {
	tuxbox_libdir = bb.data.expand('${libdir}', d)
}

do_configure_prepend() {
	install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}

do_stage() {
	install -m 0644 ${S}/tuxbox.h ${STAGING_INCDIR}
	oe_libinstall -so libtuxbox ${STAGING_LIBDIR}
}
