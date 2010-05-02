include nano.inc

PR = "${INC_PR}.0"

SRC_URI += "file://glib.m4"

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glib.m4 m4/
}

SRC_URI[md5sum] = "2be94dc43fb60fff4626a2401a977220"
SRC_URI[sha256sum] = "6d212385680d29dcda35dda7801da19c80182a8bc6bc6d5cf7533034c853d37f"
