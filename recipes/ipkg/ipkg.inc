DESCRIPTION = "Itsy Package Manager"
DESCRIPTION_libipkg = "Itsy Package Manager Library"
SECTION = "base"
LICENSE = "GPL"
PROVIDES = "virtual/ipkg libipkg"

PACKAGES =+ "libipkg-dev libipkg"
FILES_libipkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
FILES_libipkg = "${libdir}/*.so.*"
AUTO_LIBNAME_PKGS = "libipkg"

SRC_URI = "${HANDHELDS_CVS};module=familiar/dist/ipkg;tag=${@'V' + bb.data.getVar('PV',d,1).replace('.', '-')} \
        file://update_version_comparision.patch;patch=1 \
        file://enable_debversion.patch;patch=1 \
        file://ipkg-configure \
	file://terse.patch;patch=1"

S = "${WORKDIR}/ipkg/C"

inherit autotools pkgconfig update-rc.d

# Define a variable to allow distros to run configure earlier.
# (for example, to enable loading of ethernet kernel modules before networking starts)
IPKG_INIT_POSITION = "98"
IPKG_INIT_POSITION_slugos = "41"

INITSCRIPT_NAME = "ipkg-configure"
INITSCRIPT_PARAMS = "start ${IPKG_INIT_POSITION} S ."


pkg_postinst_ipkg () {
#!/bin/sh
update-alternatives --install ${bindir}/ipkg ipkg ${bindir}/ipkg-cl 100
}

pkg_postrm_ipkg () {
#!/bin/sh
update-alternatives --remove ipkg ${bindir}/ipkg-cl
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}

do_stage() {
	oe_libinstall -so libipkg ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/replace/
	install -m 0644 replace/replace.h ${STAGING_INCDIR}/replace/
	install -d ${STAGING_INCDIR}/libipkg/
	for f in *.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/libipkg/
	done
}

#
# FIXME: Install /etc/ipkg.conf and /etc/ipkg/arch.conf
#
