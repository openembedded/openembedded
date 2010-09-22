require gstreamer.inc

SRC_URI[archive.md5sum] = "de01f73f71d97c5854badd363ca06509"
SRC_URI[archive.sha256sum] = "e8ef301be423797ff36a0bb3615930b112b4175634051d19fd655e0ed974532a"

EXTRA_OECONF += "ac_cv_func_register_printf_function=no"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

