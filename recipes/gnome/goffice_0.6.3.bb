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


SRC_URI[archive.md5sum] = "3d8d3357f9d58af901cd1d6eb42e2973"
SRC_URI[archive.sha256sum] = "a252aff88d801175b27fd7c20e00b0b5f674a5a70e64cd95091abdcab87db35c"
