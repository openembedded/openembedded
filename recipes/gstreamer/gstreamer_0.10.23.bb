require gstreamer.inc

EXTRA_OECONF += "ac_cv_func_register_printf_function=no"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}


SRC_URI[archive.md5sum] = "f7b2e300d2d85756407ec529424ab237"
SRC_URI[archive.sha256sum] = "cf750821040102d2c9fbfed56472a86fd0d8c24ada37901c41867c88438a776d"
