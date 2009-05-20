require gstreamer.inc

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

