require ${PN}.inc

PR = "${INC_PR}.0"

SRC_URI += " \
	file://0001-configure.ac-remove-Werror-from-CFLAGS.patch \
"

SRC_URI[md5sum] = "323049db668ab260870fd7ecd2ec4156"
SRC_URI[sha256sum] = "75cf8d3b5cac2764420ae2cc7846b9bb12a47d2ca04c96e5821309b0124ddc72"
