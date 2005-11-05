LICENSE =	"LGPL"
DESCRIPTION =	"Window navigation construction toolkit"
HOMEPAGE =	""

inherit gnome

do_stage() {        
	autotools_stage_includes        
	install -d ${STAGING_LIBDIR}        
	install -m 755 libwnck/.libs/libwnck-1.so.4.9.0 ${STAGING_LIBDIR}/libwnck-1.so
}
