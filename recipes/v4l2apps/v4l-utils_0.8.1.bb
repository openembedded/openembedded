DESCRIPTION = "v4l2 and IR applications"
LICENSE = "GPLv2/LGPLv2.1"

# libv4l was absorbed into this, let OE know that
PROVIDES = "libv4l"

SRC_URI = "git://linuxtv.org/v4l-utils.git;protocol=git"
SRCREV = "${P}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "PREFIX=${prefix} DESTDIR=${D}"

do_install() {
	oe_runmake install
}

PACKAGES =+ "libv4l libv4l-dbg libv4l-dev"

FILES_${PN} = "${bindir} ${sbindir}"
FILES_libv4l += "${libdir}/libv4l/* ${libdir}/*.so.*"
FILES_libv4l-dbg += "${libdir}/libv4l/.debug"
FILES_libv4l-dev += "${libdir}/*.so ${includedir}/lib* ${libdir}/pkgconfig/lib*"

