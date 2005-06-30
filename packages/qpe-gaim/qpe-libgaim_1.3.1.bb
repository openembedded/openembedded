DESCRIPTION = "A multi protocol instant messager library, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "glib-2.0 gnutls"
RDEPENDS = "libgaim-plugins"
LICENSE = "GPL"
HOMEPAGE = "http://gaim.sourceforge.net/"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/gaim/gaim-${PV}.tar.bz2 \
	   file://dont-look-for-gtk.patch;patch=1        \
	   file://libgaim.patch;patch=1 "

S = "${WORKDIR}/gaim-${PV}"

inherit autotools

EXTRA_OE_CONF = "--disable-audio --disable-gtkspell --disable-perl \
		 --disable-screensaver --disable-sm --disable-glibtest \
		 --disable-gtktest --disable-startup-notification \
		 --disable-gevolution --disable-aotest --disable-audiofiletest \
		 --disable-x --without-x --without-gtk --disable-gtk \
		 --enable-gnutls=y"

CFLAGS_append = " -I${STAGING_INCDIR}/glib-2.0"

do_stage() {
	oe_libinstall -so -C src libgaim ${QTDIR}/lib

	# install headers
	GAIM_DIR=${STAGING_INCDIR}/gaim
	install -d $GAIM_DIR

	for header in account.h accountopt.h away.h blist.h buddyicon.h cmds.h config.h connection.h conversation.h core.h debug.h eventloop.h ft.h gaim.h imgstore.h log.h md5.h network.h notify.h plugin.h pluginpref.h pounce.h prefix.h prefs.h privacy.h proxy.h prpl.h request.h roomlist.h server.h sha.h signals.h sound.h sslconn.h status.h stringref.h util.h value.h version.h xmlnode.h
	do
		if [ -e ${S}/src/$header ]; then
			install -m 0644 ${S}/src/$header $GAIM_DIR	
		fi
		if [ -e ${S}/$header ]; then
			install -m 0644 ${S}/$header $GAIM_DIR
		fi
	done
}

#FIXME: use do_packages to create individual packages for each of the plugins
python populate_packages_prepend () {
	plugindir = bb.data.expand('${libdir}/gaim', d)
	do_split_packages(d, plugindir, '^lib(.*)\.so$', 'libgaim-protocol-%s', 'GAIM plugin for %s protocol', extra_depends='' )
}

PACKAGES += "libgaim-plugins"
FILES_libgaim-plugins = "${libdir}/gaim/autorecon.so ${libdir}/gaim/s*.so"

