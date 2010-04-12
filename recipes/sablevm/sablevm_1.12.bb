DESCRIPTION = "A highly-portable Java virtual machine implementing the Java virtual machine specification, second edition."
HOMEPAGE = "http://sablevm.org"
LICENSE = "LGPL"
PRIORITY = "optional"
SECTION = "interpreters"

DEPENDS = "libffi libtool popt \
           sablevm-classpath"
#          unzip"
RRECOMMENDS = "sablevm-classpath (>= ${PV})"

SRC_URI = "${SOURCEFORGE_MIRROR}/sablevm/${PN}-${PV}.tar.gz \
           file://no-internal-libs.patch;patch=1"

inherit autotools update-alternatives

EXTRA_OECONF = "--enable-real-life-brokenness \
                --disable-errors-on-warnings --disable-signals-for-exceptions"

PROVIDES = "virtual/java"
ALTERNATIVE_NAME = "java"
ALTERNATIVE_PATH = "${bindir}/java-sablevm"
ALTERNATIVE_PRIORITY = "350"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc lib${PN} lib${PN}-dev"

FILES_${PN} = "${bindir} \
	       ${libdir}/${PN}/bin"

FILES_lib${PN} = "${libdir}/lib${PN}-*.so"

FILES_lib${PN}-dev = "${includedir}/jni* \
	              ${libdir}/lib${PN}.so \
		      ${libdir}/lib${PN}.la"

do_configure() {
	# remove internal copies of libpopt and libffi
	rm -rf src/libpopt src/libffi

	autotools_do_configure
}

do_install() {
	autotools_do_install

	install -d ${D}${docdir}
	mv ${D}${datadir}/${PN} ${D}${docdir}/

	# symlink only present in the deb...
	install -d ${D}${libdir}/${PN}/bin
	cd ${D}${libdir}/${PN}/bin && ln -sf ../../../bin/java-sablevm java
}

SRC_URI[md5sum] = "6648af9bb5dd3dbbc8cb6835371f5ecd"
SRC_URI[sha256sum] = "576c1af8affdebb0d5e10f8a8edad10e994965cef6db7980a3c52e25e15d6b94"
