DESCRIPTION= "Tools to update the Qt fontdir"
MAINTAINER = "M&N Solutions <info@mn-solutions.de>"
SECTION = "opie/base"
LICENSE = "GPL QPL"
PACKAGE_ARCH = "all"
PR = "r3"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-free-${PV}.tar.bz2"
SRC_URI += "file://update-qtfontdir"
S = "${WORKDIR}/qt-embedded-free-${PV}"

do_compile() {
	:
}

do_install() {
	mkdir -p ${D}${sbindir}
	install -m 755 ${WORKDIR}/update-qtfontdir ${D}${sbindir}
	mkdir -p ${D}${palmtopdir}/lib/fonts
	cp -pPR lib/fonts/* ${D}${palmtopdir}/lib/fonts
	# Delete all other font formats, Qt/E would have a dead slow
	# application start time if it had to use any other font format
	# as *.qpf ...
	find ${D}${palmtopdir}/lib/fonts \
	     -name "*.bdf" \
	  -o -name "*.ttf" \
	  -o -name "*.pfa" \
	  -o -name "*.pfb" | xargs rm
}

PACKAGES = "qte-fonts-common"
FILES_${PN} = "${sbindir}"


PACKAGES += "qte-font-fixed"
PROVIDES += "qte-font-fixed"
FILES_qte-font-fixed = "${palmtopdir}/lib/fonts/fixed*"
RDEPENDS_qte-font-fixed = "qte-fonts-common"
pkg_postinst_qte-font-fixed() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-fixed() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

PACKAGES += "qte-font-helvetica-small"
PROVIDES += "qte-font-helvetica-small"
FILES_qte-font-helvetica-small = "${palmtopdir}/lib/fonts/helvetica_80*.qpf \
	${palmtopdir}/lib/fonts/helvetica_100*.qpf ${palmtopdir}/lib/fonts/helvetica_120*.qpf"
RDEPENDS_qte-font-helvetica-small = "qte-fonts-common"
pkg_postinst_qte-font-helvetica-small() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-helvetica-small() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

PACKAGES += "qte-font-helvetica-large"
PROVIDES += "qte-font-helvetica-large"
FILES_qte-font-helvetica-large = "${palmtopdir}/lib/fonts/helvetica_140*.qpf \
	${palmtopdir}/lib/fonts/helvetica_180*.qpf ${palmtopdir}/lib/fonts/helvetica_240*.qpf"
RDEPENDS_qte-font-helvetica-large = "qte-fonts-common"
pkg_postinst_qte-font-helvetica-large() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-helvetica-large() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

PACKAGES += "qte-font-smoothtimes"
PROVIDES += "qte-font-smoothtimes"
FILES_qte-font-smoothtimes = "${palmtopdir}/lib/fonts/smoothtimes*"
RDEPENDS_qte-font-smoothtimes = "qte-fonts-common"
pkg_postinst_qte-font-smoothtimes() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-smoothtimes() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

PACKAGES += "qte-font-smallsmooth"
PROVIDES += "qte-font-smallsmooth"
FILES_qte-font-smallsmooth = "${palmtopdir}/lib/fonts/smallsmooth*"
RDEPENDS_qte-smallsmooth = "qte-fonts-common"
pkg_postinst_qte-font-smallsmooth() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-smallsmooth() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

PACKAGES += "qte-font-unicode"
PROVIDES += "qte-font-unicode"
FILES_qte-font-unicode = "${palmtopdir}/lib/fonts/unifont*.qpf"
RDEPENDS_qte-font-unicode = "qte-fonts-common"
pkg_postinst_qte-font-unicode() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-unicode() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

PACKAGES += "qte-font-micro"
PROVIDES += "qte-font-micro"
FILES_qte-font-micro = "${palmtopdir}/lib/fonts/micro*.qpf"
#RDEPENDS_qte-font-micro = "qte-fonts-common"
pkg_postinst_qte-font-micro() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}
pkg_postrm_qte-font-micro() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
set -e
. /etc/profile
${sbindir}/update-qtfontdir -f
}

# Not in the QtE/3 tar file:
#PACKAGES += "qte-font-lcd"
#PROVIDES += "qte-font-lcd"
#RDEPENDS_qte-font-lcd = "qte-fonts-common"
#FILES_qte-font-lcd = "${palmtopdir}/lib/fonts/lcd*"
#pkg_postinst_qte-font-lcd () {
##!/bin/sh
#if [ -n "$D" ]; then exit 1; fi
#set -e
#. /etc/profile
#${sbindir}/update-qtfontdir
#}
#pkg_postrm_qte-font-lcd() {
##!/bin/sh
#if [ -n "$D" ]; then exit 1; fi
#set -e
#. /etc/profile
#${sbindir}/update-qtfontdir -f
#}

# Not in the QtE/3 tar file:
#PACKAGES += "qte-font-japanese"
#PROVIDES += "qte-font-japanese"
#FILES_qte-font-japanese = "${palmtopdir}/lib/fonts/japanese*"
#RDEPENDS_qte-font-japanese = "qte-fonts-common"
#pkg_postinst_qte-font-japanese() {
##!/bin/sh
#if [ -n "$D" ]; then exit 1; fi
#set -e
#. /etc/profile
#${sbindir}/update-qtfontdir
#}
#pkg_postrm_qte-font-japanese() {
##!/bin/sh
#if [ -n "$D" ]; then exit 1; fi
#set -e
#. /etc/profile
#${sbindir}/update-qtfontdir -f
#}

# Not in the QtE/3 tar file:
#PACKAGES += "qte-font-courier"
#PROVIDES += "qte-font-courier"
#FILES_qte-font-courier = "${palmtopdir}/lib/fonts/cour*"
#RDEPENDS_qte-font-courier = "qte-fonts-common"
#pkg_postinst_qte-font-courier() {
##!/bin/sh
#if [ -n "$D" ]; then exit 1; fi
#set -e
#. /etc/profile
#${sbindir}/update-qtfontdir
#}
#pkg_postrm_qte-font-courier() {
##!/bin/sh
#if [ -n "$D" ]; then exit 1; fi
#set -e
#. /etc/profile
#${sbindir}/update-qtfontdir -f
#}
