DESCRIPTION = "Emotion is an Evas smart-object library providing video capabilities. \
Emotion leverages libxine 1.0 and integrates seemlessly with the rest of the EFL. \
Because its based on libxine, any format that it supports (Theora, DiVX, MPEG2, etc) \
is avalible using Emotion."
SECTION = "libs"
DEPENDS = "libxine edb eet evas ecore embryo edje"
PV = "${CVSDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/emotion"
S = "${WORKDIR}/emotion"

inherit autotools binconfig

do_stage () {
	oe_libinstall -C src libemotion ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/Emotion.h ${STAGING_INCDIR}/
}

PACKAGES += "emotion-examples"

FILES_${PN} = "${libdir}/libemotion*.so*"
FILES_${PN}-dev += "${bindir}/emotion-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/emotion* ${datadir}"

