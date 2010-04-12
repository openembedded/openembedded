# xfce4-panel OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION = "XFCE4 Panel"
SECTION = "x11"
DEPENDS = "startup-notification virtual/libx11 libxfcegui4 libxfce4mcs xfce-mcs-manager libxml2"

inherit pkgconfig xfce

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

PACKAGES += "${PN}-mcs-plugins"
PACKAGES_DYNAMIC = "${PN}-plugin-*"

FILES_${PN}-mcs-plugins += "${libdir}/xfce4/mcs-plugins/"
FILES_${PN}-dbg += "${libdir}/xfce4/mcs-plugins/.debug"

SRC_URI[md5sum] = "8f26b32c442bf9926f98f285a3c251dd"
SRC_URI[sha256sum] = "ddabfb0ccf04366820efdeb7c640ee3a648a55e51b5177c9861a5ab896e96ddd"
