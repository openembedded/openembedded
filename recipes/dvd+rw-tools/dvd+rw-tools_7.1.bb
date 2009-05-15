DESCRIPTION = "tools to write DVDs"
PR = "r2"
DEPENDS += "m4-native"
RDEPENDS += "cdrkit"
SRC_URI = "http://fy.chalmers.se/~appro/linux/DVD+RW/tools/dvd+rw-tools-${PV}.tar.gz \
           file://01-growisofs-pioneer.dpatch;patch=1 \
           file://02-growisofs-manpage.dpatch;patch=1 \
           file://03-growisofs-dvd-dl.dpatch;patch=1 \
           file://04-kfreebsd.dpatch;patch=1 \
           file://07-beeping.dpatch;patch=1 \
           file://08-cdrkit-code.dpatch;patch=1 \
           file://09-cdrkit-doc.dpatch;patch=1 \
           file://10-includes.dpatch;patch=1 \
          "

do_configure() {
    m4 -DOS=Linux Makefile.m4 >Makefile
}

do_compile() {
    oe_runmake CC="${CC}" CXX="${CXX}" dvd+rw-tools
}

do_install() {
    install -d ${D}/usr/bin
    install -m 755 ${S}/growisofs ${D}/usr/bin
    install -m 755 ${S}/dvd+rw-booktype ${D}/usr/bin
    install -m 755 ${S}/dvd+rw-format ${D}/usr/bin
    install -m 755 ${S}/dvd+rw-mediainfo ${D}/usr/bin
    install -m 755 ${S}/dvd-ram-control ${D}/usr/bin
}

