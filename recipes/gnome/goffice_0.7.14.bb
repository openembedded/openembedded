DESCRIPTION="Gnome Office Library"
LICENSE="GPLv2"

PR = "r2"

DEPENDS="glib-2.0 gtk+ pango cairo libgnomeprint libgsf libglade libpcre libxml2 libart-lgpl"

inherit gnome pkgconfig

SRC_URI += " file://c99math.patch;patch=1 \
             file://nodolt.patch;patch=1 "

do_stage() {
	autotools_stage_all
}

FILES_${PN}-dbg += "${libdir}/goffice/${PV}/plugins/*/.debug"

RRECOMMENDS_${PN} = " \
  goffice-plugin-plot-barcol \
  goffice-plugin-plot-distrib \
  goffice-plugin-plot-pie \
  goffice-plugin-plot-radar \
  goffice-plugin-plot-surface \
  goffice-plugin-plot-xy \
  goffice-plugin-reg-linear \
  goffice-plugin-reg-logfit \
  goffice-plugin-smoothing \
"

FILES_${PN} = "${bindir}/* ${sbindir}/* ${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_bindir}/* ${base_sbindir}/* \
            ${base_libdir}/*${SOLIBS} \
            ${datadir}/${PN} \
            ${datadir}/pixmaps ${datadir}/applications \
            ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
            ${libdir}/bonobo/servers"

PACKAGES_DYNAMIC = "goffice-plugin-*"

python populate_packages_prepend () {
        goffice_libdir = bb.data.expand('${libdir}/goffice/${PV}/plugins/', d)

        do_split_packages(d, goffice_libdir, '(.*)', 'goffice-plugin-%s', 'Goffice plugin for %s', allow_dirs=True)
}

