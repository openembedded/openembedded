LICENSE = "GPL/LGPL"
DEPENDS = "librsvg libwnck totem-pl-parser libgtop gnome-panel gnome-desktop eds-dbus python-pygtk gnome-python libgnomeprint libgnomeprintui"

PR = "r5"

inherit gnome distutils-base

SRC_URI += "file://acinclude.m4"

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g \
	       -e s:'`$PKG_CONFIG --variable=defsdir gnome-python-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g \
	       -e s:'`$PKG_CONFIG --variable=argtypesdir gnome-python-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/argtypes\":g \	
	${S}/configure.ac
}	

FILES_${PN}-dev += "${datadir}/pygtk"

SRC_URI[archive.md5sum] = "d8f8e61d99402e8b0a82d3c8d6e873be"
SRC_URI[archive.sha256sum] = "7ad66f99a1bad1ae0bbb02bd7a7cf8ed17fdc3fd104fa5c68e04961459ad5c50"
