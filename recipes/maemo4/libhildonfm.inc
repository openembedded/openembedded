LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon filemanager library"

DEPENDS = "gtk+ libxi libxt libpng gconf dbus libosso libhildon hildon-thumbnail libhildonmime osso-gwconnect mce-dev"

inherit autotools pkgconfig lib_package

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac

	touch gtk-doc.make
}

PARALLEL_MAKE = ""

do_stage() {
	autotools_stage_all
  if [ ! -d ${STAGING_INCDIR}/hildon-widgets ]
  then
    mkdir -p ${STAGING_INCDIR}/hildon-widgets
  fi

	ln -sf ${STAGING_INCDIR}/hildon-fm-2/hildon/* ${STAGING_INCDIR}/hildon-widgets/
}


