require gstreamer.inc

SRC_URI[archive.md5sum] = "1c7accac718fe211ff91323c27d4ae02"
SRC_URI[archive.sha256sum] = "61613ec7574d22230e8cc893f91b66faec6b21288a22d2f21c9d9eeb7667eb2c"

EXTRA_OECONF += "ac_cv_func_register_printf_function=no"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

