# xfce4-panel OE build file

DESCRIPTION = "Xfce4 Panel"
DEPENDS = "virtual/libx11 startup-notification libxfcegui4 libxml2 exo libwnck"
SECTION = "x11"
PR = "r0"

inherit xfce46

SRC_URI[md5sum] = "82f10a42aefca4cc26a6633e7478cc65"
SRC_URI[sha256sum] = "cc9b70bdc73ab80f46655a34cdbaf876a67cd90b50230cbf4d77a3106a5c54e7"

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
