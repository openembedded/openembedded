DESCRIPTION = "TrollTech Makefile Generator"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SECTION = "devel"
LICENSE = "GPL|QPL"
PR = "r3"

DEFAULT_PREFERENCE = "-1"

QTEVER = "qt-embedded-opensource-4.0.0-b1"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/${QTEVER}.tar.bz2 \
           file://old-moc-compatibility.patch;patch=1 \
           file://old-uic-compatibility.patch;patch=1 \
           file://linux-oe-qmake.conf"
S = "${WORKDIR}/${QTEVER}"

inherit autotools native

export QTDIR = "${S}"
EXTRA_OEMAKE = "-e"

do_configure() {
	# Install the OE build templates (linux, linux-uclibc)
	install -d ${S}/mkspecs/linux-oe-g++
	install -d ${S}/mkspecs/linux-uclibc-oe-g++
	install -m 0644 ${WORKDIR}/linux-oe-qmake.conf \
		${S}/mkspecs/linux-oe-g++/qmake.conf
	ln -sf ../linux-g++/qplatformdefs.h \
		${S}/mkspecs/linux-oe-g++/qplatformdefs.h
	ln -sf ../linux-oe-g++/qmake.conf \
		${S}/mkspecs/linux-uclibc-oe-g++/qmake.conf
	ln -sf ../linux-g++/qplatformdefs.h \
		${S}/mkspecs/linux-uclibc-oe-g++/qplatformdefs.h

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
	cp -dfR mkspecs/* ${QMAKE_MKSPEC_PATH}
}

do_install() {
        :
}
