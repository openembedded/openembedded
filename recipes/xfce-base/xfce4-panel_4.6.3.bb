# xfce4-panel OE build file

DESCRIPTION = "Xfce4 Panel"
DEPENDS = "virtual/libx11 startup-notification libxfcegui4 libxml2 exo libwnck"
SECTION = "x11"
PR = "r2"

inherit xfce46

SRC_URI[md5sum] = "0b715abb929220f136483ccd7303ff62"
SRC_URI[sha256sum] = "4f5e19187ddf9f812303b77479124562079d25c6263674040aba4395c6b2e41c"

EXTRA_OECONF += " --enable-startup-notification"

do_install() {
    oe_runmake DESTDIR=${D} install
}

python populate_packages_prepend() {
	plugin_dir = bb.data.expand('${libdir}/xfce4/panel-plugins/', d)
	plugin_name = bb.data.expand('${PN}-plugin-%s', d)
	do_split_packages(d, plugin_dir, '^lib(.*).so$', plugin_name,
	                  '${PN} plugin for %s', extra_depends='', prepend=True,
	                  aux_files_pattern=['${datadir}/xfce4/panel-plugins/%s.desktop',
	                                     '${sysconfdir}/xdg/xfce/panel/%s-*',
	                                     '${datadir}/icons/hicolor/48x48/apps/*-%s.png',
	                                     '${bindir}/*%s*'])
}

PACKAGES_DYNAMIC = "${PN}-plugin-*"
