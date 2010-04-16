LICENSE = "GPL/LGPL"
DEPENDS = "python-pygtk libwnck"

PR = "r2"

inherit gnome distutils-base

SRC_URI += "file://acinclude.m4"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.ac
}	

FILES_${PN}-dev += "${datadir}/pygtk"

SRC_URI[archive.md5sum] = "08896c63d71ce44d20fafbaf9c0edc78"
SRC_URI[archive.sha256sum] = "c5f74f4c46dbb379d119d6f74ca4a47653af251bea176dc7a0ecacccb88339f0"
