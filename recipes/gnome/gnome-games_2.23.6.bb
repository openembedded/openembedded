LICENSE = "GPL"
DEPENDS = "libggz ggz-client-libs python-pygtk gtk+ libgnome libgnomeui librsvg gnome-vfs gconf libglade gnome-common gnome-python-desktop"

PR = "r2"

inherit gnome distutils-base gconf

EXTRA_OECONF = "--with-libggz-includes=${STAGING_INCDIR} \
                --with-libggz-libraries=${STAGING_LIBDIR} \
                --with-ggzmod-includes=${STAGING_INCDIR} \
		--with-ggzmod-libraries=${STAGING_LIBDIR} \
	        --enable-scalable \
		--enable-omitgames=aisleriot \
	       "

do_configure_prepend() {
	for i in $(find ${S} -name "Makefile.am") ; do
		sed -i -e s:help::g $i
	done
}

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:'-I /usr/include -I /usr/local/include'::g $i
	done	
}

FILES_${PN}-doc += " ${datadir}/gnome/help"
FILES_${PN}-dbg += " ${bindir}/.debug ${libdir}/gnome-games/.debug"

FILES_${PN} += "/var/games \
                ${datadir}/applications \
                ${datadir}/g* \
		${datadir}/ggz \
		${datadir}/icons \
		${datadir}/pixmaps \
		${sysconfdir}"

PACKAGES =+ "gnome-games-gnometris "
FILES_gnome-games-gnometris = "${bindir}/gnometris ${datadir}/pixmaps/gnometris ${datadir}/pixmaps/gnome-gtetris.png ${datadir}/applications/gnometris.desktop ${sysconfdir}/gconf/schemas/gnometris.schemas"

PACKAGES =+ "gnome-games-gnomine"
FILES_gnome-games-gnomine = "${bindir}/gnomine ${datadir}/pixmaps/gnomine ${datadir}/pixmaps/gnome-gnomine.png ${datadir}/applications/gnomine.desktop ${sysconfdir}/gconf/schemas/gnomine.schemas"

