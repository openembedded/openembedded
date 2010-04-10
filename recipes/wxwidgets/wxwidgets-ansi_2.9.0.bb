require wxwidgets-${PV}.inc

PR = "${INC_PR}.0"

EXTRA_OECONF += "--disable-unicode"

SRC_URI[md5sum] = "09058928eeb72853142c062bdec056ce"
SRC_URI[sha256sum] = "8cf5c1dcf6357b2d27efd0c737b95baf1d2d1e88b5bf24560824b5eb6f2dc782"
