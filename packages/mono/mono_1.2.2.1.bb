require mono.inc
DEPENDS = "mono-native glib-2.0"

PR = "r1"

#We only have a cpu-${arch}.h from arm, so let's mask out non-working architectures
COMPATIBLE_HOST = "arm.*-linux"

do_install_append() {
	install -d ${D}${libdir}/mono/1.0/
	cp ${S}/mcs/class/lib/monolite/* ${D}${libdir}/mono/1.0/
}

PACKAGES =+ "mono-dll"
FILES_mono-dll = "${libdir}/mono/1.0/"


