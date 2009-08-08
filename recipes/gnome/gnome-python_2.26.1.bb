DESCRIPTION = "GNOME Python miscellaneous bindings"
LICENSE = "LGPL"
DEPENDS = "libgnomeui pyorbit python-pygtk"
RDEPENDS = "pyorbit"

inherit gnome distutils-base pkgconfig

do_configure() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.ac
	export HOST_SYS=${HOST_SYS}
	export BUILD_SYS=${BUILD_SYS}
	autotools_do_configure
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${datadir}"
FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"


