LICENSE = "GPL"

DEPENDS = "klibc"
RDEPENDS_${PN} = "kexec-klibc-static"

inherit autotools

# You can create your own *-img.h by doing
# ./make-image-header.sh <file>.png HAND

SRC_URI += "file://logo-img.h \
	    file://logo.png \
	    "

export CC=${TARGET_PREFIX}klcc

# standard oe cflags don't work with klcc
export CFLAGS = ""
export CPPFLAGS = ""
export LDFLAGS = ""

do_configure_prepend () {
    install -m 0644 ${WORKDIR}/logo-img.h ${S}/res/
    install -m 0644 ${WORKDIR}/logo.png ${S}/res/
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 kexecboot ${D}${bindir}/

	install -d ${D}/proc
	install -d ${D}/mnt
}

FILES_${PN} += " ${bindir}/kexecboot /init /proc /mnt"

pkg_postinst_${PN} () {
	ln -sf ${bindir}/kexecboot $D/init
}
