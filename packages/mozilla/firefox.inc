DESCRIPTION ? = "Browser made by mozilla"
SRC_URI += "file://mozilla-${PN}.png file://mozilla-${PN}.desktop"

PARALLEL_MAKE = ""

MOZPV ?= "${PV}"

PACKAGES =+ "${PN}-inspector"

PACKAGES += "${PN}-sdk"

FILES_${PN}-inspector = "	${libdir}/${PN}-${MOZPV}/chrome/inspector* \
				${libdir}/${PN}-${MOZPV}/components/*nspector* \
				${libdir}/${PN}-${MOZPV}/extensions/inspector* \
				${libdir}/${PN}-${MOZPV}/defaults/preferences/inspector* \
				"
FILES_${PN} = "${bindir}/${PN} \
               ${datadir}/applications/ \
	       ${datadir}/pixmaps/ \
	       ${libdir}/${PN}-${MOZPV}/* \
	       ${libdir}/${PN}-${MOZPV}/.autoreg \
	       ${bindir}/defaults"
FILES_${PN}-dev += "${datadir}/idl ${bindir}/${PN}-config"
FILES_${PN}-sdk += "${libdir}/${PN}-devel-${MOZPV}"
FILES_${PN}-dbg += "	${libdir}/${PN}-*/.debug \
			${libdir}/${PN}-*/*/.debug \
			${libdir}/${PN}-*/*/*/.debug \	
			${libdir}/${PN}-*/*/*/*/.debug \
			${bindir}/.debug \
			"

do_install() {
	oe_runmake DESTDIR="${D}" destdir="${D}" install
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/mozilla-${PN}.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/mozilla-${PN}.png ${D}${datadir}/pixmaps/
	rm -f ${D}${libdir}/${PN}-*/TestGtkEmbed
}

pkg_postinst_${PN}() {
	# work around requirement for root access on first startup
	chmod -R a+w ${libdir}/${PN}* ||true 
}

do_stage() {
	autotools_stage_all
}

