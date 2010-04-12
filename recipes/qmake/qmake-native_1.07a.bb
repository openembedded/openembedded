DESCRIPTION = "TrollTech Makefile Generator"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
SECTION = "devel"
LICENSE = "GPL QPL"
PR = "r5"

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

do_stage() {
	install -m 0755 bin/qmake ${STAGING_BINDIR}
	install -d ${QMAKE_MKSPEC_PATH}
	cp -fPR mkspecs/* ${QMAKE_MKSPEC_PATH}
}

do_install() {
        :
}

SRC_URI[md5sum] = "022d7a3c572b554f3c47b12cae71a8a4"
SRC_URI[sha256sum] = "a97656796c0ef8e87dd83e6138bc406e31830d08f9b213e039d8be39ea65c8e4"
