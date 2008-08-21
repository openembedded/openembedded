SRC_URI += "file://mozilla-firefox.png file://mozilla-firefox.desktop"

PACKAGES =+ "firefox-inspector"

PACKAGES += "firefox-sdk"

FILES_firefox-inspector = "	${libdir}/firefox-${PV}/chrome/inspector* \
				${libdir}/firefox-${PV}/components/*nspector* \
				${libdir}/firefox-${PV}/extensions/inspector* \
				${libdir}/firefox-${PV}/defaults/preferences/inspector* \
				"
FILES_${PN} = "${bindir}/firefox \
               ${datadir}/applications/ \
	       ${datadir}/pixmaps/ \
	       ${libdir}/firefox-${PV}/* \
	       ${libdir}/firefox-${PV}/.autoreg \
	       ${bindir}/defaults"
FILES_${PN}-dev += "${datadir}/idl ${bindir}/firefox-config"
FILES_firefox-sdk += "${libdir}/firefox-devel-${PV}"
FILES_${PN}-dbg += "	${libdir}/firefox-*/.debug \
			${libdir}/firefox-*/*/.debug \
			${libdir}/firefox-*/*/*/.debug \	
			${libdir}/firefox-*/*/*/*/.debug \
			${bindir}/.debug \
			"

do_install() {
	oe_runmake DESTDIR="${D}" destdir="${D}" install
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/mozilla-firefox.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/mozilla-firefox.png ${D}${datadir}/pixmaps/
	rm -f ${D}${libdir}/firefox-*/TestGtkEmbed
}

pkg_postinst_firefox() {
	# work around requirement for root access on first startup
	chmod -R a+w ${libdir}/firefox* ||true 
}

do_stage() {
	autotools_stage_all
}

