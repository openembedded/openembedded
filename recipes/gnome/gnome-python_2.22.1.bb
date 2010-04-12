DESCRIPTION = "GNOME Python miscellaneous bindings"
LICENSE = "LGPL"
DEPENDS = "libgnomeui pyorbit python-pygtk"
RDEPENDS = "pyorbit"

PR = "r2"

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

SRC_URI[archive.md5sum] = "02054115dc86617da2a80eb87a1f988b"
SRC_URI[archive.sha256sum] = "559b5d857b4fbc31418bc677f3391182ba1c357cabb8dfee04a1e709a7a63d01"
