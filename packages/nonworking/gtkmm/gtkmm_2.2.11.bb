DESCRIPTION = "C++ Bindings for Gtk+"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "gtk+ libsigc++"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/gtkmm/2.2/gtkmm-2.2.11.tar.bz2"

inherit autotools

do_stage() {
	oe_soinstall shlib/libhistory.so.${PV} ${STAGING_LIBDIR}/
	oe_soinstall shlib/libreadline.so.${PV} ${STAGING_LIBDIR}/

	install -d ${STAGING_INCDIR}/readline
	for f in readline.h chardefs.h keymaps.h history.h tilde.h rlstdc.h \
	  rlconf.h rltypedefs.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/readline/
	done

}
