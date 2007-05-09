require 0xffff.inc

do_install() {
        install -d ${D}${bindir}
	install -m 755 0xFFFF ${D}${bindir}
}	
