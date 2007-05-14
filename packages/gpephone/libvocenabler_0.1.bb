LICENSE     = "LiPS"
DESCRIPTION = "LiPS voice call  library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib linphone"
PR          = "r0"

GPE_TARBALL_SUFFIX = "gz"

inherit gpephone pkgconfig autotools

do_compile_prepend() {
	for i in `find . -name "Makefile"` ; do
		sed -i -e s:I/usr/include:I${STAGING_INCDIR}:g $i
	done	
}

do_stage () {
	autotools_stage_all
}
