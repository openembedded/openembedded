DESCRIPTION = "TrollTech Makefile Generator"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
SECTION = "devel"
LICENSE = "GPL QPL"
PR = "r1"

QTVER = "qt-x11-opensource-src-4.1.1"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/${QTVER}.tar.gz \
           file://linux-oe-qmake.conf"
S = "${WORKDIR}/${QTVER}"

# we need the real target system here
CROSS_SYS := "${TARGET_SYS}"
inherit autotools native

export QTDIR = "${S}"
EXTRA_OEMAKE = "-e"

do_configure() {
        # Install the OE build templates                      
        for template in linux-oe-g++ linux-uclibc-oe-g++ linux-gnueabi-oe-g++
        do      
                install -d ${S}/mkspecs/$template   
                install -m 0644 ${WORKDIR}/linux-oe-qmake.conf ${S}/mkspecs/$template/qmake.conf
                ln -sf ../linux-g++/qplatformdefs.h ${S}/mkspecs/$template/qplatformdefs.h    
        done

	QMAKESPEC=
	PLATFORM=${HOST_OS}-oe-g++
	export PLATFORM
	# yes, TARGET_SYS is correct, because this is a 'cross'-qmake-native :) :M:
	echo yes | ./configure -prefix ${STAGING_DIR}/${CROSS_SYS}/qt4 ${EXTRA_OECONF} || die "Configuring qt failed"
}

do_compile() {
	:
}

do_stage() {
	install -m 0755 bin/qmake ${STAGING_BINDIR}/qmake2
	install -d ${STAGING_DIR}/${CROSS_SYS}/qt4/
	cp -dfR mkspecs ${STAGING_DIR}/${CROSS_SYS}/qt4/
}

do_install() {
        :
}
