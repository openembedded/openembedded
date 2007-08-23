require mono_1.2.5pre5.inc

#DEPENDS = "mono-native glib-2.0"
# for now, we skip the mono-native build -- just install
# mono using your distro package manager for now
# after we get the target version working, we'll worry
# about the native package for systems that don't have mono
# installed
DEPENDS = "glib-2.0"

PR = "r3"

SRC_URI += "file://configure.patch;patch=1"

do_install_append() {
	install -d ${D}${libdir}/mono/1.0/
	cp ${S}/mcs/class/lib/monolite/* ${D}${libdir}/mono/1.0/
}

PACKAGES =+ "mono-dll"
FILES_mono-dll = "${libdir}/mono/1.0/"


