# xfce4-panel OE build file

DESCRIPTION = "Xfce4 Panel"
DEPENDS = "virtual/libx11 startup-notification libxfcegui4 libxml2 exo libwnck"
SECTION = "x11"
PR = "r2"

inherit xfce46

EXTRA_OECONF += " --enable-startup-notification"

do_stage() {
    autotools_stage_all
}

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

SRC_URI[md5sum] = "73a366b9892152266b465d7d9c35bef4"
SRC_URI[sha256sum] = "b308ddc96fcb27b3f18ed2fa20aeb3a12fb73cec7676d75914a58d1b27124b83"
