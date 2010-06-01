require gstreamer.inc

SRC_URI[archive.md5sum] = "c92d6bce4fc65fa9d5a3ad35cdd1a466"
SRC_URI[archive.sha256sum] = "e44a737c016ccab56d646718ecf24b9393babde2c417ac7dd5bd218e5c609ef9"

EXTRA_OECONF += "ac_cv_func_register_printf_function=no"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

