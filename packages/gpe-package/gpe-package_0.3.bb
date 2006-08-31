LICENSE = "GPL"
PR = "r3"
inherit gpe pkgconfig

DESCRIPTION = "A package manager GUI for GPE"
DEPENDS = "ipkg pcre libgpewidget gpe-su"
RDEPENDS = "gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += " file://sbin-and-no-suid-install.patch;patch=1 \
		file://search.patch;patch=1 \
		file://gpe-package"

FILES_${PN} += " /usr/bin/gpe-package"

CFLAGS += "-DENABLE_PCRE"
LDFLAGS += "-lpcre"

do_install_append() {
	install -d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/gpe-package ${D}/usr/bin
}
