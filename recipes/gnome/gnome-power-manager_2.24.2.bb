LICENSE = "GPLv2"
DEPENDS = "libnotify libgnomeui gnome-panel gnome-doc-utils libwnck gtk+ gnome-keyring libglade hal dbus-glib " 

inherit gnome

EXTRA_OECONF = " --disable-scrollkeeper \
                 --disable-keyring \
                 --x-includes=${STAGING_INCDIR} \
                 --x-libraries=${STAGING_LIBDIR} \
                 --with-dpms-ext=${STAGING_INCDIR}/.. \
                 --enable-compile-warnings=no \
                 ac_cv_header_X11_extensions_dpms_h=yes \
               "

do_configure_prepend() {
        sed -i -e 's:	man	::g' ${S}/Makefile.am
}

do_configure_append() {
        rm config.log
        # Sigh... --enable-compile-warnings=no doesn't actually turn off -Werror
        for i in $(find ${S} -name "Makefile") ; do
            sed -i -e s:-Werror::g $i
        done
}

PACKAGES =+ "${PN}-applets"

FILES_${PN}-applets = "${bindir}/*applet* \
                       ${libdir}/bonobo/servers \
		       ${datadir}/gnome-2.0/ui"

FILES_${PN} += "${datadir}/icons \
                ${datadir}/dbus-1 \
		${datadir}/gnome/autostart \
		"

FILES_${PN}-doc += "${datadir}/omf \
                    ${datadir}/gnome/help "

