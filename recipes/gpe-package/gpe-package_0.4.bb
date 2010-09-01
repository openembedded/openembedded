DESCRIPTION = "A package manager GUI for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPLv2+"

DEPENDS = "libipkg libpcre libgpewidget"

PR = "r3"

inherit gpe pkgconfig

SRC_URI += " file://sbin-and-no-suid-install.patch \
                file://gpe-package"
SRC_URI[md5sum] = "f131eed187483620916b7e624b9e3367"
SRC_URI[sha256sum] = "a1fbdb1e8357b0b2362df9ee457c90dcaafbe7a11723117cb0cbee1ea0f6315c"

CFLAGS += "-DENABLE_PCRE"
LDFLAGS += "-lpcre"

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/gpe-package ${D}${bindir}
}

RDEPENDS_${PN} = "gpe-icons gpe-su"
FILES_${PN} += " /usr/bin/gpe-package"
