DESCRIPTION = "TrollTech Makefile Generator"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
SECTION = "devel"
LICENSE = "GPL QPL"
PR = "r6"

QTEVER = "qt-embedded-free-3.3.5"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/${QTEVER}.tar.bz2 \
           file://linux-oe-qmake.conf"
S = "${WORKDIR}/${QTEVER}"

inherit autotools native

export QTDIR = "${S}"
EXTRA_OEMAKE = "-e"

do_configure() {
	# Install the OE build templates
	for template in linux-oe-g++ linux-uclibc-oe-g++ linux-gnueabi-oe-g++ linux-uclibceabi-oe-g++
	do
		install -d ${S}/mkspecs/$template
		install -m 0644 ${WORKDIR}/linux-oe-qmake.conf ${S}/mkspecs/$template/qmake.conf
		ln -sf ../linux-g++/qplatformdefs.h ${S}/mkspecs/$template/qplatformdefs.h
	done
	QMAKESPEC=
	PLATFORM=${HOST_OS}-oe-g++
	export PLATFORM
	oenote ./configure ${EXTRA_OECONF}
	echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed"
}

do_compile() {
	:
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 bin/qmake ${D}${bindir}
        install -d ${D}${datadir}/qmake
        cp -fPR mkspecs/* ${D}${datadir}/qmake
}

SRC_URI[md5sum] = "022d7a3c572b554f3c47b12cae71a8a4"
SRC_URI[sha256sum] = "a97656796c0ef8e87dd83e6138bc406e31830d08f9b213e039d8be39ea65c8e4"

NATIVE_INSTALL_WORKS = "1"
