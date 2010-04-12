require 0xffff.inc

do_install() {
        install -d ${D}${bindir}
	install -m 755 0xFFFF ${D}${bindir}
}	

SRC_URI[md5sum] = "666fce75c418d7b72e2c9dc225fce3be"
SRC_URI[sha256sum] = "2419708f8e0d7cd6875f4555da9c8a2bf9503374eb7c0bea08fed0841baa4655"
