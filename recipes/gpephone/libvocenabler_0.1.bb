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

SRC_URI[md5sum] = "536cd97488c0882913c097a833cb2ca2"
SRC_URI[sha256sum] = "748a9a5a1b2e6bf1db4cc767742acf58d836e551e56a493bd34ad759d3bb4f53"
