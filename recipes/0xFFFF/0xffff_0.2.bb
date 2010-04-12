require 0xffff.inc

do_install() {
        install -d ${D}${bindir}
	install -m 755 0xFFFF ${D}${bindir}
}	

SRC_URI[md5sum] = "31cd82986ccfabdf01a6a99aa00f975b"
SRC_URI[sha256sum] = "6d061f8431b76ba1dd09401880c7029e490be8c04cac14ba89db7ea7d0ab77bf"
