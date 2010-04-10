require gstreamer.inc

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}


SRC_URI[archive.md5sum] = "35dd8598837af4074753afe5b59e8ef2"
SRC_URI[archive.sha256sum] = "61489e0192b1362e6dc760154204c73c1edd9ad9d8c754535483ec00ad7e389e"
