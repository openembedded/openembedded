DESCRIPTION="Gnome Office Library"
LICENSE="GPLv2"
PR ="r0"

DEPENDS="glib-2.0 gtk+ pango cairo libgnomeprint libgsf libglade libpcre libxml2 libart-lgpl"

FILES_${PN}-dbg += "${libdir}/goffice/${PV}/plugins/*/.debug"

inherit gnome pkgconfig

do_stage() {
	autotools_stage_all
}

PACKAGES_DYNAMIC = "goffice-plugin-*"

python populate_packages_prepend () {
        goffice_libdir = bb.data.expand('${libdir}/goffice/${PV}/plugins', d)

        do_split_packages(d, goffice_libdir, '(.*)', 'goffice-plugin-%s', 'Goffice plugin for %s', allow_dirs=True)
}

