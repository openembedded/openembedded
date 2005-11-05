SRC_URI += "file://mozilla-firefox.png file://mozilla-firefox.desktop"
PACKAGES =+ "firefox-inspector"

FILES_firefox-inspector = "${libdir}/firefox-${PV}/chrome/inspector"
FILES_${PN} = "${bindir}/firefox ${datadir}/applications ${datadir}/pixmaps ${libdir}/firefox-${PV} ${bindir}/defaults"
FILES_${PN}-dev += "${datadir}/idl ${bindir}/firefox-config"

do_install() {
	oe_runmake DESTDIR="${D}" destdir="${D}" install
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/mozilla-firefox.desktop ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/mozilla-firefox.png ${D}${datadir}/pixmaps/
	rm -f ${D}${libdir}/firefox-${PV}/TestGtkEmbed
}

pkg_postinst_firefox() {
	# work around requirement for root access on first startup
	chmod -R a+w ${libdir}/firefox*
}
