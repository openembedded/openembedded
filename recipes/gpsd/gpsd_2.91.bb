require gpsd.inc

SRC_URI += "file://libtool.patch \
            file://cross-compile-on-gentoo.patch "
SRC_URI[gpsd.md5sum] = "c1f97199168c03a431db1a6559b13448"
SRC_URI[gpsd.sha256sum] = "02ee0f0a86a3c74fe807ea0a3fce908cb94dd7ff3afcef0b1fb663a46c1f71d8"

PR = "${INC_PR}.0"

PARALLEL_MAKE = ""

do_install_append() {
	install -d ${D}${base_libdir}/udev/
	install -m 0755 ${S}/gpsd.hotplug.wrapper ${D}${base_libdir}/udev/
}
