require mono_1.2.5.inc

DEPENDS = "mono-native glib-2.0"

PR = "r1"

SRC_URI += "file://configure.patch;patch=1"

do_install_append() {
	install -d ${D}${libdir}/mono/1.0/
	cp ${S}/mcs/class/lib/monolite/* ${D}${libdir}/mono/1.0/
}

EXTRA_OECONF += " --disable-mcs-build "

PACKAGES =+ "mono-dll"
FILES_mono-dll = "${libdir}/mono/1.0/"


