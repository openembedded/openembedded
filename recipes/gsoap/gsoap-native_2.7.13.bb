require gsoap_${PV}.inc

DEPENDS = ""

SRC_URI += "file://use-just-built-binary-2.7.13.patch;patch=1"

inherit native

do_install() {
	:
}

