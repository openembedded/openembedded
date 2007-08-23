SECTION = "x11/network"
DESCRIPTION = "multi-protocol instant messaging client"
LICENSE = "GPL"

DEPENDS = "avahi gtk+ ncurses gnutls virtual/libintl gstreamer dbus"
RRECOMMENDS_${PN} = "libpurple-plugin-ssl-gnutls libpurple-protocol-irc libpurple-protocol-xmpp"

EXTRA_OECONF = " \
                --disable-audio \
		--disable-perl \
		--disable-tcl \
		--disable-deprecated \
		--disable-gevolution \
		--x-includes=${STAGING_INCDIR} \
		--x-libraries=${STAGING_LIBDIR} \
		--enable-gnutls=yes \
		--with-ncurses-headers=${STAGING_INCDIR} \
		--with-gnutls-includes=${STAGING_INCDIR} \
		--with-gnutls-libs=${STAGING_LIBDIR} \
		"

OE_LT_RPATH_ALLOW=":${libdir}/purple-2:"
OE_LT_RPATH_ALLOW[export]="1"

PACKAGES =+ "libpurple libpurple-dev libpurple-dbg libpurple-liboscar libpurple-libjabber libpurple-logreader finch finch-dev finch-dbg"


LEAD_SONAME = "libpurple.so.0"
FILES_libpurple     = "${libdir}/libpurple*.so.* /usr/bin/purple-* /etc/gconf/schemas/purple*"
FILES_libpurple-dev = "${libdir}/libpurple* \
                       ${libdir}/purple-2/*.la " 
FILES_libpurple-dbg = "${libdir}/.debug/libpurple* \
                       ${libdir}/purple-2/.debug"
FILES_libpurple-liboscar = "${libdir}/purple-2/liboscar.so.*"
FILES_libpurple-libjabber = "${libdir}/purple-2/libjabber.so.*"
FILES_libpurple-logreader = "${libdir}/purple-2/log_reader.so"
FILES_finch         = "${bindir}/finch /usr/lib/libgnt.so.*" 
FILES_finch-dev     = "${libdir}/finch/*.la" 
FILES_finch-dbg     = "${bindir}/.debug/finch \
                       ${libdir}/finch/.debug"

FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	    ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	    /bin /sbin /lib/*.so* ${datadir}/${PN} ${libdir}/${PN}/*.so \
	    ${datadir}/pixmaps ${datadir}/applications \
	    ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
	    ${libdir}/bonobo/servers ${datadir}/icons"
FILES_${PN}-dev += "${libdir}/pidgin/*.la"

inherit autotools gettext pkgconfig gconf

PACKAGES_DYNAMIC = "libpurple-protocol-* libpurple-plugin-* pidgin-plugin-* finch-plugin-*"

python populate_packages_prepend () {
	root   = bb.data.expand('${libdir}/pidgin', d)
        purple = bb.data.expand('${libdir}/purple-2', d)
        finch  = bb.data.expand('${libdir}/finch', d)

	do_split_packages(d, root, '^([^l][^i][^b].*)\.so$',
			   output_pattern='pidgin-plugin-%s',
			   description='Pidgin plugin %s',
			   prepend=True, extra_depends='')

        do_split_packages(d, purple, '^lib(.*)\.so$',
			   output_pattern='libpurple-protocol-%s',
			   description='Libpurple protocol plugin for %s',
			   prepend=True, extra_depends='')

	do_split_packages(d, purple, '^(ssl-.*)\.so$',
                           output_pattern='libpurple-plugin-%s',
                           description='libpurple plugin %s',
                           prepend=True, extra_depends='libpurple-plugin-ssl')

        do_split_packages(d, purple, '^([^l][^i][^b].*)\.so$',
                           output_pattern='libpurple-plugin-%s',
                           description='libpurple plugin %s',
                           prepend=True, extra_depends='')

        do_split_packages(d, finch, '^([^l][^i][^b].*)\.so$', 
                           output_pattern='finch-plugin-%s',
                           description='Finch plugin %s',
                           prepend=True, extra_depends='')


}
