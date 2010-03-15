LICENSE = "GPL"
SECTION = "console/utils"
PRIORITY = "required"
DESCRIPTION = "gzip (GNU zip) is a compression utility designed \
to be a replacement for 'compress'. The GNU Project uses it as \
the standard compression program for its system."
PR = "r1"

SRC_URI = "${GNU_MIRROR}/gzip/gzip-${PV}.tar.gz;name=src \
	   file://configure.patch;patch=1"
SRC_URI[src.md5sum] = "c54a31b93e865f6a4410b2dc64662706"
SRC_URI[src.sha256sum] = "1d06ff9f5c523651bed3dcde6e6aa8118eee48b22534a157a2588705fa517ca3"

S = "${WORKDIR}/gzip-${PV}"

inherit autotools

do_install () {
	autotools_do_install
	# Rename and move files into /bin (FHS)
	install -d ${D}${base_bindir}
	mv ${D}${bindir}/gunzip ${D}${base_bindir}/gunzip.${PN}
	mv ${D}${bindir}/gzip ${D}${base_bindir}/gzip.${PN}
	mv ${D}${bindir}/zcat ${D}${base_bindir}/zcat.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_bindir}/gunzip gunzip gunzip.${PN} 100
	update-alternatives --install ${base_bindir}/gzip gzip gzip.${PN} 100
	update-alternatives --install ${base_bindir}/zcat zcat zcat.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove gunzip gunzip.${PN}
	update-alternatives --remove gzip gzip.${PN}
	update-alternatives --remove zcat zcat.${PN}
}

