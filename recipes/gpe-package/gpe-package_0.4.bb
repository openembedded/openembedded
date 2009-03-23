LICENSE = "GPL"
PR = "r0"
inherit gpe pkgconfig

DESCRIPTION = "A package manager GUI for GPE"
DEPENDS = "ipkg libpcre libgpewidget"
RDEPENDS = "gpe-icons gpe-su"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += " file://sbin-and-no-suid-install.patch;patch=1 \
		file://gpe-package"

FILES_${PN} += " /usr/bin/gpe-package"

CFLAGS += "-DENABLE_PCRE"
LDFLAGS += "-lpcre"

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/gpe-package ${D}${bindir}
}
