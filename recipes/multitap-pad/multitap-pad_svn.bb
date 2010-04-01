DESCRIPTION = "Multi-tap input method for GTK"
LICENSE = "GPL"
DEPENDS = "libfakekey gtk+ matchbox-panel-2"
RCONFLICTS = matchbox-keyboard-inputmethod
SECTION = "x11"
SRCREV = "373"
PV = "0.0+svnr${SRCPV}"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=${PN};proto=http \
	file://80multitappad"

inherit autotools pkgconfig

S = "${WORKDIR}/${PN}"

FILES_${PN} = "${bindir}/* \
               ${libdir} \
	       ${sysconfdir} \
	       ${datadir}"

FILES_${PN}-dbg += " ${libdir}/gtk-2.0/2.10.0/immodules/.debug \
                     ${libdir}/matchbox-panel/.debug"

FILES_${PN}-dev += " ${libdir}/gtk-2.0/2.10.0/immodules/*.a \
                     ${libdir}/gtk-2.0/2.10.0/immodules/*.la \
		     ${libdir}/matchbox-panel/*.a \
		     ${libdir}/matchbox-panel/*.la"

do_install_append () {
	install -d ${D}/${sysconfdir}/X11/Xsession.d/
	install -m 755 ${WORKDIR}/80multitappad ${D}/${sysconfdir}/X11/Xsession.d/
}

pkg_postinst_multitap-pad () {
if [ "x$D" != "x" ]; then
  exit 1
fi

gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}

pkg_postrm_multitap-pad () {
if [ "x$D" != "x" ]; then
  exit 1
fi

gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}
