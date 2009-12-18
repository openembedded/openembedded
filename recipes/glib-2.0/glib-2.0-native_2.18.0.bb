require glib-2.0_${PV}.bb

DEPENDS = "gettext-native gtk-doc-native"
EXTRA_OECONF = ""
PR = "r4"

inherit native

do_configure_prepend() {
    if [ -e ${S}/${TARGET_SYS}-libtool ] ; then
		echo "${TARGET_SYS}-libtool already present"
    else
        cp ${STAGING_BINDIR}/${TARGET_SYS}-libtool ${S}
    fi

}

do_stage () {
	install -m 0755 gobject/glib-mkenums ${STAGING_BINDIR}/
	install -m 0755 gobject/.libs/glib-genmarshal ${STAGING_BINDIR}/
	install -m 0755 glib-gettextize ${STAGING_BINDIR}/
	oe_libinstall -so -C glib libglib-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gmodule libgmodule-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gthread libgthread-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gobject libgobject-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gio libgio-2.0 ${STAGING_LIBDIR}
	autotools_stage_includes
	install -d ${STAGING_INCDIR}/glib-2.0/glib
	install -m 0755 ${S}/glibconfig.h ${STAGING_INCDIR}/glib-2.0/glibconfig.h
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 ${S}/m4macros/glib-2.0.m4 ${STAGING_DATADIR}/aclocal/glib-2.0.m4
	install -m 0644 ${S}/m4macros/glib-gettext.m4 ${STAGING_DATADIR}/aclocal/glib-gettext.m4
	install -d ${STAGING_DATADIR}/glib-2.0/gettext/po
	install -m 0755 mkinstalldirs ${STAGING_DATADIR}/glib-2.0/gettext/
	install -m 0644 po/Makefile.in.in ${STAGING_DATADIR}/glib-2.0/gettext/po/
}

do_install () {
	:
}
