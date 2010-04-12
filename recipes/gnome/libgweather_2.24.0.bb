LICENSE = "LGPL"
DEPENDS = "libgnome libsoup-2.4 gtk+"

PR = "r1"

inherit gnome

do_configure_prepend() {
        sed -i -e s:help:: ${S}/Makefile.am
}


PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"

FILES_${PN} =+ "${datadir}/gnome* \
                ${datadir}/icons"

EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2"

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "d006328ec5cebc5dbf3a18834db95bba"
SRC_URI[archive.sha256sum] = "0abae1eef7210e4decab7f89ea5b3a012c06859e91923a7212ca50856bffd500"
