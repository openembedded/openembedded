require dropbear.inc
PR = "${INC_PR}.0"

SRC_URI += "file://no-host-lookup.patch"

do_configure_prepend() {
	echo "#define DROPBEAR_SMALL_CODE" >>${S}/options.h
}

DEFAULT_PREFERENCE = "-1"

SRC_URI[md5sum] = "0284ea239083f04c8b874e08e1aca243"
SRC_URI[sha256sum] = "e24d3cbecd3bc850b2b336b8eb50c845a285ceef8e22544938a582e163d36393"
