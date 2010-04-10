LICENSE = "LGPL"
DEPENDS = "libgnome libsoup-2.4 gtk+"

PR = "r1"

inherit gnome

EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2"

do_configure_prepend() {
        sed -i -e 's:help::'    ${S}/Makefile.am
	sed -i -e 's: doc : :g' ${S}/Makefile.am
}

do_stage() {
        autotools_stage_all
}

FILES_${PN} += "${datadir}/gnome* \
                ${datadir}/icons"

PACKAGES =+ "${PN}-locationdata"
FILES_${PN}-locationdata = "${datadir}/libgweather/Locations*"

PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"



SRC_URI[archive.md5sum] = "cef0447b62235c4662aa9691dd9a6c92"
SRC_URI[archive.sha256sum] = "70cf977060a5e71ade98346070856f09fbf33f6d88f4d49632d7ae0f6b314834"
