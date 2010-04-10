DESCRIPTION = "GNOME Python miscellaneous bindings"
LICENSE = "LGPL"
DEPENDS = "libgnomeui pyorbit python-pygtk"
RDEPENDS = "pyorbit"

PR = "r1"

inherit gnome distutils-base pkgconfig


do_configure_prepend() {
    export HOST_SYS=${HOST_SYS}
    export BUILD_SYS=${BUILD_SYS}
    sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g  \
           -e s:'`$PKG_CONFIG --variable=defsdir gnome-python-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g \
           -e s:'`$PKG_CONFIG --variable=argtypesdir gnome-python-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/argtypes/\":g \
           ${S}/configure.ac
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${datadir}"
FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"



SRC_URI[archive.md5sum] = "e5dcae40b2c291126843680dbed924a8"
SRC_URI[archive.sha256sum] = "ede0203f1eec22b3ed4a91c7b769e437859e5bc4b89a8f8e80b3f7ca62317098"
