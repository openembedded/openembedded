SECTION = "base"
DESCRIPTION = "Script to manage module configuration files"
LICENSE = "GPLv2"
PACKAGE_ARCH = "all"
INHIBIT_DEFAULT_DEPS = "1"
RDEPENDS_${PN} = "${@base_contains("MACHINE_FEATURES", "kernel26",  "module-init-tools-depmod","modutils-depmod",d)} "
PR = "r10"

SRC_URI = "file://update-modules"

pkg_postinst() {
if [ "x$D" != "x" ]; then
	exit 1
fi
update-modules
}

do_install() {
	install -d ${D}${sbindir}
	install ${WORKDIR}/update-modules ${D}${sbindir}
}

# The SlugOS distro is testing the use of the busybox mod* utilities.
# If that works out, we should create a virtual/update-modules, and
# let the distros select if they want busybox, or some other package
# to provide it.  Until then, the following line just removes the
# unwanted dependencies for SlugOS.
RDEPENDS_${PN}_slugos = ""
