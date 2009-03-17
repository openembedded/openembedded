require gstreamer.inc

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

SRC_URI += "file://po-makefile-fix.patch;patch=1 \
           "
