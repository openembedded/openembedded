DESCRIPTION = "A portable audio library"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PV = "v19-cvs-${CVSDATE}"
PR = "r0"

SRC_URI = "http://www.portaudio.com/archives/pa_snapshot_v19.tar.gz \
	   file://flags.patch;patch=1 \
	   file://no-static-lib.patch;patch=1"
S = "${WORKDIR}/portaudio"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-oss --with-alsa --with-jack=no"

do_stage() {
	oe_libinstall -so -C lib libportaudio ${STAGING_LIBDIR}
        install -m 0644 pa_common/portaudio.h ${STAGING_INCDIR}/portaudio.h
}

do_install() {
	install -d ${D}/${libdir}
	install -d ${D}/${bindir}
	install -d ${D}/${includedir}
	oe_libinstall -so -C lib libportaudio ${D}/${libdir}
	install -m 0644 pa_common/portaudio.h ${D}/${includedir}
	install -m 0755 bin/* ${D}/${bindir}/
}

PACKAGES = "portaudio portaudio-dev portaudio-examples"
FILES_${PN} = "${libdir}"
FILES_portaudio-examples = "${bindir}"
