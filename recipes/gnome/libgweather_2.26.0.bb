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

do_configure_prepend() {
	sed -i -e 's: doc : :g' ${S}/Makefile.am
}

EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2"

# A hundred meg of xml files is a bit much...
PACKAGES =+ "${PN}-locationdata"
FILES_${PN}-locationdata = "${datadir}/libgweather/Locations*"

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "b96016d7b35c66cf251189e9851ee252"
SRC_URI[archive.sha256sum] = "c1efdeb59fe87145d13d99b7bb6f51b56505081fb2ebc2f7fe7dc3f7699da45e"
