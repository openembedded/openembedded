SECTION = "x11/network"
DESCRIPTION = "multi-protocol instant messaging client"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "GPL"

DEPENDS = "gtk+ gnutls virtual/libintl"
RRECOMMENDS_${PN} = "gaim-protocol-irc gaim-protocol-jabber"

PREMIRRORS_prepend () {
	${SOURCEFORGE_MIRROR}   http://unc.dl.sourceforge.net/sourceforge
}
EXTRA_OECONF = "--disable-audio --disable-perl --disable-tcl --disable-deprecated"

FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	    ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	    /bin /sbin /lib/*.so* ${datadir}/${PN} ${libdir}/${PN}/*.so \
	    ${datadir}/pixmaps ${datadir}/applications \
	    ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
	    ${libdir}/bonobo/servers"
FILES_${PN}-dev += "${libdir}/gaim/*.la"

inherit autotools gettext

python populate_packages_prepend () {
	root = bb.data.expand('${libdir}/gaim', d)

        do_split_packages(d, root, '^lib(.*)\.so$',
			   output_pattern='gaim-protocol-%s',
			   description='GAIM protocol plugin for %s',
			   prepend=True,
			   aux_files_pattern=['${datadir}/pixmaps/gaim/status/default/%s.png', '${datadir}/pixmaps/gaim/smileys/default/%s_*'])
}
