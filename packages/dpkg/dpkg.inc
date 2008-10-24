DESCRIPTION = "Package maintenance system for Debian."
LICENSE = "GPL"
SECTION = "base"

SRC_URI = "${DEBIAN_MIRROR}/main/d/dpkg/dpkg_${PV}.tar.gz \
           file://ignore_extra_fields.patch;patch=1 \
           file://noupdalt.patch;patch=1"

S = "${WORKDIR}/dpkg-${PV}"

DEPENDS_${PN} += "update-alternatives"

RDEPENDS += "perl perl-module-base perl-module-carp perl-module-cwd perl-module-english perl-module-exporter perl-module-exporter-heavy perl-module-fcntl perl-module-file-spec-unix perl-module-file-temp perl-module-io perl-module-io-handle perl-module-posix perl-module-strict perl-module-vars perl-module-warnings perl-module-warnings-register perl-module-autoloader perl-module-config perl-module-constant perl-module-errno perl-module-file-basename perl-module-file-path perl-module-file-spec perl-module-overload perl-module-selectsaver perl-module-symbol perl-module-xsloader"

PARALLEL_MAKE = ""

inherit autotools gettext

DPKG_INIT_POSITION = "98"
DPKG_INIT_POSITION_slugos = "41"

pkg_postinst_dpkg () {
#!/bin/sh
if [ "x$D" != "x" ]; then
	install -d ${IMAGE_ROOTFS}/${sysconfdir}/rcS.d
	# this happens at S98 where our good 'ole packages script used to run
	printf "#!/bin/sh
	dpkg --configure -a
	rm -f /${sysconfdir}/rcS.d/S${DPKG_INIT_POSITION}configure
\n" > ${IMAGE_ROOTFS}/${sysconfdir}/rcS.d/S${DPKG_INIT_POSITION}configure
	chmod 0755 ${IMAGE_ROOTFS}/${sysconfdir}/rcS.d/S${DPKG_INIT_POSITION}configure
fi
}

do_configure () {
    echo >> m4/compiler.m4
    autotools_do_configure
}
