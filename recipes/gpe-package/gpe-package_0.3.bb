LICENSE = "GPL"
PR = "r3"
inherit gpe pkgconfig

DESCRIPTION = "A package manager GUI for GPE"
DEPENDS = "ipkg libpcre libgpewidget"
RDEPENDS = "gpe-icons gpe-su"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += " file://sbin-and-no-suid-install.patch;patch=1 \
		file://search.patch;patch=1 \
		file://gpe-package"

FILES_${PN} += " /usr/bin/gpe-package"

CFLAGS += "-DENABLE_PCRE"
LDFLAGS += "-lpcre"

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/gpe-package ${D}${bindir}
}

SRC_URI[md5sum] = "229ba1d7755cc3e77d1e711281ae3554"
SRC_URI[sha256sum] = "4226c983948521ead98ea0b02939de6b28bacba6f929b9404b9154ffbfb3718e"
