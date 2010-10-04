DESCRIPTION = "Itsy Package Manager utilities"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
CONFLICTS = "ipkg-link"
RDEPENDS_${PN} = "python"
SRCDATE = "20050930"
PR = "r28"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "${HANDHELDS_CVS};module=ipkg-utils \
           file://ipkg-utils-fix.patch \
           file://ipkg-py-sane-vercompare.patch \
           file://ipkg-py-tarfile.patch \
           file://arfile_even_alignment.patch \
           file://ipkg-make-index-track-stamps.patch \
           file://fields_tweaks.patch \
           file://ipkg-env.patch \
           file://arfile_header_split.patch \
	   "

S = "${WORKDIR}/ipkg-utils"

INSTALL = "ipkg-build ipkg-deb-unbuild ipkg-unbuild ipkg-compare-versions ipkg-upload ipkg-make-index ipkg-link ipkg.py ipkg-list-fields"

do_compile() {
	oe_runmake ipkg-compare-versions
}

do_install() {
	install -d ${D}${bindir}
	for i in ${INSTALL}
	do
		install -m 0755 $i ${D}${bindir}
	done
}

