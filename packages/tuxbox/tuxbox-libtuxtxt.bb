DESCRIPTION = "tuxbox libtuxtxt"
DEPENDS = "dreambox-dvbincludes"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"
SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/libs;method=ext \
           file://acinclude.m4"

SRC_URI_append_dm7025 = " file://libtuxtxt_bugfix.patch;patch=1"

SRCDATE_dm600pvr = "20061005"
SRCDATE_dm7025 = "20050912"
SRCDATE_dm7020 = "20061005"

PN = "libtuxtxt"
PR = "r1"

PV = "0.0+cvs${SRCDATE}"
S = "${WORKDIR}/libs"
EXTRA_OECONF = "--with-target=native"

inherit autotools pkgconfig

FILES_libtuxtxt_append = " /usr/lib/libtuxtxt.so"

FILES_${PN}-dev = "/usr/lib/libtuxtxt.la /usr/lib/pkgconfig/tuxbox-tuxtxt.pc"

python populate_packages_prepend () {
	tuxbox_libdir = bb.data.expand('${libdir}', d)
}

do_configure_prepend() {
	install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}

do_stage() {
	install -m 0644 ${S}/libtuxtxt/tuxtxt_*.h ${STAGING_INCDIR}
	install -d ${STAGING_INCDIR}/tuxtxt
	install -m 0644 ${S}/libtuxtxt/tuxtxt_*.h ${STAGING_INCDIR}/tuxtxt
	cd libtuxtxt
	oe_libinstall -so libtuxtxt ${STAGING_LIBDIR}
	cd ..
}

do_install_prepend() {
	cd libtuxtxt
}
