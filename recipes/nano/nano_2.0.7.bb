include nano.inc

PR = "${INC_PR}.0"

SRC_URI += "file://glib.m4"

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glib.m4 m4/
}

SRC_URI[md5sum] = "16187fed2bdefec6275ece6401ce4cd2"
SRC_URI[sha256sum] = "5dc783c412c4d1ff463c450d2a2f9e1ea53a43d9ba1dda92bbf5182f60db532f"
