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

SRC_URI[archive.md5sum] = "fbcf4ef5ec4a8c4eec4d390c5889c80f"
SRC_URI[archive.sha256sum] = "400a5401a591e271c3357d0a8cb05a7927b4c218130497d06f75df9763d4efd8"
