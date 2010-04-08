LICENSE = "GPLv2"
DEPENDS = "devicekit-power gtk+ gnome-keyring libgnome libgnomeui hal dbus libglade \
           libnotify libwnck cairo libunique gnome-panel gstreamer \
           xrandr policykit-gnome gnome-doc-utils dbus-glib " 

inherit gnome

SRC_URI[archive.md5sum] = "2f47606d16d54915dc49a06364d208da"
SRC_URI[archive.sha256sum] = "8fc2c772f1c0d89b200e405d02656e69a71362771175fbcb6b6db426410db647"

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

