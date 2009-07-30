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
