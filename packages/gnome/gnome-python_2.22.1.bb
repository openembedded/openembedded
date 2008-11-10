DESCRIPTION = "GNOME Python miscellaneous bindings"
LICENSE = "LGPL"
DEPENDS = "libgnomeui pyorbit python-pygtk"
RDEPENDS = "pyorbit"

PR = "r1"

inherit gnome distutils-base pkgconfig

FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"

do_configure() {
    sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.ac
	export HOST_SYS=${HOST_SYS}
	export BUILD_SYS=${BUILD_SYS}
	autotools_do_configure
}

do_stage() {
	autotools_stage_all
}
